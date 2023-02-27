package com.gift.giftproject.controller.service;

import com.gift.giftproject.controller.command.CreateTutorEntityCommand;
import com.gift.giftproject.model.TutorEntity;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

@Stateless
public class SignUpServiceBean {
    @Inject
    private EntityManager entityManager;

    @Inject
    private Pbkdf2PasswordHash passwordHash;

    public TutorEntity createTutorEntity(CreateTutorEntityCommand request) {
        final var tutor = TutorEntity.builder()
                .email(request.email())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .password(passwordHash.generate(request.password().toCharArray()))
                .build();

        entityManager.persist(tutor);
        return tutor;
    }
}
