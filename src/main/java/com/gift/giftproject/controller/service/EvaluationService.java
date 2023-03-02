package com.gift.giftproject.controller.service;

import com.gift.giftproject.model.EvaluationsEntity;

public class EvaluationService {
    public EvaluationsEntity getEmptyEvaluationStatus() {
        return EvaluationsEntity.builder()
                .oralPresentation(false)
                .communicationGrade(0)
                .technicalGrade(0)
                .build();
    }
}
