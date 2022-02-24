
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
		
SELECT * FROM sophiag.users;
SELECT * FROM sophiag.accounts;
SELECT * FROM sophiag.users_accounts_jt;
		
DROP TABLE IF EXISTS sophiag.users_accounts_jt CASCADE;
CREATE TABLE users_accounts_jt (
	
	acc_owner INTEGER NOT NULL REFERENCES sophiag.users(id),
	account INTEGER NOT NULL REFERENCES sophiag.accounts(id)

);

-- Define sometype of function so that everytime an account associated with a user is added to the accounts table
-- the info in the users_accounts_jt table is automatically updated
-- triggers & functions
















