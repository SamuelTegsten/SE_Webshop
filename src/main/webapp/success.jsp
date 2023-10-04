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
    <h2>#Name# Order Status</h2>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Amount</th>
            <th>Date Ordered</th>
            <th>Order Status</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <!-- This is where you will dynamically populate the order data rows -->
        <tr>
            <td>Sample Product 1</td>
            <td>5</td>
            <td>2023-10-02</td>
            <td>Sent</td>
            <td>59,99:-</td>
        </tr>
        <tr>
            <td>Sample Product 2</td>
            <td>3</td>
            <td>2023-10-03</td>
            <td>In Progress</td>
            <td>59,99:-</td>
        </tr>
        <!-- Add more rows as needed -->
        </tbody>
    </table>
    <!-- Total amount display -->
    <div class="total-amount">
        <label for="total">Total Amount:</label>
        <input type="text" id="total" name="total" readonly>
    </div>
</div>
</div>
</body>
</html>

