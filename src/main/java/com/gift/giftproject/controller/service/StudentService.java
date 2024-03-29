package com.gift.giftproject.controller.service;

import com.gift.giftproject.controller.command.CreateStudentWithInternshipEntity;
import com.gift.giftproject.controller.command.UpdateStudentDetailCommand;
import com.gift.giftproject.model.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Objects;

@Stateless
public class StudentService {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    @Inject
    private DocumentStatusService documentStatusService;

    @Inject
    private EvaluationService evaluationService;

    @Inject
    private InternshipService internshipService;

    public void createStudentWithInternshipEntity(TutorEntity tutor, CreateStudentWithInternshipEntity request) {
        final var internship = internshipService.setInternshipEntity(request);
        final var evaluation = evaluationService.getEmptyEvaluationStatus();
        final var documents = documentStatusService.getEmptyDocumentStatus();

        final var student = StudentEntity.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .studentGroup(request.group())
                .internshipByIdInternship(internship)
                .tutorByIdTutor(tutor)
                .comments("")
                .evaluationsByIdEvaluations(evaluation)
                .documentsByIdDocuments(documents)
                .build();

        final var entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public List<StudentEntity> getTutorStudents(TutorEntity tutor, String query) {
        final var entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createNamedQuery("findStudentsOfTutorId", StudentEntity.class)
                .setParameter("idTutor", tutor.getIdTutor())
                .setParameter("query", Objects.isNull(query) ? "" : query.toLowerCase())
                .getResultList();
    }

    public void deleteStudentById(TutorEntity tutor, int studentId) {
        final var entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.createNamedQuery("deleteStudentOfTutorById")
                    .setParameter("idStudent", studentId)
                    .setParameter("idTutor", tutor.getIdTutor())
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public StudentEntity getStudentById(TutorEntity tutor, int studentId) {
        final var entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createNamedQuery("getStudentOfTutorById", StudentEntity.class)
                .setParameter("idStudent", studentId)
                .setParameter("idTutor", tutor.getIdTutor())
                .getSingleResult();
    }

    public void updateTutorStudent(TutorEntity tutor, int studentId, UpdateStudentDetailCommand request) {
        final var entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            final var student = entityManager.find(StudentEntity.class, getStudentById(tutor, studentId).getId());
            student.setFirstname(request.firstname());
            student.setLastname(request.lastname());
            student.setStudentGroup(request.group());
            student.setComments(request.comments());

            internshipService.setInternshipFromUpdateStudentDetailCommand(
                    student.getInternshipByIdInternship().getIdInternship(),
                    request);

            documentStatusService.setDocumentstatusFromUpdateStudentDetailCommand(
                    student.getDocumentsByIdDocuments().getIdDocumentstatus(),
                    request);

            evaluationService.setEvaluationFromUpdateStudentDetailCommand(
                    student.getEvaluationsByIdEvaluations().getIdEvaluations(),
                    request);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
