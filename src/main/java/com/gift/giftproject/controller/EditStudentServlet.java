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

import static com.gift.giftproject.RouteViewConstants.EDIT_STUDENT_PAGE;

@WebServlet(name = "showStudentServlet", value = "/edit-student")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = "tutor_role"))
public class EditStudentServlet extends HttpServlet {
    @Inject
    private StudentService studentService;

    @Inject
    private TutorService tutorService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final var tutor = tutorService.getTutorByEmail(request.getRemoteUser());

        final var student = studentService.getStudentById(
                tutor,
                Integer.parseInt(request.getParameter("studentId"))
        );

        request.setAttribute("student", student);

        final var dateFormatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
        request.setAttribute("startdate", dateFormatter.format(student.getInternshipByIdInternship().getStartDate()));
        request.setAttribute("enddate", dateFormatter.format(student.getInternshipByIdInternship().getEndDate()));


        request.getServletContext().getRequestDispatcher(EDIT_STUDENT_PAGE).forward(request, response);
    }
}
