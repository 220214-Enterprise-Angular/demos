/*
 * PL/pgsql - Procedural Language Extension of PostgreSQL 
 * 
 * - NOT a sublanguage of SQL
 * - Allows devs to create:
 * 		- stored functions
 * 		- stored procedures
 * 		- triggers
 * 		- custom types (enums)
 * 
 * - Adds procedural features to the normally declarative sql scripts
 * 		- loops
 * 		- exception handling
 * 		- if statements
 * 
 * Stored Functions (return a value)
 * 
		create [or replace] function [name] (params)
		returns [type]
		as '
			begin
				[logic]
			end
		'
		language plpgsql;
 */

-- aggregate functions like avg, max...etc...
-- multiply function - takes in 2 params, returns 1.  Is called with a select statment

CREATE OR REPLACE FUNCTION multiply(x INTEGER, Y INTEGER)
RETURNS INTEGER
AS $$

	BEGIN
		RETURN x * y;
		
	END
	
$$
LANGUAGE plpgsql;

-- how do we call the above function?

SELECT multiply(2, 5);
SELECT multiply(10, '20'); -- postgresql IS capable  OF TYPE coercion!


CREATE TABLE colors (
	
	id SERIAL PRIMARY KEY,
	color VARCHAR

);

CREATE TABLE sizes (
	
	id SERIAL PRIMARY KEY,
	size_desc VARCHAR -- XS, S, M, L , XL, XXL

);


INSERT INTO SIZES (SIZE_DESC) 
	VALUES ('S'), ('M'), ('L');

INSERT INTO colors (color) 
	VALUES ('red'), ('orange'), ('yellow');


-- DEFINE A FUNCTION THAT THAT WILL PREVENT BLUES FROM BEING INSERTED INTO THE COLOR TABLE
CREATE OR REPLACE FUNCTION no_more_blues() 
RETURNS TRIGGER
AS $$ 

	BEGIN
		IF (NEW.color = 'blue') THEN
		-- maybe decrease the serial sequence by one
		RETURN NULL; -- WILL NOT ADD ANYTHING INTO THE TABLE
		
		END IF; -- this IS LIKE a closing curly bracket IN SQL
			
		-- If the above statement is not true;
		RETURN NEW; -- GO FORWARD AND INSERT the record
	END

$$ 
LANGUAGE plpgsql;

CREATE TRIGGER no_blue
	BEFORE INSERT OR UPDATE ON colors
	FOR EACH ROW
	EXECUTE FUNCTION no_more_blues();
	
INSERT INTO colors (color) VALUES ('magenta');
INSERT INTO colors (color) VALUES ('blue');
INSERT INTO colors (color) VALUES ('chartreuse');

SELECT * FROM COLORS;

-- sequential scan O(n)
EXPLAIN SELECT * FROM colors WHERE color = 'magenta';


CREATE INDEX fast_colors ON colors(color);

-- INdexes are physical pointers that represent the address of data
-- indexes are only created on column of tables
-- unique & primary keys automatically create indexes
-- they allow us a way to fetch a value faster







