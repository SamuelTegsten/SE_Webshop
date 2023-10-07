package com.web.se_webshop.View.Controller;

import com.web.se_webshop.BO.Model.ItemLogic.ItemHandler;
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

import static com.web.se_webshop.BO.Model.ItemLogic.ItemHandler.getAllItems;

/**
 * Servlet responsible for handling operations related to items, including adding, searching, updating, displaying, and removing items.
 */
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
                addItem(request, response);
                break;
            case "SEARCH":
                searchItem(request,response);
                break;
            case "UPDATE":
                try {
                    updateItem(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "DISPLAY":
                displayAllItems(request, response);
                break;
            case "REMOVE":
                try {
                    removeItemServlet(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    /**
     * Updates an item's picture and category, and forwards the request to the orders page.
     *
     * @param request  The HTTP request object.
     * @param response The HTTP response object.
     * @throws ServletException if a servlet-related error occurs.
     * @throws IOException      if an I/O error occurs.
     * @throws SQLException    if a database error occurs.
     */
    private void updateItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String pictureSelected = request.getPart("item-image").getSubmittedFileName();
        String newCategory = request.getParameter("new-category");
        String itemName = request.getParameter("item-name");
        System.out.println(itemName);
        if(pictureSelected!=""){
            System.out.println(pictureSelected);
            ItemHandler.updatePicture(itemName,"Style/Pictures/" + pictureSelected);
        }
        if(newCategory!=""){
            System.out.println(newCategory);
            ItemHandler.updateCategory(itemName, newCategory);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders.jsp");
        dispatcher.forward(request,response);
    }

    /**
     * Displays all items and forwards the request to the product page.
     *
     * @param request  The HTTP request object.
     * @param response The HTTP response object.
     * @throws ServletException if a servlet-related error occurs.
     * @throws IOException      if an I/O error occurs.
     */
    private void displayAllItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ItemView> allItems = getAllItems();
        request.setAttribute("display-items", allItems);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    /**
     * Removes an item and forwards the request to the orders page.
     *
     * @param request  The HTTP request object.
     * @param response The HTTP response object.
     * @throws ServletException if a servlet-related error occurs.
     * @throws IOException      if an I/O error occurs.
     * @throws SQLException    if a database error occurs.
     */
    private void removeItemServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String itemName = request.getParameter("item-name");
        boolean successRemove = ItemHandler.removeItem(itemName);
        if(successRemove){
            request.setAttribute("successRemoveMessage", "Item removed successfully" );
        }
        else{
            request.setAttribute("successRemoveMessage", "There was a problem removing the item" );
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders.jsp");
        dispatcher.forward(request,response);
    }


    /**
     * Searches for items and forwards the request to the product page.
     *
     * @param request  The HTTP request object.
     * @param response The HTTP response object.
     * @throws ServletException if a servlet-related error occurs.
     * @throws IOException      if an I/O error occurs.
     */
    private void searchItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ItemView> foundItems;
        String searchText = request.getParameter("search_text");
        foundItems = ItemHandler.searchItem(searchText);
        request.setAttribute("found-items", foundItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
        dispatcher.forward(request,response);
    }

    /**
     * Adds an item and forwards the request to the orders page.
     *
     * @param request  The HTTP request object.
     * @param response The HTTP response object.
     * @throws ServletException if a servlet-related error occurs.
     * @throws IOException      if an I/O error occurs.
     */
    private void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Retrieve information from request
        String name = request.getParameter("item_name");
        String fileName = "Style/Pictures/" + request.getPart("item_image").getSubmittedFileName();
        String category = request.getParameter("item_category");
        float price = Float.parseFloat(request.getParameter("item_price"));
        int stockNumber = Integer.parseInt(request.getParameter("item_amount"));

        boolean addItemSuccess;
        try {
            addItemSuccess = ItemHandler.addItem(new ItemView(name, fileName, category, price, stockNumber));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (addItemSuccess) {
            // Forward the request to an account page (orders.jsp)
            RequestDispatcher dispatcher = request.getRequestDispatcher("orders.jsp");
            dispatcher.forward(request, response);

        } else {
            // Forward the request to an account page (orders.jsp)
            RequestDispatcher dispatcher = request.getRequestDispatcher("orders.jsp");
            dispatcher.forward(request, response);
        }
    }
}