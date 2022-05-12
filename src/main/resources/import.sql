
DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), cost int);
INSERT INTO products (title, cost) VALUES
('Apple', 25),
('Coconut', 35),
('Melon', 45),
('Watermelon', 55),
('Orange', 65),
('Tomatoes', 95),
('Bananas', 135),
('Broomstick', 75),
('Mandarins', 85),
('Mango', 125);

DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES
('Alexander'),
('Vladimir'),
('Sergei'),
('Alexey'),
('Bob');

DROP TABLE IF EXISTS products_customers CASCADE;
CREATE TABLE products_customers (product_id bigint, customer_id bigint, FOREIGN KEY (product_id) REFERENCES products (id), FOREIGN KEY (customer_id) REFERENCES customers (id));
INSERT INTO products_customers (product_id, customer_id) VALUES
(1, 1),
(1, 3),
(2, 2),
(3, 3),
(4, 4),
(4, 4),
(5, 5),
(6, 1),
(7, 2),
(7, 2),
(8, 3),
(9, 4),
(10,5),
(10,1);



