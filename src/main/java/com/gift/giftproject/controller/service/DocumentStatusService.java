package com.gift.giftproject.controller.service;

import com.gift.giftproject.controller.command.UpdateStudentDetailCommand;
import com.gift.giftproject.model.DocumentstatusEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Stateless
public class DocumentStatusService {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public DocumentstatusEntity getEmptyDocumentStatus() {
        return DocumentstatusEntity.builder()
                .isSpecsDone(false)
                .isVisitFormDone(false)
                .isCompanyEvalFormDone(false)
                .isReportDone(false)
                .isWebPollDone(false)
                .build();
    }

    public void setDocumentstatusFromUpdateStudentDetailCommand(int documentId, UpdateStudentDetailCommand request) {
        final var entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            final var document = entityManager.find(DocumentstatusEntity.class, documentId);

            document.setSpecsDone(request.specDone());
            document.setVisitFormDone(request.visitDone());
            document.setCompanyEvalFormDone(request.companyFormDone());
            document.setWebPollDone(request.webPollDone());
            document.setReportDone(request.reportDone());

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
