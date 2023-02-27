package com.gift.giftproject.controller.service;

import com.gift.giftproject.controller.command.CreateTutorEntityCommand;
import com.gift.giftproject.model.TutorEntity;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import jakarta.transaction.Transactional;

@Stateless
public class SignUpService {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    @Inject
    private Pbkdf2PasswordHash passwordHash;

    @Transactional
    public void createTutorEntity(CreateTutorEntityCommand request) {
        final var tutor = TutorEntity.builder()
                .email(request.email())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .password(passwordHash.generate(request.password().toCharArray()))
                .role("tutor_role")
                .build();

        final var entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tutor);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
