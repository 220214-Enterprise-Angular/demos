-- DDL - Data Definition Language (tables, columns)
-- DML - Data Manipulation Language (rows - tuples)
-- DCL -  Data Control Language (GRANT, REVOKE)
-- TCL - Transaction Control Language 
-- DQL - Data Query Language (SELECT, JOIN...)


-- create a user
CREATE USER harrypotter WITH PASSWORD 'hedwig';

CREATE ROLE special_user WITH
	LOGIN 
	CREATEDB
	CREATEROLE
	INHERIT rds_ad;
	

-- ASSIGN THE ROLE TO harrypotter 
GRANT special_user TO harrypotter ;


GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA hogwarts TO harrypotter;
REVOKE  ALL PRIVILEGES ON ALL TABLES IN SCHEMA hogwarts FROM harrypotter;