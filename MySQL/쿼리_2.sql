CREATE TABLE item(
	idx		INT,
	NAME		VARCHAR(20)
);

DESC item;

INSERT INTO item(idx, NAME)
VALUES(1, 'a');

INSERT INTO item(idx, NAME)
VALUES(2, 'b');

INSERT INTO item(idx, NAME)
VALUES(3, 'c');

INSERT INTO item(idx, NAME)
VALUES(4, 'd');

INSERT INTO item(idx, NAME)
VALUES(5, 'e');

SELECT * FROM item LIMIT 1 OFFSET 3;

SELECT (idx * 10) FROM item;

DELETE FROM item;

