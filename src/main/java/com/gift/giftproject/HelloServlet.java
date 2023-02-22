package com.gift.giftproject;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static jakarta.servlet.annotation.ServletSecurity.EmptyRoleSemantic.DENY;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = "tutor_role"))
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}