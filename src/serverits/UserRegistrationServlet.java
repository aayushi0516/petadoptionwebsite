package com.pawsandhearts.servlet;

import com.pawsandhearts.model.User;
import com.pawsandhearts.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserRegistrationServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO(); // Initialize the UserDAO (for database interactions)
    }

    // Handle GET request (Display the registration form)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the registration form page
        RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
        dispatcher.forward(request, response);
    }

    // Handle POST request (Process the registration form)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create a new User object
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);

        // Save the user in the database using UserDAO
        boolean isRegistered = userDAO.registerUser(newUser);

        // Check if registration was successful
        if (isRegistered) {
            response.sendRedirect("login.jsp"); // Redirect to the login page after successful registration
        } else {
            response.sendRedirect("registration.jsp?error=User already exists"); // Handle registration failure
        }
    }
}
