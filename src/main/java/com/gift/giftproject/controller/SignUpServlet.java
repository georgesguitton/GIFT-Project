package com.gift.giftproject.controller;

import com.gift.giftproject.controller.command.CreateTutorEntityCommand;
import com.gift.giftproject.controller.service.SignUpService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.gift.giftproject.RouteViewConstants.AUTHENTICATED_HOME_PAGE;
import static com.gift.giftproject.RouteViewConstants.SIGN_UP_PAGE;

@WebServlet(name = "signupServlet", value = "/signup")

public class SignUpServlet extends HttpServlet {
    @Inject
    private SignUpService signUpServiceBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher(SIGN_UP_PAGE).forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        signUpServiceBean.createTutorEntity(new CreateTutorEntityCommand(
                request.getParameter("email"),
                request.getParameter("firstname"),
                request.getParameter("lastname"),
                request.getParameter("password")
        ));

        request.getServletContext().getRequestDispatcher(AUTHENTICATED_HOME_PAGE).forward(request, response);
    }
}
