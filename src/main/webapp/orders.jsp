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
<div class="header2">
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
                        <li><a href="account.jsp">Account</a></li>
                        <li><a href="orders.jsp">Orders</a></li>
                        <li><a href="admin.jsp">Admin</a></li>
                        <li>
                            <a href="cart.jsp">
                                <!-- Shopping cart icon -->
                                <img src="Style/Pictures/white_shopping_cart.png" width="30px" height="30px">
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>

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
        <tr>
            <td>Sample Product 1</td>
            <td>5</td>
            <td>John Doe</td>
            <td>2023-10-02</td>
            <td>In Progress</td>
            <td>
                <input type="number" min="0" value="0" style="width: 40px;"> <!-- Quantity Input -->
                <button class="pack-button">Pack Item</button> <!-- "Pack Item" Button -->
            </td>
        </tr>
        <tr>
            <td>Sample Product 2</td>
            <td>3</td>
            <td>Jane Smith</td>
            <td>2023-10-03</td>
            <td>In Progress</td>
            <td>
                <input type="number" min="0" value="0" style="width: 40px;">
                <button class="pack-button">Pack Item</button>
            </td>
        </tr>
        <!-- Add more rows as needed -->
        </tbody>
    </table>
    <div class="add_item">
        <h2>Add New Item</h2>
        <form id="add-item-form" action="${pageContext.request.contextPath}/add-item-servlet" method="post" enctype="multipart/form-data">
            <div class="item_details">
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
