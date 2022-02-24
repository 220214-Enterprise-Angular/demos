
DROP TYPE IF EXISTS sophiag.user_role CASCADE;
CREATE TYPE sophiag.user_role AS ENUM ('Admin', 'Customer', 'Employee');
-- enums are static, custom types

DROP TABLE IF EXISTS sophiag.users CASCADE;
CREATE TABLE sophiag.users (
	
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	pwd VARCHAR(50) NOT NULL,
	-- we're stating that any value inserted into this column MUST be of the ENUM types
	user_role_name sophiag.user_role NOT NULL
);

DROP TABLE IF EXISTS sophiag.accounts CASCADE;
CREATE TABLE sophiag.accounts (
	
	id SERIAL PRIMARY KEY,
	balance NUMERIC(50, 2) DEFAULT 0, -- 123131231.09 IS ALLOWED
	acc_owner INTEGER REFERENCES sophiag.users(id),
	active BOOLEAN DEFAULT FALSE -- this determines whether the account has been approved
);


INSERT INTO sophiag.users (username, pwd, user_role_name)
	VALUES ('Larry', 'secret', 'Employee'),
			('Marry', '1234', 'Admin'),
			('Barry', 'pass', 'Employee');
		

DROP TABLE IF EXISTS sophiag.users_accounts_jt CASCADE;
CREATE TABLE users_accounts_jt (
	
	acc_owner INTEGER NOT NULL REFERENCES sophiag.users(id),
	account INTEGER NOT NULL REFERENCES sophiag.accounts(id)

);

-- Define sometype of function so that everytime an account associated with a user is added to the accounts table
-- the info in the users_accounts_jt table is automatically updated
-- triggers & functions

CREATE OR REPLACE FUNCTION sophiag.auto_insert_into_jt()
RETURNS TRIGGER 
AS $$

	BEGIN
		-- INSERT INTO ANOTHER TABLE
		INSERT INTO sophiag.users_accounts_jt(acc_owner, account)
		-- INSERTING THE VALUES OF NEW.ACC_OWNER, NEW.ID <- THAT'S POINTING TO THE ID OF THE ACCOUNT THAT THE USER OWNS
			VALUES (NEW.acc_owner, NEW.id);
		
		RETURN NEW; -- MAKE SURE WE STILL CONTINUE TO INSERT THE ACCOUNT RECORD INTO THE ACCOUNTS TABLE
	END

$$ 
LANGUAGE plpgsql;

CREATE TRIGGER trig 
	AFTER INSERT ON sophiag.accounts 
	FOR EACH ROW
	EXECUTE FUNCTION sophiag.auto_insert_into_jt();


SELECT * FROM sophiag.users;
SELECT * FROM sophiag.accounts;
SELECT * FROM sophiag.users_accounts_jt;
		
INSERT INTO sophiag.accounts (balance, acc_owner, active) 
	VALUES (2000, 1, TRUE);

INSERT INTO sophiag.accounts (balance, acc_owner, active) 
	VALUES (20, 2, FALSE),
			(1000000, 4, TRUE);
		
		
-- THIS IS GOING TO BE A join statement so we can return all user data and the user's associated accounts
		
		
-- user id, username, pwd, role, account id, account balance, isActive
SELECT users.id, users.username, users.pwd, users.user_role_name, accounts.id AS account_id, accounts.balance, accounts.active
	FROM users
	LEFT JOIN users_accounts_jt ON users.id = users_accounts_jt.acc_owner 
	LEFT JOIN accounts ON accounts.id  = users_accounts_jt.account;
		
		
		
		

-- this is only returning the accounts for one person
SELECT sophiag.accounts.id, sophiag.accounts.balance 
FROM sophiag.accounts
	INNER JOIN sophiag.users_accounts_jt 
		ON sophiag.accounts.id = sophiag.users_accounts_jt.acc_owner 
			WHERE sophiag.users_accounts_jt.acc_owner = 2;
		
		
		
		
		
		
		















