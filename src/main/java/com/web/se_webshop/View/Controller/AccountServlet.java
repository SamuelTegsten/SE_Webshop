package com.web.se_webshop.View.Controller;

import java.io.IOException;
import java.sql.SQLException;

import com.web.se_webshop.BO.Model.AccountLogic.Permission;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

import static com.web.se_webshop.BO.Model.AccountLogic.UserHandler.addUser;
import static com.web.se_webshop.BO.Model.AccountLogic.UserHandler.getUser;

/**
 * Handles user login and registration operations via HTTP POST requests.
 */
@WebServlet(name = "AccountServlet", value = "/account-servlet")
public class AccountServlet extends HttpServlet {

    /**
     * This method handles HTTP POST requests sent to the /account-servlet URL.
     *
     * @param request  The HttpServletRequest object representing the HTTP request.
     * @param response The HttpServletResponse object representing the HTTP response.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        // Retrieve username and password from the request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if username and password are provided in the request
        if (username != null && password != null) {
            // Attempt to log in the user
            loginUser(request, response, session, username, password);
        }

        String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newPassword");

        // Check if new username and password are provided in the request
        if (newUsername != null && newPassword != null) {
            // Attempt to register a new user
            registerUser(request, response, session, newUsername, newPassword);
        }
    }

    /**
     * Method to handle user login.
     *
     * @param request   The HttpServletRequest object representing the HTTP request.
     * @param response  The HttpServletResponse object representing the HTTP response.
     * @param session   The HttpSession object for managing user sessions.
     * @param username  The username provided for login.
     * @param password  The password provided for login.
     */
    private void loginUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, String username, String password) {
        try {
            // Attempt to retrieve user permission
            Permission userPermission = getUser(username, password);
            if (userPermission != null) {
                // If login succeeds, print a message to the console
                System.out.println("Login Successful");

                // Set the user's role in the session
                session.setAttribute("userRole", userPermission.toString());

                // Set the logged-in username in the session for display
                session.setAttribute("userName", username);

                // If login is successful, set a session attribute to indicate no login error
                session.setAttribute("loginError", false);

                // Redirect the user to a success page (success.jsp)
                response.sendRedirect("success.jsp");
            } else {
                // If login fails, print a message to the console
                System.out.println("Login failed");

                // Set a session attribute to indicate a login error
                session.setAttribute("loginError", true);

                // Forward the request to an account page (account.jsp)
                RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException | IOException | ServletException e) {
            // Handle exceptions by throwing a runtime exception for simplicity
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to handle user registration.
     *
     * @param request    The HttpServletRequest object representing the HTTP request.
     * @param response   The HttpServletResponse object representing the HTTP response.
     * @param session    The HttpSession object for managing user sessions.
     * @param newUsername The new username provided for registration.
     * @param newPassword The new password provided for registration.
     */
    private void registerUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, String newUsername, String newPassword) {
        try {
            // Attempt to add a new user
            boolean checkUser = addUser(newUsername, newPassword, Permission.USER);
            if (checkUser) {
                // If registration is successful, print a message to the console
                System.out.println("User Registered: " + newUsername);

                // Set the user's role to USER
                session.setAttribute("userRole", Permission.USER.toString());

                // Set the registered username in the session for display
                session.setAttribute("userName", newUsername);

                // Set a session attribute to indicate that the account doesn't exist error
                session.setAttribute("accountExists", false);

                // Redirect the user to a success page (success.jsp)
                response.sendRedirect("success.jsp");
            } else {
                // If registration fails, print a message to the console
                System.out.println("User failed to Register: " + newUsername);

                // Set a session attribute to indicate that the account exists error
                session.setAttribute("accountExists", true);

                // Forward the request to an account page (account.jsp)
                RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException | IOException | ServletException e) {
            // Handle exceptions by throwing a runtime exception for simplicity
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is not used in this code, but it's part of the HttpServlet interface.
     */
    public void destroy() {
        // Perform any cleanup or resource release here, if needed
    }
}
