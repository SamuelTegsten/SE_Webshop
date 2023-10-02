<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account | Webshop</title>
    <!-- Link to external CSS stylesheets -->
    <link rel="stylesheet" href="Style/style.css">
    <link rel="stylesheet" href="Style/loginStyle.css">
    <!-- Link to Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400;500;600;700&display=swap" rel="stylesheet">
    <!-- Link to Font Awesome icons -->
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css">
</head>
<body>
<div class="header2">
    <div class="container">
        <div class="navbar">
            <div class="logo">
                <!-- Logo image -->
                <img src="Style/Pictures/hunting_logo.png" width="170px">
            </div>
            <div class="nav-wrapper">
                <nav class="navigation">
                    <ul>
                        <!-- Navigation links -->
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

<div class="login-container">
    <h2 id="form-title">Login</h2>
    <form id="login-form" action="${pageContext.request.contextPath}/login-servlet" method="post">
        <!-- Input fields for username and password -->
        <input type="text" name="username" class="form-input" placeholder="Username" required id="username-input">
        <input type="password" name="password" class="form-input" placeholder="Password" required id="password-input">
        <!-- Submit button for login -->
        <button type="submit" class="form-button" id="login-button">Login</button>
    </form>
    <p class="toggle-link" id="toggle-link">Don't have an account? <a href="#" onclick="toggleForms(event);">Register</a></p>

    <form id="register-form" action="${pageContext.request.contextPath}/register-servlet" method="post" style="display: none;">
        <!-- Input fields for new username and password (for registration) -->
        <input type="text" name="newUsername" class="form-input" placeholder="New Username" required id="new-username-input">
        <input type="text" name="newPassword" class="form-input" placeholder="New Password" required id="new-password-input">
        <!-- Submit button for registration -->
        <button type="submit" class="form-button" id="register-button">Register</button>
    </form>
    <!-- Tooltip for login failure -->
    <div class="tooltip" id="login-failed-tooltip">
        Login Failed
    </div>
</div>

<script>
    // JavaScript to show and hide error messages
    function toggleForms(event) {
        event.preventDefault();
        const loginForm = document.getElementById("login-form");
        const registerForm = document.getElementById("register-form");
        const formTitle = document.getElementById("form-title");
        const toggleLink = document.getElementById("toggle-link");

        if (loginForm.style.display === "none") {
            // Show login form and hide registration form
            loginForm.style.display = "block";
            registerForm.style.display = "none";
            formTitle.textContent = "Login";
            toggleLink.innerHTML = "Don't have an account? <a href='#' onclick='toggleForms(event);'>Register</a>";
        } else {
            // Show registration form and hide login form
            loginForm.style.display = "none";
            registerForm.style.display = "block";
            formTitle.textContent = "Register";
            toggleLink.innerHTML = "Already have an account? <a href='#' onclick='toggleForms(event);'>Login</a>";
        }
    }

    document.getElementById("login-form").addEventListener("submit", function(event) {
        // Check if loginError is set to true in session
        var loginError = <%= session.getAttribute("loginError") %>;

        if (loginError) {
            var tooltip = document.getElementById("login-failed-tooltip");

            // Show the tooltip
            tooltip.style.display = "block";

            // Set a timeout to hide the tooltip after 5 seconds
            setTimeout(function() {
                tooltip.style.display = "none";
            }, 5000); // 5000 milliseconds (5 seconds)

            // Prevent form submission
            event.preventDefault();
        }
    });
</script>
</body>
</html>
