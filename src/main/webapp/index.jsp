<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.web.se_webshop.View.ObjectView.CartDetails" %>
<%@ page import="com.web.se_webshop.View.ObjectView.ItemView" %>
<%@ page import="javax.swing.plaf.basic.BasicComboBoxUI" %>
<%@ page import="com.web.se_webshop.BO.Model.ItemLogic.ItemHandler" %>
<%
    String userRole = (String) session.getAttribute("userRole");
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale-1.0">
    <title>Samuel & Esteban | Webshop</title>
    <!-- Link to the main stylesheet -->
    <link rel="stylesheet" href="Style/style.css">
    <!-- Link to Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400;500;600;700&display=swap" rel="stylesheet">
    <!-- Link to Font Awesome for icons -->
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css">
</head>
<body>
<div class="header">
    <div class="container">
        <div class="navbar">
            <div class="logo">
                <!-- Your website logo -->
                <img src="Style/Pictures/hunting_logo.png" width="170px">
            </div>
            <div class="nav-wrapper">
                <!-- Navigation menu -->
                <nav class="navigation">
                    <ul>
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="product.jsp">Products</a></li>

                        <% if (userRole == null) { %>
                        <li><a href="account.jsp">Account</a></li>
                        <% } else {
                            String userName = (String) session.getAttribute("userName");
                        %>
                        <li><a href="success.jsp"><%= userName %></a></li>
                        <% } %>


                        <%-- Show the "Orders" tab to Staff and Admin --%>
                        <% if ("STAFF".equals(userRole) || "ADMIN".equals(userRole)) { %>
                        <li><a href="orders.jsp">Orders</a></li>
                        <% } %>

                        <%-- Show the "Admin" tab only to Admin --%>
                        <% if ("ADMIN".equals(userRole)) { %>
                        <li><a href="admin.jsp">Admin</a></li>
                        <% } %>

                        <li>
                            <a href="cart.jsp">
                                <img src="Style/Pictures/white_shopping_cart.png" width="30px" height="30px">
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <!-- Heading and description -->
                <h1>Gear Up For Your Wildest Adventures!</h1>
                <p>Elevate Your Hunt With Premium Gear & Expert Guidance</p>
                <!-- Call to action button -->
                <a href="product.jsp" class="btn"><span>Explore Now</span><i></i></a>
            </div>
            <div class="col-2">
                <!-- Image -->
                <img src="Style/Pictures/hunting_image.png">
            </div>
        </div>
    </div>
</div>

<!-- Featured products section -->
<div class="small-container">
    <h2 class="title">Featured Products</h2>
    <div class="row">
        <%
            ArrayList<ItemView> itemsToDisplay = ItemHandler.getAllItems();

            if (itemsToDisplay != null && !itemsToDisplay.isEmpty()) {
                for (int i = 0; i < 4 && i < itemsToDisplay.size(); i++) {
                    ItemView item = itemsToDisplay.get(i);
        %>
        <!-- Product <%= i+1 %> -->
        <div class="col-4">
            <img src="<%= item.getPicture() %>" width="250px" height="250px">
            <h4><%= item.getName() %></h4>
            <div class="stock">
                <%
                    if (item.getStockNumber() > 0) {
                %>
                <div class="stock-info">
                    <h5>In Stock  <%= item.getStockNumber() %></h5>
                    <i class="fa fa-check-circle"></i>
                </div>
                <%} else {%>
                <div class="stock-info-1">
                    <h5>Out of Stock</h5>
                    <i class="fa fa-times-circle"></i>
                </div>
                <% }%>
            </div>
            <p>Price: <%= item.getPrice() %></p>
        </div>
        <% }} %>
    </div>
</div>
</body>
</html>

