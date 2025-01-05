package com.pawsandhearts.servlet;

import com.pawsandhearts.model.User;
import com.pawsandhearts.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserProfileServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO(); // Initialize the UserDAO
    }

    // Handle GET request (Display the user's profile)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser"); // Retrieve the logged-in user from the session

        if (loggedInUser != null) {
            // Forward the user to the profile page with their details
            request.setAttribute("user", loggedInUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("login.jsp"); // Redirect to login page if the user is not logged in
        }
    }

    // Handle POST request (Update user profile)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser"); // Get the logged-in user

        if (loggedInUser != null) {
            // Capture the updated profile data
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            // Update the user details
            loggedInUser.setName(name);
            loggedInUser.setEmail(email);

            // Update the user in the database using the UserDAO
            boolean isUpdated = userDAO.updateUserProfile(loggedInUser);

            // Check if the profile update was successful
            if (isUpdated) {
                session.setAttribute("loggedInUser", loggedInUser); // Update the session with the new details
                response.sendRedirect("profile.jsp?success=Profile updated successfully"); // Redirect to profile page with success message
            } else {
                response.sendRedirect("profile.jsp?error=Profile update failed"); // Handle failure
            }
        } else {
            response.sendRedirect("login.jsp"); // Redirect to login page if user is not logged in
        }
    }
}
