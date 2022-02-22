-- DQL: Data Query Language
 -- SELECT col_1, col_2 FROM table_name;

-- Ordering is not guratnteed if you don't provide logic
SELECT * FROM users ORDER BY first_name; -- ADD DESC AFTER the COLUMN name TO CHANGE the ORDER TO descendfing ORDER

SELECT first_name, last_name FROM users;

-- VIEWS are virutal tables as the result of a query used to speed up data retrival 
CREATE VIEW names AS SELECT first_name || ' ' || last_name AS "Full Name" FROM users;

SELECT * FROM names;

SELECT * FROM users WHERE id > 3;

SELECT * FROM users 
	WHERE first_name > 'B'
	ORDER BY last_name
	LIMIT 2;

