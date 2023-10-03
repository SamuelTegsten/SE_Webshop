package com.web.se_webshop.View.Controller;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "RegisterServlet", value = "/register-servlet")
public class RegisterServlet extends HttpServlet {

    // This method handles HTTP POST requests sent to the /register-servlet URL
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Retrieve username and password from the request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if the username and password already exist (dummy implementation)
        boolean usernameExists = checkUsernameExists(username);
        boolean passwordExists = checkPasswordExists(password);

        // Set attributes in the request to indicate whether username and password exist
        request.setAttribute("usernameExists", usernameExists);
        request.setAttribute("passwordExists", passwordExists);

        // Forward the request to an account page (account.jsp)
        RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
        dispatcher.forward(request, response);
    }

    // Dummy method to check if a username already exists (replace with real logic)
    private boolean checkUsernameExists(String username) {
        // Replace this with actual logic to check if the username exists in your system
        // Return true if the username exists, otherwise return false
        return false;
    }

    // Dummy method to check if a password already exists (replace with real logic)
    private boolean checkPasswordExists(String password) {
        // Replace this with actual logic to check if the password exists in your system
        // Return true if the password exists, otherwise return false
        return false;
    }

    // This method is not used in this code, but it's part of the HttpServlet interface
    public void destroy() {
        // Perform any cleanup or resource release here, if needed
    }
}

