package com.web.se_webshop.View.Controller;

import com.web.se_webshop.BO.Model.ItemLogic.ItemHandler;
import com.web.se_webshop.View.ObjectView.CartDetails;
import com.web.se_webshop.View.ObjectView.ItemView;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // retrieve details from item an quantity
        String itemName = request.getParameter("item_name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ItemView item = ItemHandler.searchItem(itemName).get(0);
        // proceed only if theres items in stock
        if(item.getStockNumber()>0) {

            // spara i session cart
            HttpSession session = request.getSession();
            ArrayList<CartDetails> cart = (ArrayList<CartDetails>) session.getAttribute("cart");
            cart.add(new CartDetails(item, quantity));
            System.out.println(item + ", " + quantity);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
        dispatcher.forward(request, response);
    }
}
