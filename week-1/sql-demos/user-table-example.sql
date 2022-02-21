
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	id SERIAL PRIMARY KEY, -- SERIAL is a datatype that automatically increments and generates itself
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	role VARCHAR(255) NOT NULL
);

INSERT INTO users (username, password, first_name, last_name, role)
VALUES ('bach_tran', '12345', 'Bach', 'Tran', 'Admin'),
		('jane_doe', 'password123', 'Jane', 'Doe', 'Customer'),
		('john_doe', 'john123', 'John', 'Doe', 'Employee');
		
	
SELECT *
FROM users;