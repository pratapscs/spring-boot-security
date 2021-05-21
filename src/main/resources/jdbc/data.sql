INSERT INTO users (username, password, enabled) values ('user', 'vinay', true);
INSERT INTO users (username, password, enabled) values ('admin', 'pratap', true);
INSERT INTO authorities (username, authority) values ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('admin', 'ROLE_ADMIN');