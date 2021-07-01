/*
	회원 고유번호 MI_001...
	게시글 고유번호 1 2 3 4 5...
 	varchar2(100) title;
	varchar2(1000) text;
	varchar2(100) String tag; // 스트링?
	number check01; /0, 1
	number check02; /0, 1
	number check03; /0, 1
 */

DROP TABLE post;

CREATE TABLE post (
	memberId varchar2(30),
	postNum NUMBER,
	postTitle varchar2(200) NOT null,
	postText varchar2(2000) NOT null,
	postTag varchar2(200) NOT NULL
);


INSERT INTO post values('himan', 1, '조언 좀 주세요', '면접이 너무 어려워요...', '#면접준비  #취업준비');
INSERT INTO post values('himan', 2, '이력서 검토', '서류에서 탈락합니다...', '#서류준비  #취업준비');
INSERT INTO post values('higirl', 3, '면접 복장준비', '면접복장으로...', '#면접준비  #취업준비');

SELECT * FROM post;


-- 게시글 수정시

CREATE SEQUENCE post_sqe
	INCREMENT BY 1
	START WITH 1
	MINVALUE 1
	MAXVALUE 999999;

MERGE INTO post p
using dual
on (p.postNum = 1) -- 외부에서 form으로 데이터를 입력한 경우
when matched then
	update set 	p.postTitle = '조언 좀 주세요.',
				p.postText = '(수정) 다들 감사합니다.',
				p.postTag = '#면접준비  #취업준비'
when not matched then
	insert (postNum, postTitle, postText, postTag)
	values (1, '조언 좀 해주세요', '면접이 너무 어려워요', '#면접준비  #취업준비');

SELECT * FROM post;




-- 추가

/*
 1. 개인
CREATE TABLE PERSONAL (
  pName varchar2 (100) not null,        -- 성명
  pID varchar2(15) primary key,         -- 아이디 (pk) 
  pPW varchar2(20) not null,            -- 비밀번호
  pMail varchar2(30) not null,          -- 이메일
  pHP varchar2(15) not null,            -- 연락처
  birth date not null,                  -- 생년월일
  gender number check (gender between 1 and 2)          -- 성별(1:남, 2:여)
); 
  
 */

CREATE TABLE PERSONAL (
  pName varchar2 (100) not null,        -- 성명
  pID varchar2(15) primary key,         -- 아이디 (pk) 
  pPW varchar2(20) not null,            -- 비밀번호
  pMail varchar2(30) not null,          -- 이메일
  pHP varchar2(15) not null,            -- 연락처
  birth date not null,                  -- 생년월일
  gender number check (gender between 1 and 2)          -- 성별(1:남, 2:여)
); 

INSERT INTO personal VALUES ('김유나', 'yuna9310', '111111', 'yuna9310@naver.com', '010-0000-0001', 931005, 2);
INSERT INTO personal VALUES ('서민준', 'minjuni', '222222', 'minjuni@daum.net', '010-0000-0002', 900328, 1);
INSERT INTO personal VALUES ('이주원', 'julee93', '333333', 'julee93@gmail.com', '010-0000-0003', 930308, 1);
INSERT INTO personal VALUES ('유지민', 'jimin_2018', '444444', 'jimin_2018@naver.com', '010-0000-0004', 8901225, 2);
INSERT INTO personal VALUES ('정수아', 'sua_jeong', '555555', 'sua_jeong@naver.com', '010-0000-0004', 8901225, 2);


/*
 3-1. 기업회원 

CREATE TABLE COMPANY (
  cName varchar2 (100) not null,        -- 기업명
  cNum number primary key,            -- 사업자등록번호 (pk)
  cID varchar2(15) unique,            -- 인사담당 ID
  cPW varchar2(20) not null,            -- 인사담당 PW
  cMail varchar2(30) not null,          -- 인사담당 이메일
  cHP varchar2(15) not null            -- 인사담당 연락처
); 
  
 */

CREATE TABLE COMPANY (
  cName varchar2 (100) not null,        -- 기업명
  cNum number primary key,            -- 사업자등록번호 (pk)
  cID varchar2(15) unique,            -- 인사담당 ID
  cPW varchar2(20) not null,            -- 인사담당 PW
  cMail varchar2(30) not null,          -- 인사담당 이메일
  cHP varchar2(15) not null            -- 인사담당 연락처
); 


INSERT INTO company values('SK하이닉스', 1268103725, 'SK_TM_TL', '111111', 'SK_TM@gmail.com', '010-1111-1111');
INSERT INTO company values('셀트리온', 1338123603, 'Celltrion_HRM', '222222', 'Celltrion_HRM@gmail.com', '010-2222-2222');
INSERT INTO company values('삼성전자', 1248100998, 'SamSung_HR', '333333', 'SamSung_HR@gmail.com', '010-3333-3333');
INSERT INTO company values('KT', 1028142945, 'KT_HR', '444444', 'KT_HR@gmail.com', '010-4444-4444');
INSERT INTO company values('LG전자', 1078614075, 'LG_MEET', '555555', 'LG_MEET@gmail.com', '010-5555-5555');


