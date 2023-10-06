package com.web.se_webshop.View.Controller;

import com.web.se_webshop.View.ObjectView.ItemView;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.web.se_webshop.BO.Model.ItemLogic.ItemHandler.*;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
@WebServlet(name = "AddItemServlet", value = "/item-servlet")
public class ItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String command = request.getParameter("command");

        switch (command) {
            case "ADD":
                addItemServlet(request, response);
                break;
            case "SEARCH":
                searchItemServlet(request,response);
                break;
            case "DISPLAY":
                displayAllItems(request, response);
                break;
            default:
                // Handle other cases or display an error message if needed.
                break;
        }
    }

    private void displayAllItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ItemView> allItems = getAllItems();
        request.setAttribute("display-items", allItems);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
    
    private void searchItemServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ItemView> foundItems;
        String searchText = request.getParameter("search_text");
        foundItems = searchItem(searchText);
        request.setAttribute("found-items", foundItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
        dispatcher.forward(request,response);
    }

    private void addItemServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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