-- DML: Data Manipulation Language
-- DDL is about describing tables, DML is about MANIPULATING the data within the tables

-- DML Commands -------- DQL (Data QUery Language )
-- INSERT          
-- UPDATE
-- DELETE
-- (SELECT)						(SELECT)

-- INSERTION ANATOMY
-- INSERT INTO table_name(column1, column2, …)
--		VALUES (value1, value2, …) 

-- columns that have nullable values DON'T need to be included in the insert statement

SELECT * FROM users;

INSERT INTO users(first_name, last_name, email, pwd)
	VALUES ('Hayden', 'Hayes', 'hayden@gmail.com', 'secretpass');

-- Truncate only wipes all data from the table, it doesn't drop the table (the serial id sequence remains)
TRUNCATE TABLE users CASCADE; -- what's the difference BETWEEN TRUNCATE, DELETE AND DROP IN SQL?

DROP TABLE users CASCADE; -- COMPLETELY DELETED THE TABLE

-- delete IS DML! dELETE deletes a record from a table
DELETE FROM users WHERE id = 1; -- deletes Hayden

-- insert multiple rows into the users table 
INSERT INTO users (first_name, last_name, email, pwd) -- ctrl + enter runs JUST the STATEMENT
	VALUES ('Abby', 'Adams', 'abby@aol.com', '1123'),
			('Billy', 'Bob', 'billy@yahoo.com', 'pass'),
			('Cathy', 'Carter', 'cathy@gmail.com', 'secret'),
			('Danny', 'DaVito', 'dannuy@revature.net', '928');

UPDATE users SET last_name = 'Bingo' WHERE id = 3;

SELECT * FROM users ORDER BY id; -- ORDER BY IS IN ascending ORDER BY DEFAULT

-- CHALLENGE:
-- PROVIDE DATA FOR THE OTHER 2 TABLES (posts & likes) 

-- Abby should post a message on Hayden's walls, which Danny likes
-- Cathy should post a message on her own wall, which both abby and danny like
-- Hayden will post a message on Danny's wall, which Cathy and Hayden like

INSERT INTO posts (author_id, wall_user_id, post_content) 
	VALUES (2, 1, 'Hey Hayden, its Abby'),
			(4, 4, 'Im Cathy!'),
			(1, 5, 'Hey Danny, its Hayden');
		
SELECT * FROM likes;
		
INSERT INTO likes (user_id, post_id) 
	VALUES (5, 1),
			( 2, 2), -- Abby's LIKE
			( 5, 2), -- Danny's LIKE
			(4, 3), -- Cathy's like
				(1, 3); -- Hayden's LIKE




