CREATE TABLE item(
	idx		INT
);

DROP TABLE item;

DESC item;

SELECT *
FROM item;

SELECT @@GLOBAL.time_zone, @@SESSION.time_zone;

CREATE TABLE myMember(
	idx				INT AUTO_INCREMENT	PRIMARY KEY,
	id					VARCHAR(20) NOT NULL,
	PASSWORD 		VARCHAR(20) NOT NULL,
	email				VARCHAR(20) NOT NULL,
	NAME				VARCHAR(20) NOT NULL,
	phone				VARCHAR(11) NOT NULL
);

DESC logInTest;

DROP TABLE logInTest;

INSERT INTO myMember
VALUE(NULL, 'id1', 'pw1', 'email1', 'name1', 'phone1');

SELECT * FROM myMember;