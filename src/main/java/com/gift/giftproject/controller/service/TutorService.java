package com.gift.giftproject.controller.service;

import com.gift.giftproject.controller.command.UpdateSingleStudentInBulkCommand;
import com.gift.giftproject.model.StudentEntity;
import com.gift.giftproject.model.TutorEntity;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletRequest;

import java.util.Arrays;
import java.util.Objects;

@Stateless
public class TutorService {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    @Inject
    StudentService studentService;

    public TutorEntity getTutorByEmail(String email) {
        final var entityManager = entityManagerFactory.createEntityManager();

        final var query = entityManager.createNamedQuery("findTutorByEmail", TutorEntity.class);
        query.setParameter("email", email);

        return query.getSingleResult();
    }

    public void updateBatchStudentDocumentStatuses(TutorEntity tutor, String[] studentIds, ServletRequest request) {
        final var entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            final var parsedStudentIds = Arrays.stream(studentIds).mapToInt(Integer::parseInt).toArray();

            for (final var studentId : parsedStudentIds) {
                final var student = entityManager.find(StudentEntity.class, studentService.getStudentById(tutor, studentId).getId());
                final var updateRequest = getUpdateRequestFromBulk(request, studentId);

                student.getDocumentsByIdDocuments().setReportDone(updateRequest.reportDone());
                student.getDocumentsByIdDocuments().setCompanyEvalFormDone(updateRequest.companyFormDone());
                student.getDocumentsByIdDocuments().setWebPollDone(updateRequest.webPollDone());
                student.getDocumentsByIdDocuments().setSpecsDone(updateRequest.specDone());
                student.getDocumentsByIdDocuments().setVisitFormDone(updateRequest.visitFormDone());

                student.getInternshipByIdInternship().setVisitDone(updateRequest.visitDone());
                student.getInternshipByIdInternship().setVisitPlanified(updateRequest.visitPlaned());

                System.out.println(student.getDocumentsByIdDocuments().isWebPollDone());
            }

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }

    }

    private UpdateSingleStudentInBulkCommand getUpdateRequestFromBulk(ServletRequest request, int studentId) {
        return new UpdateSingleStudentInBulkCommand(
                !Objects.isNull(request.getParameter("student" + studentId + "_specsDone")),
                !Objects.isNull(request.getParameter("student" + studentId + "_visitFormDone")),
                !Objects.isNull(request.getParameter("student" + studentId + "_companyEvalFormDone")),
                !Objects.isNull(request.getParameter("student" + studentId + "_webPollDone")),
                !Objects.isNull(request.getParameter("student" + studentId + "_reportDone")),
                !Objects.isNull(request.getParameter("student" + studentId + "_visitPlanified")),
                !Objects.isNull(request.getParameter("student" + studentId + "_visitDone"))

        );
    }
}

