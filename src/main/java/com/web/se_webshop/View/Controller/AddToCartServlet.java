package com.web.se_webshop.View.Controller;

import com.web.se_webshop.BO.Model.ItemLogic.ItemHandler;
import com.web.se_webshop.View.ObjectView.CartDetails;
import com.web.se_webshop.View.ObjectView.ItemView;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet responsible for handling operations related to adding and removing items from the cart.
 */
@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");

        switch (command) {
            case "addToCart":
                addToCart(request, response);
                break;
            case "removeFromCart":
                removeFromCart(request, response);
                break;
        }
    }

    /**
     * Removes an item from the cart and forwards the request to the cart page.
     *
     * @param request  The HTTP request object.
     * @param response The HTTP response object.
     * @throws ServletException if a servlet-related error occurs.
     * @throws IOException      if an I/O error occurs.
     */
    private void removeFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));
        HttpSession session = request.getSession();
        ArrayList<CartDetails> cart = (ArrayList<CartDetails>) session.getAttribute("cart");
        cart.remove(index);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Adds an item to the cart and forwards the request to the product page.
     *
     * @param request  The HTTP request object.
     * @param response The HTTP response object.
     * @throws ServletException if a servlet-related error occurs.
     * @throws IOException      if an I/O error occurs.
     */
    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve details from item and quantity
        String itemName = request.getParameter("item_name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ItemView item = ItemHandler.searchItem(itemName).get(0);

        // Proceed only if there are items in stock
        if (item.getStockNumber() > 0) {
            // Save in session cart
            HttpSession session = request.getSession();
            ArrayList<CartDetails> cart = (ArrayList<CartDetails>) session.getAttribute("cart");
            cart.add(new CartDetails(item, quantity));
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
        dispatcher.forward(request, response);
    }
}
