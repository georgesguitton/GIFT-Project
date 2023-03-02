package com.gift.giftproject.controller.service;

import com.gift.giftproject.model.DocumentstatusEntity;
import jakarta.ejb.Stateless;

@Stateless
public class DocumentStatusService {
    public DocumentstatusEntity getEmptyDocumentStatus() {
        return DocumentstatusEntity.builder()
                .isSpecsDone(false)
                .isVisitFormDone(false)
                .isCompanyEvalFormDone(false)
                .isReportDone(false)
                .isWebPollDone(false)
                .build();
    }
}
