<%@ page import="com.web.se_webshop.View.ObjectView.OrderView" %>
<%@ page import="com.web.se_webshop.BO.Model.OrderLogic.OrderHandler" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <h2>Order Table</h2>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Amount</th>
            <th>Ordered By</th>
            <th>Date Ordered</th>
            <th>Order Status</th>
            <th>Pack Order</th>
        </tr>
        </thead>
        <tbody>
        <!-- This is where you will dynamically populate the order data rows -->
        <%

            ArrayList<OrderView> orders = OrderHandler.getAllOrders();
            if (orders != null) {
                for (OrderView order : orders) {
        %>



        <tr>
            <td><%=order.getItemName()%></td>
            <td><%=order.getNumberOfItems()%></td>
            <td><%=order.getUsername()%></td>
            <td><%=order.getDate()%></td>
            <td><%=order.getStatus()%></td>
            <td>
                <button class="pack-button">Pack Item</button> <!-- "Pack Item" Button -->
            </td>
        </tr>
        <%}}%>
        </tbody>
    </table>
    <div class="add_item">
        <h2>Add New Item</h2>
        <form id="add-item-form" action="${pageContext.request.contextPath}/item-servlet" method="post" enctype="multipart/form-data">
            <div class="item_details">
                <input type="hidden" name="command" value="ADD">
                <input type="file" name= "item_image" accept="image/*" id="item_image">
                <input type="text" name= "item_name" placeholder="Item Name" id="item_name" >
                <input type="text" name= "item_category" placeholder="Item Category" id="item_category">
                <input type="text" name= "item_price" placeholder="Item Price" id="item_price">
                <input type="text" name= "item_amount" placeholder="Item Amount" id="item_amount">
                <button type="submit" class="add_item_button">Add Item</button>
            </div>
        </form>
    </div>
    <div class="add_item">
        <h2>Remove Item</h2>
        <div class="item_details">
            <input type="text" placeholder="Item Name" id="item-name_remove">
            <button class="remove_item_button">Remove Item</button>
        </div>
    </div>
    <div class="add_item">
        <h2>Update Item</h2>
        <div class="item_details">
            <input type="text" placeholder="Item Name" id="item_name_update">
            <input type="file" accept="image/*" id="new_image">
            <input type="text" placeholder="New Category" id="new_category">
            <button class="add_item_button">Add Item</button>
        </div>
    </div>
</div>
<script>
    // Get the input element by its id
    const itemAmountInput = document.getElementById("item_amount");

    // Add an event listener to the input field
    itemAmountInput.addEventListener("input", function (event) {
        // Get the current input value
        const inputValue = event.target.value;

        // Remove any non-numeric characters using a regular expression
        const numericValue = inputValue.replace(/[^0-9]/g, "");

        // Update the input field with the numeric value
        event.target.value = numericValue;
    });
</script>
</body>
</html>
