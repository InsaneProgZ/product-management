-- Create table script
CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    price INT NOT NULL,
    brand VARCHAR(255) NOT NULL
);

-- Insert data script
INSERT INTO product (name, price, brand) VALUES
    ('Product1', 100, 'Brand1'),
    ('Product2', 150, 'Brand2'),
    ('Product3', 200, 'Brand3');