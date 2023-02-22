package com.gift.giftproject;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import jakarta.security.enterprise.identitystore.IdentityStore;

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
}
