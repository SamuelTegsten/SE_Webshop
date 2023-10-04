package com.web.se_webshop.View.Controller;

import com.web.se_webshop.View.ObjectView.ItemView;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


import java.io.IOException;
import java.sql.SQLException;

import static com.web.se_webshop.BO.Model.ItemLogic.ItemHandler.addItem;
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
@WebServlet(name = "AddItemServlet", value = "/add-item-servlet")
public class AddItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Retrieve information from request
        String name = request.getParameter("item_name");
        String fileName = "Style/Pictures/" + request.getPart("item_image").getSubmittedFileName();
        String category = request.getParameter("item_category");
        float price = Float.parseFloat(request.getParameter("item_price"));
        int stockNumber = Integer.parseInt(request.getParameter("item_amount"));

        boolean addItemSuccess;
        try {
            addItemSuccess = addItem(new ItemView(name, fileName, category, price, stockNumber));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (addItemSuccess) {
            System.out.println("addItemSuccess!");

            // Forward the request to an account page (orders.jsp)
            RequestDispatcher dispatcher = request.getRequestDispatcher("orders.jsp");
            dispatcher.forward(request, response);

        } else {
            System.out.println("Not possible to add Item");

            // Forward the request to an account page (orders.jsp)
            RequestDispatcher dispatcher = request.getRequestDispatcher("orders.jsp");
            dispatcher.forward(request, response);
        }
    }
}