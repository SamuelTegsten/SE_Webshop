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
<jsp:include page="navbar.jsp"/>


<div class="login-container">
    <h2 id="form-title">Login</h2>
    <form id="login-form" action="${pageContext.request.contextPath}/account-servlet" method="post">
        <!-- Input fields for username and password -->
        <input type="text" name="username" class="form-input" placeholder="Username" required id="username-input">
        <input type="password" name="password" class="form-input" placeholder="Password" required id="password-input">
        <!-- Submit button for login -->
        <button type="submit" class="form-button" id="login-button">Login</button>
    </form>
    <p class="toggle-link" id="toggle-link">Don't have an account? <a href="#" onclick="toggleForms(event);">Register</a></p>

    <form id="register-form" action="${pageContext.request.contextPath}/account-servlet" method="post" style="display: none;">
        <!-- Input fields for new username and password (for registration) -->
        <input type="text" name="newUsername" class="form-input" placeholder="New Username" required id="new-username-input">
        <input type="password" name="newPassword" class="form-input" placeholder="New Password" required id="new-password-input">
        <!-- Submit button for registration -->
        <button type="submit" class="form-button" id="register-button">Register</button>
    </form>

    <!-- Tooltip for login failure -->
    <div class="tooltip" id="login-failed-tooltip">
        <% Boolean loginError = (Boolean) session.getAttribute("loginError");
            if (loginError != null && loginError.booleanValue()) { %>
        <script> alert("Login Failed"); </script>
        <% session.setAttribute("loginError", false);} %>
    </div>

    <!-- Tooltip for registration failure -->
    <div class="tooltip" id="registration-failed-tooltip">
        <% Boolean accountExists = (Boolean) session.getAttribute("accountExists");
            if (accountExists != null && accountExists.booleanValue()) { %>
        <script> alert("Username or Password Already Exists"); </script>
        <% session.setAttribute("accountExists", false); } %>
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
</script>
</body>
</html>
