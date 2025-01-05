package SERVERS.SERVELET;

import com.pawsandhearts.dao.UserDAO;
import com.pawsandhearts.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO(); // Initialize the UserDAO
    }

    // Handle GET request (Display the registration form)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
        dispatcher.forward(request, response);
    }

    // Handle POST request (Process registration)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        // Create a User object and set its properties
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setPhoneNumber(phone);
        newUser.setAddress(address);

        // Insert the user into the database
        boolean isSuccess = userDAO.registerUser(newUser);

        if (isSuccess) {
            // Redirect to login page on successful registration
            response.sendRedirect("login.jsp");
        } else {
            // If registration fails, show an error message
            request.setAttribute("error", "Registration failed. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
        }
    }
}
