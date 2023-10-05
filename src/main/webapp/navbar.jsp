<%--
  Created by IntelliJ IDEA.
  User: Esteban
  Date: 2023-10-04
  Time: 14:52 pm
  To change this template use File | Settings | File Templates.
--%>

<%
    String userRole = (String) session.getAttribute("userRole");
    if (userRole == null) {
        // Redirect to login page or handle unauthorized access
        response.sendRedirect("account.jsp");
    }
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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

                        <% if (userRole == null) { %>
                        <li><a href="account.jsp">Account</a></li>
                        <% } else { %>
                        <li><a href="success.jsp">Account</a></li>
                        <% } %>

                    <%-- Show the "Orders" tab to Staff and Admin --%>
                        <% if ("STAFF".equals(userRole) || "ADMIN".equals(userRole)) { %>
                        <li><a href="orders.jsp">Orders</a></li>
                        <% } %>

                        <%-- Show the "Admin" tab only to Admin --%>
                        <% if ("ADMIN".equals(userRole)) { %>
                        <li><a href="admin.jsp">Admin</a></li>
                        <% } %>

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
</body>
</html>
