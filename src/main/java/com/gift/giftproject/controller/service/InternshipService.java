package com.gift.giftproject.controller.service;

import com.gift.giftproject.controller.command.CreateStudentWithInternshipEntity;
import com.gift.giftproject.model.InternshipEntity;
import jakarta.ejb.Stateless;

@Stateless
public class InternshipService {
    public InternshipEntity setInternshipEntity(CreateStudentWithInternshipEntity request) {
        return InternshipEntity.builder()
                .companyName(request.companyName())
                .companyAddress(request.companyAddress())
                .companyTutor(request.tutorName())
                .startDate(request.startDate())
                .endDate(request.endDate())
                .mission(request.mission())
                .isVisitPlanified(false)
                .isVisitDone(false)
                .build();
    }
}
