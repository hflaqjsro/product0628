DROP TABLE PERSONAL;
DROP TABLE RESUME;
DROP TABLE COMPANY;
DROP TABLE RECRUIT;

CREATE TABLE PERSONAL (
  pName varchar2 (100),        -- 성명
  pID varchar2(15),            -- 아이디 
  pPW varchar2(20),            -- 비밀번호
  pMail varchar2(30),          -- 이메일
  pHP varchar2(15),            -- 연락처
  birth date,                  -- 생년월일
  gender number                -- 성별(1:남, 2:여)
);
INSERT INTO personal values('홍길동','hello123','7777','hello123@gmail.com','010-1234-5678','1990-08-17',1);
INSERT INTO personal values('마길동','himan123','8888','himan123@gmail.com','010-5678-1234','1991-09-17',2);
INSERT INTO personal values('김길동','flysky123','9999','flysky123@gmail.com','010-2345-6789','1992-10-17',2);
SELECT * FROM personal;

DROP TABLE gender;
CREATE TABLE gender(
	gno number,
	gen varchar2(10)
);
INSERT INTO gender values(1, 'male');
INSERT INTO gender values(2, 'female');
SELECT * FROM gender;

CREATE TABLE resume(
	rsNum varchar2(8),
	pID varchar2(15),
	rsTitle varchar2(300),
	profileImage varchar2(300),
	pMail varchar2(100),
	pHP varchar2(15),
	pTel varchar2(15),
	address1 varchar2(300),
	address2 varchar2(600),
	education NUMBER,
	career NUMBER,
	salary NUMBER,
	occupation NUMBER,
	isVisible char(1) 
);
DELETE FROM resume;
INSERT INTO resume
values('RS001', 'hello123','홍길동의 이력서1','URL',
'hello123@gmail.com','010-1234-5678','02-123-4567',
'서울시 종로구','숭인동 1번지',4,1,1,100,1);
INSERT INTO resume
values('RS002', 'himan123','마길동의 이력서1','URL',
'himan123@gmail.com','010-5678-1234','02-456-7890',
'서울시 종로구','이화동 1번지',4,2,1,200,1);
SELECT * FROM resume;

DROP TABLE company;
CREATE TABLE company(
	cName varchar2(100),
	cNum number,
	cID varchar2(15),
	cPW varchar2(15),
	cMail varchar2(30),
	cHP varchar2(15)
);
INSERT INTO company 
values('SK',1234567,'skinsa123','1234','skinsa123@gmail.com',
'010-0000-0000');
INSERT INTO company 
values('LG',7654321,'lginsa123','4321','lginsa123@gmail.com',
'010-0011-0011');
SELECT * FROM company;

CREATE TABLE recruit(
	rcNum varchar2(8),
	cNum NUMBER,
	rctitle varchar2(300),
	deadline DATE,
	progres NUMBER,
	address1 varchar2(300),
	address2 varchar2(600),
	career NUMBER,
	education NUMBER,
	empType NUMBER,
	occupation NUMBER,
	title NUMBER,
	RPOSITION NUMBER,
	dept varchar2(100),
	prefer varchar2(300)
);
INSERT INTO recruit 
values('SKR001',1234567, 'SK하이닉스 상반기 채용',
'2021-04-05',1, '서울시 강남구','신사동',1,4,1,500,
1,NULL,'생산','자격증');
INSERT INTO recruit 
values('LGR001',7654321, 'LG생건 상반기 채용',
'2021-04-07',1, '서울시 강남구','압구정동',1,4,1,500,
1,NULL,'제조','영어회화');
SELECT * FROM RECRUIT;

CREATE TABLE received(
	cName varchar2(100),
	rcNum varchar2(8),
	pName varchar2(100),
	rsNum varchar2(8)
);

INSERT INTO received
SELECT c.cName cName, r.rcNum rcNum, p.pName pName, rs.rsNum rsNum
FROM 
(SELECT cName, cNum FROM company) c,
(SELECT rcNum, cNum FROM RECRUIT WHERE rcNum='SKR001') r,
(SELECT pName, pID FROM personal) p,
(SELECT rsNum,pID FROM resume WHERE rsNum='RS001') rs
WHERE c.cNum=r.cNum AND p.pID=rs.pId;
SELECT * FROM received;

DELETE FROM RECEIVED;


