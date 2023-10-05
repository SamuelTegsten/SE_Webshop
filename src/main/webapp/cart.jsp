<%@ page import="com.web.se_webshop.View.ObjectView.CartDetails" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.web.se_webshop.View.ObjectView.ItemView" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart | Webshop</title>
    <!-- Link to external CSS stylesheets -->
    <link rel="stylesheet" href="Style/style.css">
    <link rel="stylesheet" href="Style/cartStyle.css">
    <!-- Link to Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400;500;600;700&display=swap"
          rel="stylesheet">
    <!-- Link to Font Awesome icons -->
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css">
</head>

<body>
<jsp:include page="navbar.jsp"/>

<div class="container">
    <form id="add-item-form" action="${pageContext.request.contextPath}/OrderServlet" method="post">

    <div class="cart-table">
        <table>
            <thead>
            <tr>
                <!-- Table headers for cart items -->
                <th>Image</th>
                <th>Item Name</th>
                <th>Item Price</th>
                <th>Item Category</th>
                <th>Quantity</th>
            </tr>
            </thead>
            <tbody>

            <!-- Cart item -->
            <%
                ArrayList<CartDetails> cart = (ArrayList<CartDetails>) session.getAttribute("cart");
                if (cart != null) {
                    for (CartDetails cartDetail : cart) {
                        ItemView item = cartDetail.getItem();

            %>
            <tr>
                <td><img src=<%=item.getPicture()%> width="50px" height="50px"></td>
                <td><%=item.getName()%>
                </td>
                <td>kr <%=item.getPrice()%>
                </td>
                <td><%=item.getCategory()%>
                </td>
                <td class="quantity">
                    <!-- Quantity control buttons -->
                    <button class="decrease">-</button>
                    <input type="number" name="quantity" value="<%=cartDetail.getNumberOfItems()%>" min="1">
                    <button class="increase">+</button>
                </td>
            </tr>

            <%
                    }
                }
            %>
            <tr>


                <% if (cart != null) {%>
                <td colspan="5">
                    Address to deliver: <input type="text" id="static_textarea_1" name="address">
                </td>
                <%}%>

            </tr>
            </tbody>
        </table>
        <div class="total-amount">
            <label>Total Amount:</label>
            <% if (cart != null) {%>
            <%=CartDetails.getTotalAmount(cart)%> kr
            <%} else {%>
            0 kr
            <%}%>
        </div>
    </div>

    <!-- Cart action buttons -->
    <div class="cart-buttons">
        <%
            System.out.println(session.getAttribute("active-session"));
            if (session.getAttribute("active-session") == null || (boolean) session.getAttribute("active-session") == false) {
        %>
            <div>
                <input type="hidden" name="command" value="loginRedirect">
                <button class="login-button">Log In</button>
            </div>
        <% } else { %>
            <div>
                <input type="hidden" name="command" value="AddOrder">
                <button type="submit" class="purchase-button">Purchase</button>
            </div>

        <% }%>

    </div>
    </form>
</div>
</body>
</html>
