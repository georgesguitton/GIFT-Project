package com.gift.giftproject.controller.service;

import com.gift.giftproject.controller.command.UpdateStudentDetailCommand;
import com.gift.giftproject.model.EvaluationsEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Stateless
public class EvaluationService {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public EvaluationsEntity getEmptyEvaluationStatus() {
        return EvaluationsEntity.builder()
                .oralPresentation(false)
                .communicationGrade(0)
                .technicalGrade(0)
                .build();
    }

    public void setEvaluationFromUpdateStudentDetailCommand(int evaluationId, UpdateStudentDetailCommand request) {
        final var entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            final var evaluation = entityManager.find(EvaluationsEntity.class, evaluationId);

            evaluation.setCommunicationGrade(request.communicationGrade());
            evaluation.setTechnicalGrade(request.technicalGrade());
            evaluation.setOralPresentation(request.oralPresentationDone());

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
