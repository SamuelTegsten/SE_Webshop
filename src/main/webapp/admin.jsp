<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.web.se_webshop.View.ObjectView.UserView" %>
<%@ page import="java.util.ArrayList" %>

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
<jsp:include page="navbar.jsp"/>

<div class="container">
    <h2>Admin Panel</h2>

    <%-- Add User Form --%>
    <div class="add_user">
        <h3>Add User</h3>
        <form action="admin-servlet" method="post">
            <!-- Input fields for adding a user -->
            <input type="hidden" name="action" value="addUser">
            <input type="text" name="addUserUsername" placeholder="Username" required>
            <input type="password" name="addUserPassword" placeholder="Password" required>
            <button type="submit">Add</button>
        </form>
        <!-- Display the action result message -->
        <p>${requestScope.addUserActionCompleted} ${requestScope.addUserMessage}</p>
    </div>

    <%-- Remove User Form --%>
    <div class="remove_user">
        <h3>Remove User</h3>
        <form action="admin-servlet" method="post">
            <!-- Input fields for removing a user -->
            <input type="hidden" name="action" value="removeUser">
            <input type="text" name="removeUserUsername" placeholder="Username" required>
            <button type="submit">Remove</button>
        </form>
        <!-- Display the action result message -->
        <p>${requestScope.removeUserActionCompleted} ${requestScope.removeUserMessage}</p>
    </div>

    <%-- Add Staff Member Form --%>
    <div class="add_staff">
        <h3>Add Staff Member</h3>
        <form action="admin-servlet" method="post">
            <!-- Input fields for adding a staff member -->
            <input type="hidden" name="action" value="addStaff">
            <input type="text" name="addStaffUsername" placeholder="Username" required>
            <input type="password" name="addStaffPassword" placeholder="Password" required>
            <button type="submit">Add</button>
        </form>
        <!-- Display the action result message -->
        <p>${requestScope.addStaffActionCompleted} ${requestScope.addStaffMessage}</p>
    </div>

    <%-- Remove Staff Member Form --%>
    <div class="remove_staff">
        <h3>Remove Staff Member</h3>
        <form action="admin-servlet" method="post">
            <!-- Input fields for removing a staff member -->
            <input type="hidden" name="action" value="removeStaff">
            <input type="text" name="removeStaffUsername" placeholder="Username" required>
            <button type="submit">Remove</button>
        </form>
        <!-- Display the action result message -->
        <p>${requestScope.removeStaffActionCompleted} ${requestScope.removeStaffMessage}</p>
    </div>

    <%-- Add Admin Form --%>
    <div class="add_admin">
        <h3>Add Admin</h3>
        <form action="admin-servlet" method="post">
            <!-- Input fields for adding an admin -->
            <input type="hidden" name="action" value="addAdmin">
            <input type="text" name="addAdminUsername" placeholder="Username" required>
            <input type="password" name="addAdminPassword" placeholder="Password" required>
            <button type="submit">Add</button>
        </form>
        <!-- Display the action result message -->
        <p>${requestScope.addAdminActionCompleted} ${requestScope.addAdminMessage}</p>
    </div>

    <%-- Remove Admin Form --%>
    <div class="remove_admin">
        <h3>Remove Admin</h3>
        <form action="admin-servlet" method="post">
            <!-- Input fields for removing an admin -->
            <input type="hidden" name="action" value="removeAdmin">
            <input type="text" name="removeAdminUsername" placeholder="Username" required>
            <input type="text" name="removeAdminPassword" placeholder="Password" required>
            <button type="submit">Remove</button>
        </form>
        <!-- Display the action result message -->
        <p>${requestScope.removeAdminActionCompleted} ${requestScope.removeAdminMessage}</p>
    </div>

    <!-- User Table -->
    <div class="user_table">
        <h3>User Table</h3>
        <!-- Center the "Load Users" button -->
        <div style="text-align: center;">
            <form action="user-table-servlet" method="GET">
                <button type="submit">Load Users</button>
            </form>
        </div>
        <table>
            <thead>
            <tr>
                <th>Username</th>
                <th>Permission</th>
            </tr>
            </thead>
            <tbody>
            <% ArrayList<UserView> userList = (ArrayList<UserView>) request.getAttribute("userList");
                if (userList != null && userList.size() > 0) {
                    for (UserView user : userList) {
            %>
            <!-- Generate a table row for each user -->
            <tr>
                <td><%= user.getUsername() %></td>
                <td><%= user.getPermission() %></td>
            </tr>
            <% } } else { %>
            <tr>
                <td colspan="2">No users found</td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
