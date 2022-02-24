CREATE TABLE one (
	col_one INTEGER PRIMARY KEY,
	col_two INTEGER
);

CREATE TABLE two (
	col_one INTEGER PRIMARY KEY,
	col_two INTEGER
);

-- this is just another way of declaring a foreign key
-- ALTER TABLE two 
--	 ADD CONSTRAINT table_one_fk 
--	 FOREIGN KEY col_two REFERENCES  one(col_one);

SELECT * FROM one;
SELECT * FROM two;

INSERT INTO one VALUES (1, 1), (2, 2), (3, 3), (4, 4);
INSERT INTO two VALUES (1, 100), (2, 200), (3, 300), (4, 400);


-- SET operations are a type of DQL (Data Query Language) in which
-- we can combine data from two tables in one result

-- UNION
SELECT * FROM one UNION SELECT * FROM two;
-- UNION operator combines results from 2 tables together and excludes
-- duplicates

-- SET 

-- UNION ALL -- allows duplicates

SELECT * FROM one UNION ALL SELECT * FROM two;

-- INTERSECT OPERERATOR
CREATE VIEW matching_data AS
SELECT * FROM one INTERSECT SELECT * FROM two;

SELECT * FROM matching_data ;

---------
-- SCALAR & Aggregate functions
SELECT * FROM users;

-- Scalar functions performa an action to each value within a table and returns it 
SELECT upper(first_name), email FROM users; 

-- aggregate functions
-- operate on an entiere column and produce 1 output
SELECT max(first_name) FROM users;
SELECT COUNT(first_name) FROM USERS;
SELECT AVG(COL_ONE) FROM one;

-- AVERGAE LENGTH OF A USERNAME IN OUR USERS TABLE
SELECT AVG(LENGTH(first_name)) FROM users;














) 



