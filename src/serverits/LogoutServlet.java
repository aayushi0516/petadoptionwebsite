package com.pawsandhearts.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LogoutServlet extends HttpServlet {
    // Handle GET request (Logout the user)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidate the session to log out the user
        HttpSession session = request.getSession(false); // false to not create a new session
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }

        // Redirect to login page
        response.sendRedirect("login.jsp");
    }
}
