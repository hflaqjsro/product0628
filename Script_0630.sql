CREATE TABLE RESUME (
  rsNum varchar(8) CONSTRAINT resume_rsNum_nn_pk PRIMARY key, -- 이력서 고유번호 (pk)
  pNum varchar(8) CONSTRAINT resume_pNum_nn NOT NULL REFERENCES personal(pnum), -- 회원 고유번호 ◀ (일반회원DB 조인에 사용)
  rsTitle varchar(300) CONSTRAINT resume_rsTitle_nn NOT null, -- 이력서 제목
  profileImage varchar2(3000), -- 사진 URL
  email varchar2(100) CONSTRAINT resume_email_nn NOT null, -- 이메일 주소
  mobile varchar2(15) CONSTRAINT resume_mobile_nn NOT null,-- 휴대폰 번호
  tel varchar2(15),  -- 전화번호 
  address1 varchar2(300) CONSTRAINT resume_address1_nn NOT null, -- 회원의 주소 (Daum 주소 api의 roadAddress 받아옴)
  address2 varchar2(600), -- 회원의 상세주소
  education NUMBER REFERENCES education(eNum), -- 최종학력 (ex. 1:'초등학교 졸업', 2:'중학교 졸업' ..)
  career NUMBER REFERENCES career(cnum), -- 경력 (ex. 1:'신입', 2:'1~3년'..)
  salary NUMBER REFERENCES salary (snum), -- 연봉 (ex. 1:'회사 내규에 따름', 2:'~2000만원'..)
  occupation NUMBER REFERENCES occupation(onum), -- 희망직종 (ex. 100:'서비스업', 200:'금융,은행업'..)
  --area number(10) -- 희망지역 (법정동코드 ex. 1100000000:서울특별시, 1111000000:서울특별시 종로구, 1111010100:서울특별시 종로구 청운동)
  isVisible_resume number(1) -- 이력서 공개 여부 1:TRUE, 0:FALSE 
);  
INSERT INTO resume VALUES ('rs000001', 'pm000001', '이력서 제목1', 'D://images//profile.png', 'qwerty@gmail.com', '01011112222', NULL,
							'서울시 강남구 청담동', '어쩌구빌라 304호', 4, 1, 3, 300, 1);
INSERT INTO resume VALUES ('rs000002', 'pm000001', '이력서 제목2', 'D://images//profile2.png', 'qwerty@gmail.com', '01011112222', NULL,
							'서울시 강남구 청담동', '어쩌구빌라 304호', 4, 1, 2, 700, 1);						
DROP TABLE resume;
SELECT * FROM resume;
SELECT a.rsTitle 이력서제목, a.profileImage 프로필사진, p.pname 이름,
		TRUNC(MONTHS_BETWEEN(SYSDATE, p.birth)/12) 나이,
		a.email 이메일, a.mobile 휴대전화, a.address1 주소1, a.address2 주소2,
		b.estr 최종학력, c.cStr 경력, d.sStr 희망연봉, e.ostr 희망직종
FROM resume a 
	INNER JOIN education b ON a.education=b.enum 
	INNER JOIN CAREER c ON  a.career=c.cnum
	INNER JOIN salary d ON a.salary=d.snum
	INNER JOIN occupation e ON  a.occupation=e.onum
	inner JOIN personal p ON a.pNum=p.pNum 
WHERE a.rsNum='rs000001';

WHERE a.rsNum='rs000002';





CREATE TABLE PERSONAL (
  pNum varchar(8) PRIMARY key, --고유번호
  pName varchar2 (100),        -- 성명
  pID varchar2(15),            -- 아이디 
  pPW varchar2(20),            -- 비밀번호
  pMail varchar2(30),          -- 이메일
  pHP varchar2(15),            -- 연락처
  birth date,                  -- 생년월일
  gender number                -- 성별(1:남, 2:여)
);
DROP TABLE personal;
INSERT INTO personal VALUES ('pm000001', '홍길동', 'qwerty', 'tiger', 'qwerty@gmail.com', '01011112222', '1990-01-01', 2);
SELECT * FROM PERSONAL ;





