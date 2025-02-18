DROP TABLE product IF EXISTS;

CREATE TABLE product (
    productId VARCHAR(20) NOT NULL,
    productName VARCHAR(20),
    productDesc VARCHAR(60),
    price VARCHAR(30)
);
