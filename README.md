# Samuel & Esteban WebShop

## Description
Welcome to the Samuel & Esteban WebShop project! This web application is designed to provide a seamless shopping experience for users. Below, you'll find an overview of the different sections of the web view.

## Web View Sections

### HOME
The home page is designed to provide a visually appealing and welcoming introduction to our webshop. It includes promotional banners, featured products, and important business information.
![bild](https://github.com/SamuelTegsten/SE_Webshop/assets/92243583/0044b9ae-2b94-4a4d-93f5-de7cf049dcca)

### PRODUCTS
The products page displays a list of the products available for purchase in our webshop. Each product listing includes details such as product name, price, description, and an option to add the product to the cart.
![bild](https://github.com/SamuelTegsten/SE_Webshop/assets/92243583/5f73ec51-d45a-4466-9fe4-89825ffc0a5b)

### ACCOUNT
In the account section, users can perform actions related to their accounts, including:
- **Login**: Users can log in using their credentials (username/email and password).
- **Register**: New users can create an account by providing necessary information like username, email, password, etc.
- ![bild](https://github.com/SamuelTegsten/SE_Webshop/assets/92243583/040cc736-05c3-43b3-a8c8-46093199e824)
- ![bild](https://github.com/SamuelTegsten/SE_Webshop/assets/92243583/926bb101-2835-49ad-9d57-4d5c9ce865be)

### STAFF
The staff section is dedicated to staff members who have specific roles within our webshop. Staff members can perform the following actions:
- **Pack Items**: Staff can view orders and mark items as packed for shipping.
- **Add Items**: Staff can add new products to the product catalog.
- **Remove Items**: Staff can remove products from the catalog.
- ![bild](https://github.com/SamuelTegsten/SE_Webshop/assets/92243583/28bf6b9d-5a0c-4b0f-9cf6-c7b1bed59d7f)
- ![bild](https://github.com/SamuelTegsten/SE_Webshop/assets/92243583/4b927d90-48f7-47ad-89af-e19895ffef86)

### ADMIN
The admin section is intended for administrators with higher-level privileges. Admins can perform administrative tasks, including:
- **Remove Users**: Admins have the authority to remove user accounts if necessary.
- **Add Users**: Admins can add new users to the system, including staff and other admins.
- **List Users**: Admins can access a list of all users registered on the platform.
- ![bild](https://github.com/SamuelTegsten/SE_Webshop/assets/92243583/88849a6c-b15e-4564-a47e-a625aa4acb76)
- ![bild](https://github.com/SamuelTegsten/SE_Webshop/assets/92243583/9872f769-5731-4e3d-995e-35ef2cbbe3aa)

### CART 
Lists all items added to the cart
- **Purchase**: Buy all items added to the cart.
- **Log In**: If user is not logged in, first needs to log in.
![bild](https://github.com/SamuelTegsten/SE_Webshop/assets/92243583/492af5bf-d505-4059-9ae6-ca288d9a10d8)

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
