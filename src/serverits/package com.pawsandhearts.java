package com.pawsandhearts.servlet;

import com.pawsandhearts.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ProfileServlet extends HttpServlet {
    // Handle GET request (Display the user's profile)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if the user is logged in
        HttpSession session = request.getSession(false); // false to not create a new session if it doesn't exist
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            request.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
            dispatcher.forward(request, response);
        } else {
            // Not logged in, redirect to login page
            response.sendRedirect("login.jsp");
        }
    }
}