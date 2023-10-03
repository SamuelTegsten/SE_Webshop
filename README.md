# Samuel & Esteban WebShop

## Description
Welcome to the Samuel & Esteban WebShop project! This web application is designed to provide a seamless shopping experience for users. Below, you'll find an overview of the different sections of the web view.

## Web View Sections

### HOME
The home page is designed to provide a visually appealing and welcoming introduction to our webshop. It includes promotional banners, featured products, and important business information.

#### JSP View (index.jsp)
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- meta tags, title, and links here -->
</head>
<body>
    <!--  HTML content for  home page here -->
</body>
</html>

### PRODUCTS
The products page displays a list of the products available for purchase in our webshop. Each product listing includes details such as product name, price, description, and an option to add the product to the cart.

### ACCOUNT
In the account section, users can perform actions related to their accounts, including:
- **Login**: Users can log in using their credentials (username/email and password).
- **Register**: New users can create an account by providing necessary information like username, email, password, etc.

### STAFF
The staff section is dedicated to staff members who have specific roles within our webshop. Staff members can perform the following actions:
- **Pack Items**: Staff can view orders and mark items as packed for shipping.
- **Add Items**: Staff can add new products to the product catalog.
- **Remove Items**: Staff can remove products from the catalog.

### ADMIN
The admin section is intended for administrators with higher-level privileges. Admins can perform administrative tasks, including:
- **Remove Users**: Admins have the authority to remove user accounts if necessary.
- **Add Users**: Admins can add new users to the system, including staff and other admins.
- **List Users**: Admins can access a list of all users registered on the platform.

## Business Object
[Provide a brief description of the business object if applicable.]

## Database
The Samuel & Esteban WebShop project uses a MySQL database to store essential data. Below is the database structure and an example of data insertion:

### Database Structure
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

CREATE TABLE `order`(
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    item_name VARCHAR(255) NOT NULL,
    number_of_items INT NOT NULL,
    address TEXT,
    status ENUM('IN_PROGRESS', 'SENT', 'COMPLETED') NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
