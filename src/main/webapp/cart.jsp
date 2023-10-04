<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart | Webshop</title>
    <!-- Link to external CSS stylesheets -->
    <link rel="stylesheet" href="Style/style.css">
    <link rel="stylesheet" href="Style/cartStyle.css">
    <!-- Link to Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400;500;600;700&display=swap" rel="stylesheet">
    <!-- Link to Font Awesome icons -->
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css">
</head>

<body>
<jsp:include page="navbar.jsp"/>

<div class="container">
    <div class="cart-table">
        <table>
            <thead>
            <tr>
                <!-- Table headers for cart items -->
                <th>Image</th>
                <th>Item Name</th>
                <th>Item Price</th>
                <th>Item Category</th>
                <th>Quantity</th>
                <th>Address</th>
            </tr>
            </thead>
            <tbody>

            <!-- Cart item 1 -->
            <tr>
                <td><img src="Style/Pictures/knife1.png" alt="Item Image" width="50px" height="50px"></td>
                <td>Product 1</td>
                <td>$10.00</td>
                <td>Category A</td>
                <td class="quantity">
                    <!-- Quantity control buttons -->
                    <button class="decrease">-</button>
                    <input type="number" name="quantity" value="1" min="1">
                    <button class="increase">+</button>
                </td>
                <td><input type="text" id="static_textarea_1" name="static_textarea"></td>
            </tr>

            <!-- Cart item 2 -->
            <tr>
                <td><img src="Style/Pictures/tent1.png" alt="Item Image" width="50px" height="50px"></td>
                <td>Product 2</td>
                <td>$20.00</td>
                <td>Category B</td>
                <td class="quantity">
                    <!-- Quantity control buttons -->
                    <button class="decrease">-</button>
                    <input type="number" name="quantity" value="1" min="1">
                    <button class="increase">+</button>
                </td>
                <td><input type="text" id="static_textarea_2" name="static_textarea"></td>
            </tr>
            </tbody>
        </table>

        <!-- Total amount display -->
        <div class="total-amount">
            <label for="total">Total Amount:</label>
            <input type="text" id="total" name="total" readonly>
        </div>
    </div>

    <!-- Cart action buttons -->
    <div class="cart-buttons">
        <button class="purchase-button">Purchase</button>
        <button class="login-button">Log In</button>
    </div>
</div>
</body>
</html>
