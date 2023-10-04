package com.web.se_webshop.View.Controller;

import com.web.se_webshop.DB.DBManager.DBConnect;
import com.web.se_webshop.View.ObjectView.ItemView;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static com.web.se_webshop.BO.Model.ItemLogic.ItemHandler.addItem;

@WebServlet(name = "ItemServlet", value = "/item-servlet")
public class ItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Retrieve information from request
        String name = request.getParameter("item_name");
        String category = request.getParameter("item_category");
        float price = Float.parseFloat(request.getParameter("item_price"));
        int stockNumber = Integer.parseInt(request.getParameter("item_amount"));

        boolean addItemSuccess;
        try {
            addItemSuccess = addItem(new ItemView(name, "pic3", category, price, stockNumber));
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