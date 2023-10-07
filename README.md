# Samuel & Esteban WebShop

## Description
Welcome to the Samuel & Esteban WebShop project! This web application is designed to provide a seamless shopping experience for users. Below, you'll find an overview of the different sections of the web view.

## Business Objects, Database, and Controllers
![UML Visual for our BO and DB files in our Java project](repoImage/java.png)

## View

### Index.jsp
![Index.jsp](repoImage/index_jsp.png)

### Product.jsp
![Product.jsp](repoImage/product_jsp.png)

### Account.jsp
![Account.jsp](repoImage/account_jsp.png)

### Success.jsp
![Success.jsp](repoImage/success_jsp.png)

### Orders.jsp
![Orders.jsp](repoImage/orders_jsp.png)

### Admin.jsp
![Admin.jsp](repoImage/admin_jsp.png)

### Cart.jsp
![Cart.jsp](repoImage/cart_jsp.png)

## Database Structure
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
