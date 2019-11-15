CREATE TABLE cookie_sales (
	ID int(11) NOT NULL auto_increment,
	first_name varchar(20) NOT NULL,
	sales decimal(4,2) NOT NULL,
	sale_date date NOT NULL,
	PRIMARY KEY  (ID)
);

INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('1','Lindsey',32.02,'2007-03-12');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('2','Nicole',26.53,'2007-03-12');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('3','Britney',11.25,'2007-03-12');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('4','Ashley',18.96,'2007-03-12');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('5','Lindsey',9.16,'2007-03-11');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('6','Nicole',1.52,'2007-03-11');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('7','Britney',43.21,'2007-03-11');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('8','Ashley',8.05,'2007-03-11');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('9','Lindsey',17.62,'2007-03-10');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('10','Nicole',24.19,'2007-03-10');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('11','Britney',3.40,'2007-03-10');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('12','Ashley',15.21,'2007-03-10');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('13','Lindsey',0.00,'2007-03-09');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('14','Nicole',31.99,'2007-03-09');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('15','Britney',2.58,'2007-03-09');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('16','Ashley',0.00,'2007-03-09');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('17','Lindsey',2.34,'2007-03-08');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('18','Nicole',13.44,'2007-03-08');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('19','Britney',8.78,'2007-03-08');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('20','Ashley',26.82,'2007-03-08');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('21','Lindsey',3.71,'2007-03-07');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('22','Nicole',0.56,'2007-03-07');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('23','Britney',34.19,'2007-03-07');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('24','Ashley',7.77,'2007-03-07');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('25','Lindsey',16.23,'2007-03-06');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('26','Nicole',0.00,'2007-03-06');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('27','Britney',4.50,'2007-03-06');
INSERT INTO cookie_sales (ID,first_name,sales,sale_date) VALUES ('28','Ashley',19.22,'2007-03-06');

SELECT * 
FROM cookie_sales
WHERE sales = (	SELECT MAX(sales)
						FROM cookie_sales	);

-- [문제_1]
-- 판매 금액 10 ~ 20위 // LIMIT 사용
SELECT *
FROM cookie_sales
ORDER BY sales DESC
LIMIT 10
OFFSET 10;


-- [문제_2]
-- 판매 금액, 수익 출력 (수익은 판매금액의 10%)
SELECT sales AS '판매금액', sales / 10 AS 수익
FROM cookie_sales;


-- [문제_3]
-- 판매 금액 소수점 반올림 / 날짜별 정렬
SELECT ROUND(sales), sales
FROM cookie_sales
ORDER BY sale_date ASC;


-- [문제_4]
-- 판매 금액이 10 이상인 것 / 이름순 출력
SELECT *
FROM cookie_sales
WHERE sales >= 10
ORDER BY first_name ASC;


-- [문제_5]
-- 년도를 제외하고 출력.


