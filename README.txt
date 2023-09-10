SQL: 
create database spring_dz25;
create table spring_dz25.orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    cost DECIMAL(10, 2)
);

create table spring_dz25.products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(255),
    cost DECIMAL(10, 2)
);

CREATE TABLE spring_dz25.order_products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    product_id INT,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