CREATE TABLE RECRUIT (
  rcNum varchar(8) PRIMARY KEY , -- 채용공고 고유번호 (pk)
  cNum varchar(8)  CONSTRAINT recruit_cNum_nn NOT NULL REFERENCES company(cnum) , -- 회원 고유번호 ◀ (기업회원DB 조인에 사용)
  rcTitle varchar(300)  CONSTRAINT rcTitle_cNum_nn NOT NULL, -- 채용공고 제목
  deadline DATE  CONSTRAINT recruit_deadline_nn NOT NULL , -- 공고 마감일
  progress NUMBER  CONSTRAINT recruit_progress_nn NOT NULL, -- 상태 (ex. 1: 채용 진행중, 2:공고 마감)
  address1 varchar(300), -- 근무지 주소 (다음 주소 api의 roadAddress를 받아옴)
  address2 varchar(600), -- 근무지 상세주소
  --area varchar(300) -- 근무지역 (검색에서 사용됨. 다음 주소 api의 법정동코드bcode 받아옴.. ex.1111010100:서울특별시 종로구 청운동)
  career NUMBER REFERENCES career(cnum), -- 경력 (ex. 1:'신입', 2:'1~3년' ..)
  education NUMBER REFERENCES education(enum), -- 최종학력 (ex. 1:'초등학교 졸업', 2:'중학교 졸업' ..)
  empType NUMBER REFERENCES empType(etNum), -- 고용형태 (ex. 1: 정규직, 2: 계약직 ...) 
  occupation NUMBER REFERENCES occupation(onum), -- 산업 (ex. 100:'서비스업', 200:'금융,은행업'..)
  title NUMBER REFERENCES jobtitle(jtnum), --직급 (ex. 1:사원급, 2: 주임~대리급)
  position NUMBER REFERENCES jobposition(jpNum), --직책 (ex. 1:팀장/매니저/실장, 2:파트장/그룹장..)
  salary NUMBER REFERENCES salary(snum), -- 연봉 (ex. 1:'회사 내규에 따름', 2:'~2000만원'..)
  dept varchar2(100), --직무
  prefer varchar2(300) -- 우대조건
);
DROP TABLE RECRUIT;
SELECT * FROM RECRUIT r ;
INSERT INTO recruit VALUES ('rc000005', 'cm000001', '채용공고 제목','2021-08-31', 1, '서울시 강남구 역삼동', '뭐시기빌딩 13층',
							2, 4, 1, 300, 1, 0, 1, '사내 시스템 유지보수', '영어회화 가능자 우대');
INSERT INTO recruit VALUES ('rc000006', 'cm000001', '채용공고 제목22','2021-08-31', 1, '서울시 강남구 역삼동', '뭐시기빌딩 13층',
							3, 4, 1, 300, 2, 1, 8, '팀원 혼내주기', '귀여우면 우대');
INSERT INTO recruit VALUES ('rc000007', 'cm000002', '물티슈 포장 구인','2021-05-31', 2, '서울시 구로구 가산동', '뭐시기빌딩 2층',
							1, 3, 1, 500, 5, 0, 2, '포장', '손이 빠른 분');
SELECT a.rcTitle 채용공고제목, cm.cname 기업명,
		decode(a.progress, 1, '채용 진행중', 2, '공고 마감') 상태,
		trunc(a.deadline-SYSDATE) 마감일,
		c.cStr 경력, e.ostr 직종, b.estr 학력, 
		et.ETSTR 고용형태, j.JTSTR 직급, j2.JPSTR 직책, d.SSTR 연봉,
		a.dept 직무, a.prefer 우대조건,
		a.address1 주소1, a.address2 주소2,
		cm.cMail 담당자이메일, cm.cHP 담당자휴대전화
FROM recruit a 
	INNER JOIN education b ON a.education=b.enum 
	INNER JOIN CAREER c ON  a.career=c.cnum
	INNER JOIN salary d ON a.salary=d.snum
	INNER JOIN occupation e ON  a.occupation=e.onum
	INNER JOIN EMPTYPE et ON a.EMPTYPE = et.ETNUM
	INNER JOIN JOBTITLE j ON a.TITLE = j.JTNUM 
	INNER JOIN JOBPOSITION j2 ON a."POSITION"= j2.JPNUM
	inner JOIN company cm ON a.cNum=cm.cNum
WHERE a.cnum = 'cm000001';
						
						
CREATE TABLE COMPANY (
  cNum varchar(8) PRIMARY key,      -- 기업회원 고유번호
  cName varchar2(100) NOT null,        -- 기업명
  cRegNum number(10) UNIQUE NOT NULL , --사업자등록번호
  cID varchar2(50),                          -- 인사담당 ID
  cPW varchar2(50),                          -- 인사담당 PW
  cMail varchar2(100),                        -- 인사담당 이메일
  cHP varchar2(30)                          -- 인사담당 연락처
);						
DROP TABLE COMPANY ;
INSERT INTO company values('cm000001', '어쩌구 기업', 1234567899, 'soctt', 'tiger', 'djWjrn@gmail.com', '01012341234' )	;					
INSERT INTO company values('cm000002', '좋은나라', 1234567890, 'wetTissue', 'standard', 'good@gmail.com', '01043214321' )	;					








