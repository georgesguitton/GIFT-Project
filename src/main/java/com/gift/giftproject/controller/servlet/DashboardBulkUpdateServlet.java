package com.gift.giftproject.controller.servlet;

import com.gift.giftproject.controller.service.TutorService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.gift.giftproject.RouteViewConstants.AUTHENTICATED_HOME_PATH;

@WebServlet(name = "dashboardBulkUpdateServlet", value = "/bulk-update")
public class DashboardBulkUpdateServlet extends HttpServlet {
    @Inject
    TutorService tutorService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final var tutor = tutorService.getTutorByEmail(request.getRemoteUser());
        final var studentIds = request.getParameterValues("studentIds");

        tutorService.updateBatchStudentDocumentStatuses(tutor, studentIds, request);

        response.sendRedirect(request.getContextPath() + AUTHENTICATED_HOME_PATH);
    }
}
