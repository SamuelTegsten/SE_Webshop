# Samuel & Esteban WebShop

# Description
<p align="center">
  Welcome to the Samuel & Esteban WebShop project! This web application is designed to provide a seamless shopping experience for users. Below, you'll find an overview of the different sections of the web view.
</p>

---

# Business Objects, Database, and Controllers

<p align="center">
  <img src="repoImage/java.png" alt="Business Objects and Database">
</p>

---

# View

## Index.jsp
<p align="center">
  <img src="repoImage/index_jsp.png" alt="Index.jsp">
  <br>
  Description: The index page of our web application.
</p>

---

## Product.jsp
<p align="center">
  <img src="repoImage/product_jsp.png" alt="Product.jsp">
  <br>
  Description: The product page displaying items for sale.
</p>

---

## Account.jsp
<p align="center">
  <img src="repoImage/account_jsp.png" alt="Account.jsp">
  <br>
  Description: User account management page.
</p>

---

## Success.jsp
<p align="center">
  <img src="repoImage/success_jsp.png" alt="Success.jsp">
  <br>
  Description: Confirmation page for successful transactions.
</p>

---

## Orders.jsp
<p align="center">
  <img src="repoImage/orders_jsp.png" alt="Orders.jsp">
  <br>
  Description: View and manage user orders.
</p>

---

## Admin.jsp
<p align="center">
  <img src="repoImage/admin_jsp.png" alt="Admin.jsp">
  <br>
  Description: Admin panel for site management.
</p>

---

## Cart.jsp
<p align="center">
  <img src="repoImage/cart_jsp.png" alt="Cart.jsp">
  <br>
  Description: Shopping cart for users.
</p>

---

# Database Structure
```sql
CREATE DATABASE sql_webshop;
USE sql_webshop;

CREATE TABLE item (
    name VARCHAR(255) PRIMARY KEY,
    picture VARCHAR(255),
    category VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL,
    stockNumber INT NOT NULL
);

CREATE TABLE user (
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    permission ENUM('USER', 'STAFF', 'ADMIN') NOT NULL,
    UNIQUE (username),
    UNIQUE (password)
);

CREATE TABLE `order` (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    item_name VARCHAR(255) NOT NULL,
    number_of_items INT NOT NULL,
    address TEXT,
    status ENUM('IN_PROGRESS', 'SENT', 'COMPLETED') NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
