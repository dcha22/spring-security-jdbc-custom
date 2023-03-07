INSERT INTO users(username, password, enabled)
	values('dilip',
			'pass',
			true);

INSERT INTO users(username, password, enabled)
	values('salty',
			'pass',
			true);
			
INSERT INTO authorities(username, authority)
	values('dilip', 'ROLE_USER');

INSERT INTO authorities(username, authority)
	values('salty', 'ROLE_ADMIN');

