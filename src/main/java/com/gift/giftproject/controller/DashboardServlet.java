package com.gift.giftproject.controller;

import java.io.*;

import com.gift.giftproject.controller.service.StudentService;
import com.gift.giftproject.controller.service.TutorService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static com.gift.giftproject.RouteViewConstants.DASHBOARD_PAGE;

@WebServlet(name = "dashboardServlet", urlPatterns = { "/index.html", "/my-dashboard" })
@ServletSecurity(value = @HttpConstraint(rolesAllowed = "tutor_role"))
public class DashboardServlet extends HttpServlet {
    @Inject
    private StudentService studentService;

    @Inject
    private TutorService tutorService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // to handle form redirection on successful login
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final var tutor = tutorService.getTutorByEmail(request.getRemoteUser());
        final var searchQuery = request.getParameter("searchQuery");

        request.setAttribute("students", studentService.getTutorStudents(tutor, searchQuery));
        request.setAttribute("tutorName", tutor.getFirstname() + " " + tutor.getLastname());
        request.setAttribute("query", searchQuery);

        request.getServletContext().getRequestDispatcher(DASHBOARD_PAGE).forward(request, response);
    }
}