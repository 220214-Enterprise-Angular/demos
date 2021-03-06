-- TCL
-- A transaction is a unit of work to be
-- performed against a database that adheres to a special set of properties

-- A.C.I.D

-- A - Atomic (Atomicity) - It happens or it doesn't
-- C = Consistency: Referential Integrity is maintained and constraints are changed properly upon successful transaction
-- I = Isolation: Transactions occur independently of eachother
-- D = Durability: Ensures that the result of a commited transaction persists in the case of system failure.


CREATE TABLE dummy_bank_accounts (

	cust_name VARCHAR(50),
	balance NUMERIC(50, 2)

);
INSERT INTO dummy_bank_accounts (cust_name, balance) 

	VALUES ('Alice', 100),
			('Bob', 50),
			('Sam', 0);

SELECT * FROM dummy_bank_accounts;

-- Alice sends 20 to Bob 
-- update alice
UPDATE dummy_bank_accounts SET balance = balance - 20 WHERE cust_name = 'Alice';

-- add the bob
UPDATE dummy_bank_accounts SET balance = balance + 20 WHERE cust_name = 'Bob';


BEGIN;

	UPDATE dummy_bank_accounts SET balance = balance - 20 WHERE cust_name = 'Alice';

	
	SAVEPOINT my_savepoint; 
-- SAVEPOINTS allow you to selectively discard parts of the transcation while commiting the rest

	UPDATE dummy_bank_accounts SET balance = balance + 20 WHERE cust_name = 'Sam';


	ROLLBACK TO my_savepoint;
-- WHOOPS! DIdn't mean to send moeny to Sam, meant to send it to Bob instead....	

	UPDATE dummy_bank_accounts SET balance = balance + 20 WHERE cust_name = 'Bob';

COMMIT;

-- conn.setTransactionLevel(CONNECTION.SERIALIZABLE);

-- How to commit a tx from jdbc
-- https://mkyong.com/jdbc/jdbc-transaction-example/

-- Transactions are ACIDic
-- - A proper TRANSACTION must have the following properties:

-- A = Atomicity: it either happens or it doesn't.
-- C = Consistency: Referential Integrity is maintained and constraints are changed properly upon successful transaction
-- I = Isolation: Transactions occur independently of eachother
-- D = Durability: Ensures that the result of a commited transaction persists in the case of system failure.

------------------------------------------------------------------------------------------------------


-- Transaction Problems: sometimes issues occur with transactions interfering with eachother
-- and getting ROLLED BACK due to the concurrent nature of a DB.

-- Dirty Read: A tx reads data from another transaction that hasn't been commited.
-- Non-Repeatable Read: 1 tx reads the same data TWICE while another tx updates the data in between the 1st and 2nd
-- Phantom Read: tx runs a query twice and gets diff data each time. Llike a diff # of ROWS 

-----------------------------------------------------------------------------------

-- Transaction Isolation Level: The higher the isolation level (the highest is called Serializable)
-- the more careful the system is about avoiding conflicts.

-- https://www.geeksforgeeks.org/transaction-isolation-levels-dbms/





















