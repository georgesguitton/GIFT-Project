package com.gift.giftproject.controller;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static com.gift.giftproject.RouteViewConstants.DASHBOARD_PAGE;

@WebServlet(name = "dashboardServlet", value = "/my-dashboard")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = "tutor_role"))
public class DashboardServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher(DASHBOARD_PAGE).forward(request, response);
    }
}