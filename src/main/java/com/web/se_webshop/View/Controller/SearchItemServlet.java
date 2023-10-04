package com.web.se_webshop.View.Controller;

import com.web.se_webshop.View.ObjectView.ItemView;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

import static com.web.se_webshop.BO.Model.ItemLogic.ItemHandler.searchItem;

@WebServlet(name = "SearchItemServlet", value = "/SearchItemServlet")
public class SearchItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ItemView> foundItems;
        String searchText = request.getParameter("search_text");
        foundItems = searchItem(searchText);
        request.setAttribute("found-items", foundItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
        dispatcher.forward(request,response);
    }
}
