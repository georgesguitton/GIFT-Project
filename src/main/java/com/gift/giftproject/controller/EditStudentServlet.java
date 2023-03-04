package com.gift.giftproject.controller;

import com.gift.giftproject.controller.command.UpdateStudentDetailCommand;
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
import java.util.Objects;

import static com.gift.giftproject.RouteViewConstants.*;


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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        final var tutor = tutorService.getTutorByEmail(request.getRemoteUser());

        studentService.updateTutorStudent(
                tutor,
                Integer.parseInt(request.getParameter("studentId")),
                new UpdateStudentDetailCommand(
                        request.getParameter("firstname"),
                        request.getParameter("lastname"),
                        request.getParameter("group"),
                        request.getParameter("companyname"),
                        request.getParameter("companyaddress"),
                        request.getParameter("tutorname"),
                        Date.valueOf(request.getParameter("startdate")),
                        Date.valueOf(request.getParameter("enddate")),
                        request.getParameter("mission"),
                        !Objects.isNull(request.getParameter("specDone")),
                        !Objects.isNull(request.getParameter("visitFormDone")),
                        !Objects.isNull(request.getParameter("companyEvalFormDone")),
                        !Objects.isNull(request.getParameter("webPollDone")),
                        !Objects.isNull(request.getParameter("reportDone")),
                        request.getParameter("comments"),
                        !Objects.isNull(request.getParameter("visitPlanified")),
                        !Objects.isNull(request.getParameter("visitDone")),
                        Double.parseDouble(request.getParameter("technicalgrade")),
                        Double.parseDouble(request.getParameter("communicationgrade")),
                        !Objects.isNull(request.getParameter("oralPresentationDone"))
                )
        );

        response.sendRedirect(request.getContextPath() + EDIT_STUDENT_PATH + "?studentId=" + request.getParameter("studentId"));
    }
}
