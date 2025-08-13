-- Table product
CREATE TABLE product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         price DECIMAL(15, 2) NOT NULL,
                         created_by VARCHAR(100) NOT NULL,
                         created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         updated_by VARCHAR(100)
);

-- Table status
CREATE TABLE status (
                        id INT PRIMARY KEY,
                        name VARCHAR(50) NOT NULL
);

-- Table transaction
CREATE TABLE transaction (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             product_id BIGINT NOT NULL,
                             amount DECIMAL(15, 2) NOT NULL,
                             customer_name VARCHAR(100) NOT NULL,
                             status_id INT NOT NULL,
                             transaction_date TIMESTAMP NOT NULL,
                             create_by VARCHAR(100) NOT NULL,
                             create_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             update_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             update_BY VARCHAR(100),
                             CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product(id),
                             CONSTRAINT fk_status FOREIGN KEY (status_id) REFERENCES status(id)
);
