DROP TABLE IF EXISTS ingredients;


CREATE TABLE ingredients(
id SERIAL8 PRIMARY KEY,
name VARCHAR(255),
price DECIMAL,
amount INT4
);
