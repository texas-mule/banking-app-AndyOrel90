--inserts user and returns its id
CREATE OR REPLACE FUNCTION insertuser (_firstname VARCHAR, _lastname VARCHAR, _username VARCHAR, _password VARCHAR, _usertype VARCHAR) 
RETURNS TABLE (
	userid BIGINT
)
AS
$$
DECLARE
	_userid BIGINT;
BEGIN
	INSERT INTO "Users" (firstname, lastname, username, password, usertype) VALUES (_firstname, _lastname, _username, _password, _usertype);
END;
$$ language plpgsql;