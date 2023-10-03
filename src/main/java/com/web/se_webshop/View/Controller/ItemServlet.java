package com.web.se_webshop.View.Controller;

import com.web.se_webshop.DB.DBManager.DBConnect;
import com.web.se_webshop.View.ItemView.ItemView;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;

import static com.web.se_webshop.BO.Handler.ItemHandler.itemHandler.addItem;

@WebServlet(name = "ItemServlet", value = "/item-servlet")
public class ItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            System.out.println("name: " + request.getParameter("item_name"));
            System.out.println("category: " + request.getParameter("item_category"));
            System.out.println("antal: " + request.getParameter("item_amount"));
            addItem(new ItemView(request.getParameter("item_name"), "pic", request.getParameter("category"), 25.00F), 8);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
