package com.gift.giftproject.controller.service;

import com.gift.giftproject.controller.command.CreateStudentWithInternshipEntity;
import com.gift.giftproject.model.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Stateless
public class StudentService {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public void createStudentWithInternshipEntity(TutorEntity tutor, CreateStudentWithInternshipEntity request) {
        final var internship = InternshipEntity.builder()
                .companyName(request.companyName())
                .companyAddress(request.companyAddress())
                .companyTutor(request.tutorName())
                .startDate(request.startDate())
                .endDate(request.endDate())
                .mission(request.mission())
                .isVisitPlanified(false)
                .isVisitDone(false)
                .build();

        final var evaluation = EvaluationsEntity.builder()
                .oralPresentation(false)
                .communicationGrade(0)
                .technicalGrade(0)
                .build();

        final var documents = DocumentstatusEntity.builder()
                .isSpecsDone(false)
                .isVisitFormDone(false)
                .isCompanyEvalFormDone(false)
                .isReportDone(false)
                .isWebPollDone(false)
                .build();

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
}