CREATE TABLE career (
  cNum NUMBER CONSTRAINT career_cnum_pk PRIMARY KEY,
  loCar NUMBER NOT NULL,
  hiCar NUMBER NOT NULL,
  cStr varchar2(100) NOT NULL
);
INSERT INTO career VALUES (1, 0, 0, '신입');
INSERT INTO career VALUES (2, 1, 3, '1~3년');
INSERT INTO career VALUES (3, 4, 6, '4~6년');
INSERT INTO career VALUES (4, 7, 9, '7~9년');
INSERT INTO career VALUES (5, 10, 15, '10~15년');
INSERT INTO career VALUES (6, 16, 20, '15~20년');
SELECT * FROM career;

CREATE TABLE education (
  eNum NUMBER CONSTRAINT education_enum_pk PRIMARY KEY,
  eStr varchar2(100) NOT NULL
);
INSERT INTO education VALUES (1, '초등학교 졸업');
INSERT INTO education VALUES (2, '중학교 졸업');
INSERT INTO education VALUES (3, '고등학교 졸업');
INSERT INTO education VALUES (4, '대학교 졸업 이상');
CREATE TABLE occupation (
	oNum NUMBER CONSTRAINT occupation_oNum_pk PRIMARY KEY,
	oStr varchar2(100) NOT null
);
INSERT INTO occupation VALUES (100, '서비스업');
INSERT INTO occupation VALUES (200, '금융업');
INSERT INTO occupation VALUES (300, 'IT/정보통신');
INSERT INTO occupation VALUES (400, '판매유통');
INSERT INTO occupation VALUES (500, '제조생산');
INSERT INTO occupation VALUES (600, '교육');
INSERT INTO occupation VALUES (700, '건설');
INSERT INTO occupation VALUES (800, '의료/제약');
INSERT INTO occupation VALUES (900, '미디어/예술');
CREATE TABLE salary (
	sNum NUMBER CONSTRAINT salary_sNum_pk PRIMARY KEY,
	losal NUMBER,
 	hisal NUMBER,
	sStr varchar2(100) NOT null
);
INSERT INTO salary VALUES (1, null, NULL, '회사 내규에 따름');
INSERT INTO salary VALUES (2, 0, 2000,  '~2천');
INSERT INTO salary VALUES (3, 2001, 3000, '2천~3천');
INSERT INTO salary VALUES (4, 3001, 4000, '3천~4천');
INSERT INTO salary VALUES (5, 4001, 5000, '4천~5천');
INSERT INTO salary VALUES (6, 5001, 6000, '5천~6천');
INSERT INTO salary VALUES (7, 6001, 99999, '6천이상');
INSERT INTO salary VALUES (8, NULL, NULL, '면접 후 결정');
CREATE TABLE empType (
	etNum NUMBER CONSTRAINT empType_etNum_pk PRIMARY KEY,
	etStr varchar2(100) NOT null
);
INSERT INTO empType VALUES (1, '정규직');
INSERT INTO empType VALUES (2, '계약직');
INSERT INTO empType VALUES (3, '인턴');
INSERT INTO empType VALUES (4, '프리랜서');
INSERT INTO empType VALUES (5, '아르바이트');
CREATE TABLE jobTitle (
	jtNum NUMBER CONSTRAINT jobtitle_jtNum_pk PRIMARY KEY,
	jtStr varchar2(100) NOT null
);
INSERT INTO jobtitle VALUES (1, '사원급');
INSERT INTO jobtitle VALUES (2, '대리급');
INSERT INTO jobtitle VALUES (3, '과장급');
INSERT INTO jobtitle VALUES (4, '부장급');
INSERT INTO jobtitle VALUES (5, '임원');
CREATE TABLE jobPosition (
	jpNum NUMBER CONSTRAINT jobPosition_jpNum_pk PRIMARY KEY,
	jpStr varchar2(100) NOT null
);
INSERT INTO jobPosition VALUES (0, '해당없음');
INSERT INTO jobPosition VALUES (1, '팀장');
INSERT INTO jobPosition VALUES (2, '파트장');
INSERT INTO jobPosition VALUES (3, '센터장');
INSERT INTO jobPosition VALUES (4, '지점장');