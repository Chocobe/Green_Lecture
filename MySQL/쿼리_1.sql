CREATE TABLE my_contacts (
  last_name varchar(30) ,
  first_name varchar(20) ,
  email varchar(50) ,
  gender char(1),
  birthday date ,
  profession varchar(50),
  location varchar(50),
  status varchar(20),
  interests varchar(100),
  seeking varchar(100)
);

SELECT * FROM my_contacts;

INSERT INTO my_contacts (last_name,first_name,email,gender,birthday,profession,location,status,interests,seeking) VALUES ('Anderson','Jillian','jill_anderson@ \nbreakneckpizza.com','F','1980-09-05','Technical Writer','Palo Alto, CA','single','kayaking, reptiles','relationship, friends');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday,profession,location,status,interests,seeking) VALUES ('Kenton','Leo','lkenton@starbuzzcoffee.com','M','1974-01-10','Manager','San Francisco, CA','divorced','women','women to date');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday,profession,location,status,interests,seeking) VALUES ('McGavin','Darrin',' captainlove@headfirsttheater.com','M','1966-01-23','Cruise Ship Captain','San Diego, CA','single','sailing, fishing, yachting','women for casual relationships');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday,profession,location,status,interests,seeking) VALUES ('Franklin','Joe','joe_franklin@leapinlimos.com','M','1977-04-28','Software Sales','Dallas, TX','married','fishing, drinking','new job');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday,profession,location,status,interests,seeking) VALUES ('Hamilton','Jamie','dontbother@starbuzzcoffee.com','F','1964-09-10','System Administrator','Princeton, NJ','married','RPG','nothing');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday,profession,location,status,interests,seeking) VALUES ('Chevrolet','Maurice','bookman4u@objectville.net','M','1962-07-01','Bookshop Owner','Mountain View, CA','married','collecting books, scuba diving','friends');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday,profession,location,status,interests,seeking) VALUES ('Kroger','Renee','poorrenee@mightygumball.net','F','1976-12-03','Unemployed','San Francisco, CA','divorced','cooking','employment');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday,profession,location,status,interests,seeking) VALUES ('Mendoza','Angelina','angelina@starbuzzcoffee.com','F','1979-08-19','UNIX Sysadmin','San Francisco, CA','married','acting, dancing','new job');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday,profession,location,status,interests,seeking) VALUES ('Murphy','Donald','padraic@tikibeanlounge.com','M','1967-01-23','Computer Programmer','New York City, NY','committed relationsh','RPG, anime','friends');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday,profession,location,status,interests,seeking) VALUES ('Spatner','John','jpoet@objectville.net','M','1963-04-18','Salesman','Woodstock, NY','married','poetry, screenwriting','nothing');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday, profession,location) VALUES ('Toth','Anne','Anne_Toth@leapinlimos.com','F','1969-11-18', 'Artist','San Fran, CA');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday, profession,location) VALUES ('Manson','Anne','am86@objectville.net','F','1977-08-09', 'Baker','Seattle, WA');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday, profession,location) VALUES ('Hardy','Anne','anneh@b0tt0msup.com','F','1963-04-18', 'Teacher','San Fran, CA');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday, profession,location) VALUES ('Parker','Anne','annep@starbuzzcoffee.com','F','1983-01-10', 'Student','San Fran, CA');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday, profession,location) VALUES ('Blunt','Anne','anneblunt@breakneckpizza.com','F','1959-10-09', 'Web Designer','San Fran, CA');
INSERT INTO my_contacts (last_name,first_name,email,gender,birthday, profession,location) VALUES ('Jacobs','Anne','anne99@objectville.net','F','1968-02-05', 'Computer Programmer','San Jose, CA');

-- [문제_1]
-- 여자 / 앤 / 샌프란 시스코
SELECT * FROM my_contacts WHERE gender='f' AND first_name='Anne' AND location like 'San F%';

-- [문제_2]
-- 60년생 이상 70년생 미만
SELECT * FROM my_contacts WHERE birthday BETWEEN '1960-00-00' AND '1970-00-00';

-- [문제_3]
-- 나이별로 오름차순 / 10명
SELECT * FROM my_contacts ORDER BY birthday ASC;

-- [문제_4]
-- 캘리포니아에 살고, 결혼한 사람
SELECT * FROM my_contacts WHERE location LIKE '%CA%' AND STATUS IN('married', 'divorced');

-- [문제_5]
-- 새로운 직업을 구하는 여자
SELECT * FROM my_contacts WHERE seeking LIKE '%new job%';

-- [문제_6]
-- 이혼한 남자
SELECT * FROM my_contacts WHERE STATUS = 'divorced' AND gender = 'M';

-- [문제_7]
-- 남자 나이별 내림 차순
SELECT * FROM my_contacts WHERE gender = 'M' ORDER BY birthday ASC;


-- [문제_8]
-- 여자 이름별로 오름차순
SELECT * FROM my_contacts WHERE gender = 'F' ORDER BY first_name ASC, last_name ASC;

-- [문제_9]
-- 취미가 RPG가 아니고 여자가 아닌 사람
SELECT * FROM my_contacts WHERE NOT interests LIKE '%RPG%' AND gender <> 'F';

-- [문제_10]
-- 뉴욕에 사는 모든 사람 나이순 정렬
SELECT * FROM my_contacts WHERE location LIKE '%New York%' OR location LIKE '%NY%';

-- [문제_11]
-- 이메일이 .com이 아닌 사람
SELECT * FROM my_contacts WHERE NOT email LIKE '%.com%';

-- [문제_12]
-- 결혼 했으며 캘리포니아 친구를 찾는 사람
SELECT * FROM my_contacts WHERE STATUS IN('married', 'devorced') AND location LIKE '%CA%' AND seeking = 'friends';

-- [문제_13]
-- 생일이 4월인 사람을 날짜별 내림차순 / 성별 오름차순 정렬
SELECT * FROM my_contacts WHERE birthday LIKE '%-04-%' ORDER BY birthday DESC, gender ASC;

-- [문제_14]
-- 취미가 ing로 끝나며 결혼한 사람
SELECT * FROM my_contacts WHERE STATUS IN('married', 'devorced') AND interests LIKE '%ing%';

-- [문제_15]
-- 이름에 m이 들어가고 / 여자 / CA에 사는 사람
SELECT * FROM my_contacts WHERE (first_name LIKE '%m%' OR last_name LIKE '%m%') AND location LIKE '%CA%' AND gender = 'F';



SELECT * FROM my_contacts;

