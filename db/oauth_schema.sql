CREATE SCHEMA IF NOT EXISTS oauth;

CREATE TABLE IF NOT EXISTS oauth.oauth_access_tokens (
	access_token varchar(40) PRIMARY KEY,
	client_id varchar(80),
	user_id varchar(80),
	expires timestamp NOT NULL,
	scope varchar(4000)
);

CREATE TABLE IF NOT EXISTS oauth.oauth_authorization_codes (
	authorization_code varchar(40) PRIMARY KEY,
	client_id varchar(80),
	user_id varchar(80),
	redirect_uri varchar(2000) NOT NULL,
	expires timestamp NOT NULL,
	scope varchar(4000),
	id_token varchar(400)
);

CREATE TABLE IF NOT EXISTS oauth.oauth_clients (
	client_id varchar(80) PRIMARY KEY,
	client_secret varchar(80),
	redirect_uri varchar(2000),
	grant_types varchar(80),
	scope varchar(4000),
	user_id varchar(80)
);

CREATE TABLE IF NOT EXISTS oauth.oauth_jti (
	issuer varchar(80) NOT NULL,
	subject varchar(80),
	audience varchar(80),
	expires timestamp NOT NULL,
	jti varchar(2000) NOT NULL
);

CREATE TABLE IF NOT EXISTS oauth.oauth_jwt (
	client_id varchar(80) NOT NULL,
	subject varchar(80),
	public_key varchar(2000) NOT NULL
);

CREATE TABLE IF NOT EXISTS oauth.oauth_public_keys (
	client_id varchar(80),
	public_key varchar(2000),
	private_key varchar(2000),
	encryption_algorithm varchar(100) DEFAULT 'RS256'
);

CREATE TABLE IF NOT EXISTS oauth.oauth_refresh_tokens (
	refresh_token varchar(40) PRIMARY KEY,
	client_id varchar(80),
	user_id varchar(80),
	expires timestamp NOT NULL DEFAULT current_timestamp,
	scope varchar(4000)
);

/*AUTOMATYCZNE USTWIANIE AKTUALNEGO TIMESTAMPA 
po modyfikacji pola w oauth_refresh_tokens*/

CREATE OR REPLACE FUNCTION oauth.update_modified_column()
RETURNS TRIGGER AS $$
BEGIN
	NEW.expires = now();
	RETURN NEW;
END;
$$ language 'plpgsql';

DROP TRIGGER IF EXISTS update_oauth_refresh_tokens 
ON oauth.oauth_refresh_tokens;

CREATE TRIGGER update_oauth_refresh_tokens 
BEFORE UPDATE ON oauth.oauth_refresh_tokens
FOR EACH ROW EXECUTE PROCEDURE oauth.update_modified_column();

CREATE TABLE IF NOT EXISTS oauth.oauth_scopes (
	scope varchar(80) PRIMARY KEY,
	is_default boolean
);

CREATE TABLE IF NOT EXISTS oauth.oauth_users (
	username varchar(80),
	password varchar(80),
	first_name varchar(80),
	last_name varchar(80),
	email varchar(2000),
	email_verified boolean,
	scope varchar(4000)
);

