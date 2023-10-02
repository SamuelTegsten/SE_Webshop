<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale-1.0">
    <title>Account | Webshop</title>
    <link rel="stylesheet" href="Style/style.css">
    <link rel="stylesheet" href="Style/loginStyle.css">
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

<!-- Login/Register Container -->
<div class="login-container">
    <h2 id="form-title">Login</h2>
    <form id="login-form" action="loginServlet" method="post">
        <input type="text" name="username" class="form-input" placeholder="Username" required>
        <input type="password" name="password" class="form-input" placeholder="Password" required>
        <button type="submit" class="form-button">Login</button>
    </form>

    <form id="register-form" action="registerServlet" method="post" style="display: none;">
        <input type="text" name="username" class="form-input" placeholder="Username" required>
        <input type="password" name="password" class="form-input" placeholder="Password" required>
        <button type="submit" class="form-button">Register</button>
    </form>

    <p class="toggle-link" id="toggle-link">Don't have an account? <a href="#" onclick="toggleForms(event);">Register</a></p>
</div>

<!-- JavaScript to toggle between login and register forms -->
<script>
    function toggleForms(event) {
        event.preventDefault();
        const loginForm = document.getElementById("login-form");
        const registerForm = document.getElementById("register-form");
        const formTitle = document.getElementById("form-title");
        const toggleLink = document.getElementById("toggle-link");

        if (loginForm.style.display === "none") {
            loginForm.style.display = "block";
            registerForm.style.display = "none";
            formTitle.textContent = "Login";
            toggleLink.innerHTML = "Don't have an account? <a href='#' onclick='toggleForms(event);'>Register</a>";
        } else {
            loginForm.style.display = "none";
            registerForm.style.display = "block";
            formTitle.textContent = "Register";
            toggleLink.innerHTML = "Already have an account? <a href='#' onclick='toggleForms(event);'>Login</a>";
        }
    }
</script>
</body>
</html>
