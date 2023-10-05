package com.web.se_webshop.View.Controller;

import com.web.se_webshop.BO.Model.ItemLogic.ItemHandler;
import com.web.se_webshop.BO.Model.OrderLogic.OrderHandler;
import com.web.se_webshop.View.ObjectView.CartDetails;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "loginRedirect":
                response.sendRedirect("account.jsp");
                break;
        }
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

}