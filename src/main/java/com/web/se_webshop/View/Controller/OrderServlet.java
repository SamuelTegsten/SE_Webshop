package com.web.se_webshop.View.Controller;

import com.web.se_webshop.BO.Model.ItemLogic.ItemHandler;
import com.web.se_webshop.BO.Model.OrderLogic.Order;
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
import java.util.Collection;
import java.util.Iterator;

import static com.web.se_webshop.BO.Model.ItemLogic.ItemHandler.searchItem;
import static com.web.se_webshop.BO.Model.OrderLogic.Order.packOrder;

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



    private void addOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        // Proceed only if theres items in the cart
        if( request.getSession().getAttribute("cart")!=null ){
            ArrayList<CartDetails> cart = (ArrayList<CartDetails>) request.getSession().getAttribute("cart");
            String userName = (String) request.getSession().getAttribute("userName");
            String  address = request.getParameter("address");
            System.out.println(address);
            OrderHandler.addOrder(userName, cart, address);
        }
    }

    private void getAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<OrderView> foundOrders;
        foundOrders = OrderHandler.getAllOrders();
        request.setAttribute("found-orders", foundOrders);
    }
    public static ArrayList<OrderView> getAllOrders(){
        return OrderHandler.getAllOrders();
    }
}