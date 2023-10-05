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

import static com.web.se_webshop.BO.Model.AccountLogic.UserHandler.getUser;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    // This method handles HTTP POST requests sent to the /login-servlet URL
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Retrieve username and password from the request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        try {
            Permission userPermission = checkLogin(username, password);
            if (userPermission != null) {
                // If login succeeds, print a message to the console
                System.out.println("Login Successful");

                // Set the user's role
                session.setAttribute("userRole", userPermission.toString());

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // This private method checks the provided username and password for authentication
    private Permission checkLogin(String username, String password) throws SQLException {
        Permission userPermission = getUser(username, password);
        if(userPermission != null){
            return userPermission;
        } else {
            return null;
        }
    }

    // This method is not used in this code, but it's part of the HttpServlet interface
    public void destroy() {
        // Perform any cleanup or resource release here, if needed
    }
}

