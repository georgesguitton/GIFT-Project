package com.gift.giftproject.controller.service;

import com.gift.giftproject.model.TutorEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Stateless
public class TutorService {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public TutorEntity getTutorByEmail(String email) {
        final var entityManager = entityManagerFactory.createEntityManager();

        final var query = entityManager.createNamedQuery("findTutorByEmail", TutorEntity.class);
        query.setParameter("email", email);

        return query.getSingleResult();
    }
}

