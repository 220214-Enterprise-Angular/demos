-- This is a Comment in SQL
-- Structured Query Language

-- DDL: Data Definition Language
-- Kinds of DDL Statements
-- CREATE -- create a new table
-- ALTER -- change an existing table 
-- DROP -- delete the table entirely
-- TRUNCATE -- keep the table, wipe all data within it

-- CREATE TABLE table_name 
CREATE TABLE IF NOT EXISTS users ( 
	-- col-name col-type constraints
	id SERIAL PRIMARY KEY, -- automatically indicates unqique AND NOT-NULL
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30),
	email VARCHAR(50) NOT NULL UNIQUE,
	pwd VARCHAR(100) NOT NULL
); -- highlight AND press ctrl + enter TO run a snippet 

DROP TABLE users;

CREATE TABLE IF NOT EXISTS posts (
	id SERIAL PRIMARY KEY,
	author_id INTEGER REFERENCES users(id) NOT NULL,
	wall_user_id INTEGER REFERENCES users(id) NOT NULL, -- a post has the author's id, and id of the user whose it's on
	post_content VARCHAR(250) NOT NULL
);

-- ALTER -- used to modify an existing table
ALTER TABLE users
	ADD COLUMN tester INTEGER;

ALTER TABLE users
	ALTER COLUMN tester SET NOT NULL; -- TO ALTER the COLUMN

ALTER TABLE users
	ALTER COLUMN tester SET DEFAULT 0; -- IN the CASE that SOMEone entered a NULL value 

-- delete column tester 
ALTER TABLE users
	DROP COLUMN tester;

-- DQL DATA Query Language
SELECT * FROM users;

-- likes table 
CREATE TABLE IF NOT EXISTS likes (
	
	user_id INTEGER REFERENCES users(id) NOT NULL, -- SET AS a FOREIGN KEY TO point TO id IN Users TABLE
	post_id INTEGER REFERENCES posts(id) NOT NULL, -- SET AS a FOREIGN KEY TO point TO id IN posts TABLE
	PRIMARY KEY (user_id, post_id) -- composite KEY
);