package com.gift.giftproject.controller;

import com.gift.giftproject.controller.service.StudentService;
import com.gift.giftproject.controller.service.TutorService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.gift.giftproject.RouteViewConstants.AUTHENTICATED_HOME_PATH;

@WebServlet(name = "destroyStudentServlet", value = "/destroy-student")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = "tutor_role"))
public class DestroyStudentServlet extends HttpServlet {
    @Inject
    private StudentService studentService;

    @Inject
    private TutorService tutorService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        final var tutor = tutorService.getTutorByEmail(request.getRemoteUser());

        studentService.deleteStudentById(
                tutor,
                Integer.parseInt(request.getParameter("studentId"))
        );

        response.sendRedirect(request.getContextPath() + AUTHENTICATED_HOME_PATH);
    }
}
