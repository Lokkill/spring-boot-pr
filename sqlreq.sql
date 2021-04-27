BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(100), price float);
INSERT INTO products (title, price) VALUES
('Water', 20),
('Bread', 30),
('Tea', 45),
('Milk', 55),
('Ice cream', 35);

DROP TABLE IF EXISTS buyers CASCADE;
CREATE TABLE buyers (id bigserial PRIMARY KEY, title VARCHAR(255));
INSERT into buyers (title) VALUES
('Jhon'),
('Tom'),
('Alice');

DROP TABLE IF EXISTS buyers_products CASCADE;
CREATE TABLE buyers_products (buyer_id bigint, product_id bigint, FOREIGN KEY (buyer_id) REFERENCES buyers (id), FOREIGN KEY (product_id) REFERENCES products (id));
INSERT Into buyers_products (buyer_id, product_id) VALUES
(1,1),
(1,2),
(2,1),
(2,4),
(2,5),
(3,1),
(3,3),
(3,5);

COMMIT;