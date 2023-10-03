package com.web.se_webshop.Controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    // This method handles HTTP POST requests sent to the /login-servlet URL
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Retrieve username and password from the request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if the login is successful by calling the checkLogin method
        boolean loginSuccessful = checkLogin(username, password);

        if (loginSuccessful) {
            // If login is successful, set a session attribute to indicate no login error
            request.getSession().setAttribute("loginError", false);

            // Redirect the user to a success page (success.jsp)
            response.sendRedirect("success.jsp");

        } else {

            // If login fails, print a message to the console
            System.out.println("Login failed");

            // Set a session attribute to indicate a login error
            request.getSession().setAttribute("loginError", true);

            // Forward the request to an account page (account.jsp)
            RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
            dispatcher.forward(request, response);
        }
    }

    // This private method checks the provided username and password for authentication
    private boolean checkLogin(String username, String password) {
        // In this example, the username and password are hardcoded for demonstration purposes
        // You should replace these with your actual authentication logic
        if ("test".equals(username) && "test".equals(password)) {
            return true;
        }
        return false;
    }

    // This method is not used in this code, but it's part of the HttpServlet interface
    public void destroy() {
        // Perform any cleanup or resource release here, if needed
    }
}

