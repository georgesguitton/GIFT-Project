package com.gift.giftproject;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

@FormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/WEB-INF/login.jsp",
                errorPage = "/WEB-INF/login-failed.jsp"))
@DatabaseIdentityStoreDefinition(
        callerQuery = "SELECT password FROM Tutor WHERE email = ?",
        groupsQuery = "SELECT role from Tutor WHERE email = ?"
)
@ApplicationScoped
public class AppConfig {
    @Produces
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;
}
