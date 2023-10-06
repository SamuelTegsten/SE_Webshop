<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String userName = (String) session.getAttribute("userName");
    String userRole = (String) session.getAttribute("userRole");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale-1.0">
    <title>Orders | Webshop</title>
    <!-- Link to the main stylesheet -->
    <link rel="stylesheet" href="Style/style.css">
    <!-- Link to the order-specific stylesheet -->
    <link rel="stylesheet" href="Style/orderStyle.css">
    <!-- Link to the cart-style stylesheet -->
    <link rel="stylesheet" href="Style/cartStyle.css">
    <!-- Link to Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400;500;600;700&display=swap" rel="stylesheet">
    <!-- Link to Font Awesome for icons -->
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css">
</head>
<body>
<jsp:include page="navbar.jsp"/>

<div class="order-table">
    <h2><%= userName %> Account Screen</h2>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Permission</th>
        </tr>
        </thead>
        <tbody>
        <!-- This is where you will dynamically populate the order data rows -->
        <tr>
            <td><%= userName %></td>
            <td><%= userRole %></td>
        </tr>
        </tbody>
    </table>
    <a href="logout.jsp" class="purchase-button">Log Out</a>
</div>
</body>
</html>

