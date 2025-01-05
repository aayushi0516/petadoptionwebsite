package com.pawsandhearts.servlet;

import com.pawsandhearts.dao.UserDAO;
import com.pawsandhearts.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO(); // Initialize the UserDAO
    }

    // Handle GET request (Display the login form)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the login page
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    // Handle POST request (Process login)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Authenticate the user
        User user = userDAO.authenticate(email, password);
        
        if (user != null) {
            // Set the user session
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // Store user object in session

            // Redirect to profile page
            response.sendRedirect("profile.jsp");
        } else {
            // Invalid credentials, show error message
            request.setAttribute("error", "Invalid email or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
