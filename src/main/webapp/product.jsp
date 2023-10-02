<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale-1.0">
    <title>Product | Webshop</title>
    <link rel="stylesheet" href="Style/style.css">
    <link rel="stylesheet" href="Style/productStyle.css">
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
                    </ul>
                </nav>
                <img src="Style/Pictures/white_shopping_cart.png" width="30px" height="30px">
            </div>
        </div>
    </div>
</div>
<div class="small-container">
    <h2 class="title">All Products</h2>
    <div class="row">
        <div class="col-4">
            <img src="Style/Pictures/tent1.png">
            <h4>Name</h4>
            <div class="stock">
                <div class="stock-info">
                    <h5>In Stock</h5>
                    <i class="fa fa-check-circle"></i>
                </div>
                <div class="stock-info-1">
                    <h5>Out of Stock</h5>
                    <i class="fa fa-times-circle"></i>
                </div>
            </div>
            <p>pris:-</p>
            <div class="add-to-cart-container">
                <form action="AddToCartServlet" method="post">
                    <select name="quantity" class="quantity-select">
                        <option <% for (int i = 1; i <= 99; i++) { %>
                        <option value="<%= i %>"><%= i %></option>
                            <% } %>
                        <!-- Add more quantity options as needed -->
                    </select>
                    <input type="hidden" name="productId" value="1">
                    <button type="submit" class="add-to-cart">Add to Cart</button>
                </form>
            </div>
        </div>
        <div class="col-4">
            <img src="Style/Pictures/knife1.png">
            <h4>Name</h4>
            <div class="stock">
                <div class="stock-info">
                    <h5>In Stock</h5>
                    <i class="fa fa-check-circle"></i>
                </div>
                <div class="stock-info-1">
                    <h5>Out of Stock</h5>
                    <i class="fa fa-times-circle"></i>
                </div>
            </div>
            <p>pris:-</p>
            <div class="add-to-cart-container">
                    <select name="quantity" class="quantity-select">
                        <option <% for (int i = 1; i <= 99; i++) { %>
                        <option value="<%= i %>"><%= i %></option>
                            <% } %>
                        <!-- Add more quantity options as needed -->
                    </select>
                <button class="add-to-cart">Add to Cart</button>
            </div>
        </div>
        <div class="col-4">
            <img src="Style/Pictures/binoculars1.png">
            <h4>Name</h4>
            <div class="stock">
                <div class="stock-info">
                    <h5>In Stock</h5>
                    <i class="fa fa-check-circle"></i>
                </div>
                <div class="stock-info-1">
                    <h5>Out of Stock</h5>
                    <i class="fa fa-times-circle"></i>
                </div>
            </div>
            <p>pris:-</p>
            <div class="add-to-cart-container">
                    <select name="quantity" class="quantity-select">
                        <option <% for (int i = 1; i <= 99; i++) { %>
                        <option value="<%= i %>"><%= i %></option>
                            <% } %>
                        <!-- Add more quantity options as needed -->
                    </select>
                <button class="add-to-cart">Add to Cart</button>
            </div>
        </div>
        <div class="col-4">
            <img src="Style/Pictures/jacket1.png">
            <h4>Name</h4>
            <div class="stock">
                <div class="stock-info">
                    <h5>In Stock</h5>
                    <i class="fa fa-check-circle"></i>
                </div>
                <div class="stock-info-1">
                    <h5>Out of Stock</h5>
                    <i class="fa fa-times-circle"></i>
                </div>
            </div>
            <p>pris:-</p>
            <div class="add-to-cart-container">
                    <select name="quantity" class="quantity-select">
                        <option <% for (int i = 1; i <= 99; i++) { %>
                        <option value="<%= i %>"><%= i %></option>
                            <% } %>
                        <!-- Add more quantity options as needed -->
                    </select>
                <button class="add-to-cart">Add to Cart</button>
            </div>
        </div>
        <div class="col-4">
            <img src="Style/Pictures/jacket2.png">
            <h4>Name</h4>
            <div class="stock">
                <div class="stock-info">
                    <h5>In Stock</h5>
                    <i class="fa fa-check-circle"></i>
                </div>
                <div class="stock-info-1">
                    <h5>Out of Stock</h5>
                    <i class="fa fa-times-circle"></i>
                </div>
            </div>
            <p>pris:-</p>
            <div class="add-to-cart-container">
                    <select name="quantity" class="quantity-select">
                        <option <% for (int i = 1; i <= 99; i++) { %>
                        <option value="<%= i %>"><%= i %></option>
                            <% } %>
                        <!-- Add more quantity options as needed -->
                    </select>
                <button class="add-to-cart">Add to Cart</button>
            </div>
        </div>
        <div class="col-4">
            <img src="Style/Pictures/gloves1.png">
            <h4>Name</h4>
            <div class="stock">
                <div class="stock-info">
                    <h5>In Stock</h5>
                    <i class="fa fa-check-circle"></i>
                </div>
                <div class="stock-info-1">
                    <h5>Out of Stock</h5>
                    <i class="fa fa-times-circle"></i>
                </div>
            </div>
            <p>pris:-</p>
            <div class="add-to-cart-container">
                    <select name="quantity" class="quantity-select">
                        <option <% for (int i = 1; i <= 99; i++) { %>
                        <option value="<%= i %>"><%= i %></option>
                            <% } %>
                        <!-- Add more quantity options as needed -->
                    </select>
                <button class="add-to-cart">Add to Cart</button>
            </div>
        </div>
        <div class="col-4">
            <img src="Style/Pictures/gloves2.png">
            <h4>Name</h4>
            <div class="stock">
                <div class="stock-info">
                    <h5>In Stock</h5>
                    <i class="fa fa-check-circle"></i>
                </div>
                <div class="stock-info-1">
                    <h5>Out of Stock</h5>
                    <i class="fa fa-times-circle"></i>
                </div>
            </div>
            <p>pris:-</p>
            <div class="add-to-cart-container">
                    <select name="quantity" class="quantity-select">
                        <option <% for (int i = 1; i <= 99; i++) { %>
                        <option value="<%= i %>"><%= i %></option>
                            <% } %>
                        <!-- Add more quantity options as needed -->
                    </select>
                <button class="add-to-cart">Add to Cart</button>
            </div>
        </div>
        <div class="col-4">
            <img src="Style/Pictures/knife1.png">
            <h4>Name</h4>
            <div class="stock">
                <div class="stock-info">
                    <h5>In Stock</h5>
                    <i class="fa fa-check-circle"></i>
                </div>
                <div class="stock-info-1">
                    <h5>Out of Stock</h5>
                    <i class="fa fa-times-circle"></i>
                </div>
            </div>
            <p>pris:-</p>
            <div class="add-to-cart-container">
                    <select name="quantity" class="quantity-select">
                        <option <% for (int i = 1; i <= 99; i++) { %>
                        <option value="<%= i %>"><%= i %></option>
                            <% } %>
                        <!-- Add more quantity options as needed -->
                    </select>
                <button class="add-to-cart">Add to Cart</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
