package com.web.se_webshop.View.Controller;

import com.web.se_webshop.BO.Model.AccountLogic.Permission;
import com.web.se_webshop.BO.Model.AccountLogic.UserHandler;
import com.web.se_webshop.View.ObjectView.UserView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import static com.web.se_webshop.BO.Model.AccountLogic.UserHandler.*;

/**
 * Servlet for handling admin-related actions such as adding and removing users, staff members, and admins.
 */
@WebServlet(name = "AdminServlet", value = "/admin-servlet")
public class AdminServlet extends UserHandler {

    /**
     * Handle HTTP POST requests.
     *
     * @param request  The HttpServletRequest object representing the HTTP request.
     * @param response The HttpServletResponse object representing the HTTP response.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            editUsers(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Handle user editing actions such as adding or removing users, staff members, and admins.
     *
     * @param request  The HttpServletRequest object representing the HTTP request.
     * @param response The HttpServletResponse object representing the HTTP response.
     * @throws ServletException If there is a servlet-related error.
     * @throws IOException      If there is an I/O error.
     */
    private void editUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        // If the action is to add a user
        if ("addUser".equals(action)) {
            String username = request.getParameter("addUserUsername");
            String password = request.getParameter("addUserPassword");

            boolean addUserResult = false;
            try {
                addUserResult = addUserFromView(username, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

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
                removeUserResult = removeUserFromView(usernameToRemove);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

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

        // Add staff members
        if ("addStaff".equals(action)) {
            String staffUsername = request.getParameter("addStaffUsername");
            String staffPassword = request.getParameter("addStaffPassword");

            boolean addStaffResult = false;
            try {
                addStaffResult = addStaffFromView(staffUsername, staffPassword);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (addStaffResult) {
                request.setAttribute("addStaffActionCompleted", "Add Staff Member: ");
                request.setAttribute("addStaffMessage", "Staff member added successfully.");
            } else {
                request.setAttribute("addStaffActionCompleted", "Add Staff Member: ");
                request.setAttribute("addStaffMessage", "Failed to add staff member.");
            }

            // Forward the request to admin.jsp for rendering
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else if ("removeStaff".equals(action)) {
            String staffUsernameToRemove = request.getParameter("removeStaffUsername");

            boolean removeStaffResult = false;
            try {
                removeStaffResult = removeStaffFromView(staffUsernameToRemove);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (removeStaffResult) {
                request.setAttribute("removeStaffActionCompleted", "Remove Staff Member: ");
                request.setAttribute("removeStaffMessage", "Staff member removed successfully.");
            } else {
                request.setAttribute("removeStaffActionCompleted", "Remove Staff Member: ");
                request.setAttribute("removeStaffMessage", "Failed to remove staff member.");
            }

            // Forward the request to admin.jsp for rendering
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else if ("addAdmin".equals(action)) {
            String adminUsername = request.getParameter("addAdminUsername");
            String adminPassword = request.getParameter("addAdminPassword");

            boolean addAdminResult = false;
            try {
                addAdminResult = addAdminFromView(adminUsername, adminPassword);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (addAdminResult) {
                request.setAttribute("addAdminActionCompleted", "Add Admin: ");
                request.setAttribute("addAdminMessage", "Admin added successfully.");
            } else {
                request.setAttribute("addAdminActionCompleted", "Add Admin: ");
                request.setAttribute("addAdminMessage", "Failed to add admin.");
            }

            // Forward the request to admin.jsp for rendering
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else if ("removeAdmin".equals(action)) {
            String adminUsernameToRemove = request.getParameter("removeAdminUsername");
            String adminPasswordToRemove = request.getParameter("removeAdminPassword");

            boolean removeAdminResult = false;
            try {
                removeAdminResult = removeAdminFromView(adminUsernameToRemove, adminPasswordToRemove);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (removeAdminResult) {
                request.setAttribute("removeAdminActionCompleted", "Remove Admin: ");
                request.setAttribute("removeAdminMessage", "Admin removed successfully.");
            } else {
                request.setAttribute("removeAdminActionCompleted", "Remove Admin: ");
                request.setAttribute("removeAdminMessage", "Failed to remove admin.");
            }
            // Forward the request to admin.jsp for rendering
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }
    }

    private boolean addUserFromView(String username, String password) throws SQLException {
        return addUser(username, password, Permission.USER);
    }

    private boolean removeUserFromView(String username) throws SQLException {
        return removeUser(username);
    }

    private boolean addStaffFromView(String username, String password) throws SQLException {
        return addUser(username, password, Permission.STAFF);
    }

    private boolean removeStaffFromView(String username) throws SQLException {
        return removeUser(username);
    }

    private boolean addAdminFromView(String username, String password) throws SQLException {
        return addUser(username, password, Permission.ADMIN);
    }

    private boolean removeAdminFromView(String username, String password) throws SQLException {
        return removeAdmin(username, password);
    }
}
