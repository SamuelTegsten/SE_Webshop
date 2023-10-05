package com.web.se_webshop.View.Controller;

import com.web.se_webshop.BO.Model.AccountLogic.Permission;
import com.web.se_webshop.View.ObjectView.UserView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.web.se_webshop.BO.Model.AccountLogic.UserHandler.*;

/**
 * Servlet for handling admin-related actions such as adding and removing users.
 */
@WebServlet(name = "AdminServlet", value = "/admin-servlet")
public class AdminServlet extends HttpServlet {

    /**
     * Handle HTTP POST requests.
     *
     * @param request  The HttpServletRequest object representing the HTTP request.
     * @param response The HttpServletResponse object representing the HTTP response.
     * @throws IOException      If there is an I/O error.
     * @throws ServletException If there is a servlet-related error.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        editUsers(request, response);
    }

    /**
     * Handle user editing actions such as adding or removing users.
     *
     * @param request  The HttpServletRequest object representing the HTTP request.
     * @param response The HttpServletResponse object representing the HTTP response.
     * @throws ServletException If there is a servlet-related error.
     * @throws IOException      If there is an I/O error.
     */
    private void editUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the action parameter from the request
        String action = request.getParameter("action");

        // If the action is to add a user
        if ("addUser".equals(action)) {
            String username = request.getParameter("addUserUsername");
            String password = request.getParameter("addUserPassword");

            boolean addUserResult = false;
            try {
                // Attempt to add a user
                addUserResult = addUserFromView(username, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Set attributes to indicate the result of the user addition
            if (addUserResult) {
                request.setAttribute("addUserActionCompleted", "Add User: ");
                request.setAttribute("addUserMessage", "User added successfully.");
            } else {
                request.setAttribute("addUserActionCompleted", "Add User: ");
                request.setAttribute("addUserMessage", "Failed to add user.");
            }
            // Forward the request to admin.jsp for rendering
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }
        // If the action is to remove a user
        else if ("removeUser".equals(action)) {
            String usernameToRemove = request.getParameter("removeUserUsername");

            boolean removeUserResult = false;
            try {
                // Attempt to remove a user
                removeUserResult = removeUserFromView(usernameToRemove);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Set attributes to indicate the result of the user removal
            if (removeUserResult) {
                request.setAttribute("removeUserActionCompleted", "Remove User: ");
                request.setAttribute("removeUserMessage", "User removed successfully.");
            } else {
                request.setAttribute("removeUserActionCompleted", "Remove User");
                request.setAttribute("removeUserMessage", "Failed to remove user.");
            }

            // Forward the request to admin.jsp for rendering
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }
    }

    // Helper method to add a user with a specific permission
    private boolean addUserFromView(String username, String password) throws SQLException {
        return addUser(username, password, Permission.USER);
    }

    // Helper method to remove a user
    private boolean removeUserFromView(String username) throws SQLException {
        return removeUser(username);
    }

    // Helper method to add a staff member with a specific permission
    private boolean addStaffFromView(String username, String password) throws SQLException {
        return addUser(username, password, Permission.STAFF);
    }

    // Helper method to remove a staff member
    private boolean removeStaffFromView(String username) throws SQLException {
        return removeUser(username);
    }

    // Helper method to add an admin with a specific permission
    private boolean addAdminFromView(String username, String password) throws SQLException {
        return addUser(username, password, Permission.ADMIN);
    }

    // Helper method to remove an admin
    private boolean removeAdminFromView(String username, String password) throws SQLException {
        return removeAdmin(username, password);
    }
}
