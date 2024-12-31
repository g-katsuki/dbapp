# Database Setup Instructions

To set up the necessary database tables for this application, follow the steps below.

## Prerequisites
- MariaDB or MySQL installed and running.
- Access to the database where the tables will be created.

## Steps to Execute

1. Execute the following SQL script to create tables:
   ```sql
   CREATE TABLE product (
       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       count INT NOT NULL
   );

   CREATE TABLE user (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    pass VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
   );

   CREATE TABLE user_product_mapping (
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE ON UPDATE CASCADE
   );
