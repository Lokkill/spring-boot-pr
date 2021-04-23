BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(100), price float);
INSERT INTO products (title, price) VALUES
('Water', 20),
('Bread', 30),
('Tea', 45),
('Milk', 55),
('Ice cream', 35);

COMMIT;