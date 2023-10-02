<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart | Webshop</title>
    <link rel="stylesheet" href="Style/style.css">
    <link rel="stylesheet" href="Style/cartStyle.css">
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

<div class="container">
    <div class="cart-table">
        <table>
            <thead>
            <tr>
                <th>Image</th>
                <th>Item Name</th>
                <th>Item Price</th>
                <th>Item Category</th>
                <th>Quantity</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td><img src="Style/Pictures/knife1.png" alt="Item Image" width="50px" height="50px"></td>
                <td>Product 1</td>
                <td>$10.00</td>
                <td>Category A</td>
                <td class="quantity">
                    <button class="decrease">-</button>
                    <input type="number" name="quantity" value="1" min="1">
                    <button class="increase">+</button>
                </td>
            </tr>
            <tr>
                <td><img src="Style/Pictures/tent1.png" alt="Item Image" width="50px" height="50px"></td>
                <td>Product 2</td>
                <td>$20.00</td>
                <td>Category B</td>
                <td class="quantity">
                    <button class="decrease">-</button>
                    <input type="number" name="quantity" value="1" min="1">
                    <button class="increase">+</button>
                </td>
            </tr>

            </tbody>
        </table>

        <div class="total-amount">
            <label for="total">Total Amount:</label>
            <input type="text" id="total" name="total" readonly>
        </div>
    </div>

    <div class="cart-buttons">
        <button class="purchase-button">Purchase</button>
        <button class="login-button">Log In</button>
    </div>
</div>
</body>
</html>

