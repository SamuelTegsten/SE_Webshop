<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale-1.0">
    <title>Orders | Webshop</title>
    <link rel="stylesheet" href="Style/style.css">
    <link rel="stylesheet" href="Style/orderStyle.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css">
</head>
<body>
<div class="header2">
    <div class="container">
        <div class="navbar">
            <div class="logo">
                <img src="Style/Pictures/hunting_logo.png" width="170px">
            </div>
            <div class="nav-wrapper">
                <nav class="navigation">
                    <ul>
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="product.jsp">Products</a></li>
                        <li><a href="account.jsp">Account</a></li>
                        <li><a href="orders.jsp">Orders</a></li>
                        <li><a href="admin.jsp">Admin</a></li>
                        <li>
                            <a href="cart.jsp">
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
        </tr>
        </thead>
        <tbody>
        <!-- This is where you will dynamically populate the order data rows -->
        <tr>
            <td>Sample Product 1</td>
            <td>5</td>
            <td>John Doe</td>
            <td>2023-10-02</td>
        </tr>
        <tr>
            <td>Sample Product 2</td>
            <td>3</td>
            <td>Jane Smith</td>
            <td>2023-10-03</td>
        </tr>
        <!-- Add more rows as needed -->
        </tbody>
    </table>
</div>
</body>
</html>
