package com.web.se_webshop.View.Controller;

import com.web.se_webshop.BO.Model.ItemLogic.ItemHandler;
import com.web.se_webshop.BO.Model.OrderLogic.OrderHandler;
import com.web.se_webshop.View.ObjectView.CartDetails;
import com.web.se_webshop.View.ObjectView.ItemView;
import com.web.se_webshop.View.ObjectView.OrderView;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.web.se_webshop.BO.Model.ItemLogic.ItemHandler.searchItem;
import static com.web.se_webshop.BO.Model.OrderLogic.Order.packOrder;

/**
 * Servlet responsible for handling order-related operations, including adding orders, getting all orders, and packing orders.
 */
@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        System.out.println(command);

        switch (command) {
            case "AddOrder":
                try {
                    addOrder(request, response);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
                    dispatcher.forward(request, response);
                    return;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case "getAllOrders":
                getAllOrders(request, response);
                break; // Added break here to avoid falling through to the next case
            case "pack":
                try {
                    OrderHandler.packOrder(request.getParameter("order-id"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                // Handle any other cases here if needed
                break;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Adds an order to the database based on the items in the user's cart.
     *
     * @param request  The HTTP request object.
     * @param response The HTTP response object.
     * @throws SQLException if a database error occurs.
     */
    private void addOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        // Proceed only if theres items in the cart
        if( request.getSession().getAttribute("cart")!=null ){
            ArrayList<CartDetails> cart = (ArrayList<CartDetails>) request.getSession().getAttribute("cart");
            String userName = (String) request.getSession().getAttribute("userName");
            String  address = request.getParameter("address");
            OrderHandler.addOrder(userName, cart, address);
        }
    }

    /**
     * Retrieves all orders from the database and sets them as an attribute in the request.
     *
     * @param request  The HTTP request object.
     * @param response The HTTP response object.
     * @throws ServletException if a servlet-related error occurs.
     * @throws IOException      if an I/O error occurs.
     */
    private void getAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<OrderView> foundOrders;
        foundOrders = OrderHandler.getAllOrders();
        request.setAttribute("found-orders", foundOrders);
    }

    /**
     * Retrieves all orders from the database.
     *
     * @return An ArrayList of OrderView objects representing all orders.
     */
    public static ArrayList<OrderView> getAllOrders(){
        return OrderHandler.getAllOrders();
    }
}