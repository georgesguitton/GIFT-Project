package com.gift.giftproject.controller.service;

import com.gift.giftproject.controller.command.CreateStudentWithInternshipEntity;
import com.gift.giftproject.controller.command.UpdateStudentDetailCommand;
import com.gift.giftproject.model.InternshipEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Stateless
public class InternshipService {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

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

    public void setInternshipFromUpdateStudentDetailCommand(int internshipId, UpdateStudentDetailCommand request) {
        final var entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            final var internship = entityManager.find(InternshipEntity.class, internshipId);

            internship.setCompanyName(request.companyName());
            internship.setCompanyAddress(request.companyAddress());
            internship.setCompanyTutor(request.tutorName());
            internship.setStartDate(request.startDate());
            internship.setEndDate(request.endDate());
            internship.setMission(request.mission());
            internship.setVisitPlanified(request.visitPlaned());
            internship.setVisitDone(request.visitDone());

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
