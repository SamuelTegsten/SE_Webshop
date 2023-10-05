<%@ page import="java.util.ArrayList" %>
<%@ page import="com.web.se_webshop.View.ObjectView.ItemView" %>
<%@ page import="com.web.se_webshop.View.ObjectView.CartDetails" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400;500;600;700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css">
</head>
<body>
<jsp:include page="navbar.jsp"/>

<div class="small-container">
    <h2 class="title">Products</h2>
    <form id="search-items-form" action="${pageContext.request.contextPath}/item-servlet" method="post">
        <div class="search_item">
            <input type="hidden" name="command" value="SEARCH">
            <input type="text" name="search_text">
            <button type="submit">Search</button>
        </div>
    </form>
    <div class="row">

        <!-- The Products are looped here -->
        <%
            ArrayList<CartDetails> cart = (ArrayList<CartDetails>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<CartDetails>();
                session.setAttribute("cart", cart);
            }

            ArrayList<ItemView> foundItems = (ArrayList<ItemView>) request.getAttribute("found-items");
            if (foundItems != null) {
                for (ItemView item : foundItems) {
        %>
        <div class="col-4">
            <img src=<%=item.getPicture()%> width="250px" height="250px">
            <h3><%=item.getName()%>
            </h3>

            <div class="stock">
                <%
                    if (item.getStockNumber() > 0) {
                %>
                <div class="stock-info">
                    <h5>In Stock  <%= item.getStockNumber() %></h5>
                    <i class="fa fa-check-circle"></i>
                </div>
                <%} else {%>
                <div class="stock-info-1">
                    <h5>Out of Stock</h5>
                    <i class="fa fa-times-circle"></i>
                </div>
                <% }%>
            </div>
            <p>price: <%= item.getPrice()%></p>
            <div class="add-to-cart-container">
                <form action="AddToCartServlet" method="post">
                    <select name="quantity" class="quantity-select">
                        <option
                        <% for (int i = 1; i <= 99; i++) { %>
                        <option value="<%= i %>"><%= i %>
                        </option>
                        <% } %>
                    </select>
                    <input type="hidden" name="item_name" value= <%=item.getName()%>>
                    <button type="submit" class="add-to-cart">Add to Cart</button>
                </form>
            </div>
        </div>
        <% }
        }%>
    </div>
</div>
</body>
</html>
