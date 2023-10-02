<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale-1.0">
    <title>Admin | Webshop</title>
    <!-- Link to external CSS stylesheets -->
    <link rel="stylesheet" href="Style/style.css">
    <link rel="stylesheet" href="Style/adminStyle.css">
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

<div class="container">
    <h2>Admin Panel</h2>

    <!-- User Form to Add User -->
    <div class="add_user">
        <h3>Add User</h3>
        <form>
            <!-- Input fields for adding a user -->
            <input type="text" placeholder="Username" required>
            <input type="password" placeholder="Password" required>
            <button type="submit">Add</button>
        </form>
    </div>

    <!-- User Form to Remove User -->
    <div class="remove_user">
        <h3>Remove User</h3>
        <form>
            <!-- Input fields for removing a user -->
            <input type="text" placeholder="Username" required>
            <button type="submit">Remove</button>
        </form>
    </div>

    <!-- Staff Member Form to Add Staff Member -->
    <div class="add_staff">
        <h3>Add Staff Member</h3>
        <form>
            <!-- Input fields for adding a staff member -->
            <input type="text" placeholder="Username" required>
            <input type="password" placeholder="Password" required>
            <button type="submit">Add</button>
        </form>
    </div>

    <!-- Staff Member Form to Remove Staff Member -->
    <div class="remove_staff">
        <h3>Remove Staff Member</h3>
        <form>
            <!-- Input fields for removing a staff member -->
            <input type="text" placeholder="Username" required>
            <button type="submit">Remove</button>
        </form>
    </div>

    <!-- Admin Form -->
    <div class="add_admin">
        <h3>Admin</h3>
        <form>
            <!-- Input fields for adding/removing an admin -->
            <input type="text" placeholder="Username" required>
            <input type="password" placeholder="Password" required>
            <button type="submit">Add</button>
            <button type="submit">Remove</button>
        </form>
    </div>

    <!-- User Table -->
    <div class="user_table">
        <h3>User Table</h3>
        <table>
            <thead>
            <tr>
                <!-- Table headers for user permission and username -->
                <th>Permission</th>
                <th>Username</th>
            </tr>
            </thead>
            <tbody>
            <!-- Table rows for users, staff, and admins -->
            <tr>
                <td>User</td>
                <td>JohnDoe</td>
            </tr>
            <tr>
                <td>Staff</td>
                <td>JaneSmith</td>
            </tr>
            <tr>
                <td>Admin</td>
                <td>Admin123</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
