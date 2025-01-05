package SERVERS.SERVELET;

import com.pawsandhearts.dao.UserDAO;
import com.pawsandhearts.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ProfileUpdateServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    // Handle GET request (Display the profile update form)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            request.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("profile_update.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    // Handle POST request (Update user profile)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            user.setName(name);
            user.setPhoneNumber(phone);
            user.setAddress(address);

            boolean isUpdated = userDAO.updateUserProfile(user);
            if (isUpdated) {
                session.setAttribute("user", user);
                response.sendRedirect("profile.jsp");
            } else {
                request.setAttribute("error", "Profile update failed. Please try again.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("profile_update.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
