package com.gift.giftproject;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@FormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/WEB-INF/login.jsp",
                errorPage = "/login-failed"))
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:/GIFTProjectDS",
        callerQuery = "SELECT password FROM tutor WHERE email = ?",
        groupsQuery = "SELECT role from tutor WHERE email = ?")
@ApplicationScoped
@ApplicationPath("/api")
public class AppConfig extends Application {
}
