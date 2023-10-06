package com.web.se_webshop.View.Controller;

import com.web.se_webshop.BO.Model.AccountLogic.UserHandler;
import com.web.se_webshop.View.ObjectView.UserView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "UserTableServlet", value = "/user-table-servlet")
public class UserTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve the list of users using the getUsers method from UserHandler
            ArrayList<UserView> userList = UserHandler.getUsers();

            // Set the list of users as an attribute in the request object
            request.setAttribute("userList", userList);

            // Forward the request to the admin.jsp page
            request.getRequestDispatcher("admin.jsp").forward(request, response);

        } catch (SQLException e) {
            // Handle SQLException (e.g., log the error or show an error page)
            e.printStackTrace();
            // You might want to redirect to an error page here
        }
    }
}

