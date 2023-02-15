package com.gift.giftproject.service;

import com.gift.giftproject.model.UserEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Collection;

@Stateless
public class UserSessionBean {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public UserEntity getUserByUsername(String username) {
        return (UserEntity) entityManager.createQuery("select u from UserEntity u where u.username = :username")
                .setParameter("username", username)
                .getSingleResult();
    }

    public UserEntity registerUser(CreateUserCommand command) {
        final var userEntity = new UserEntity();
        userEntity.setUsername(command.username());
        userEntity.setPassword(command.password());

        entityManager.persist(userEntity);
        return userEntity;
    }
}
