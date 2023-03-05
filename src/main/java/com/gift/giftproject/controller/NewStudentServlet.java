package com.gift.giftproject.controller;

import com.gift.giftproject.controller.command.CreateStudentWithInternshipEntity;
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
import java.sql.Date;

import static com.gift.giftproject.RouteViewConstants.ADD_STUDENT_PAGE;
import static com.gift.giftproject.RouteViewConstants.AUTHENTICATED_HOME_PATH;

@WebServlet(name = "newStudentServlet", value = "/new-student")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = "tutor_role"))
public class NewStudentServlet extends HttpServlet {
    @Inject
    private StudentService studentService;

    @Inject
    private TutorService tutorService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final var tutor = tutorService.getTutorByEmail(request.getRemoteUser());
        request.setAttribute("tutorName", tutor.getFirstname() + " " + tutor.getLastname());

        request.getServletContext().getRequestDispatcher(ADD_STUDENT_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        final var tutor = tutorService.getTutorByEmail(request.getRemoteUser());

        studentService.createStudentWithInternshipEntity(
                tutor,
                new CreateStudentWithInternshipEntity(
                        request.getParameter("firstname"),
                        request.getParameter("lastname"),
                        request.getParameter("group"),
                        request.getParameter("companyname"),
                        request.getParameter("companyaddress"),
                        request.getParameter("tutorname"),
                        Date.valueOf(request.getParameter("startdate")),
                        Date.valueOf(request.getParameter("enddate")),
                        request.getParameter("mission")
                )
        );

        response.sendRedirect(request.getContextPath() + AUTHENTICATED_HOME_PATH);
    }
}
