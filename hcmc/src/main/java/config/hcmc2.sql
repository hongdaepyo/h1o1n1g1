
/* Drop Tables */

DROP TABLE f_board_pic CASCADE CONSTRAINTS;
DROP TABLE f_rep CASCADE CONSTRAINTS;
DROP TABLE f_board CASCADE CONSTRAINTS;
DROP TABLE f_favor CASCADE CONSTRAINTS;
DROP TABLE f_festival_pic CASCADE CONSTRAINTS;
DROP TABLE f_festival CASCADE CONSTRAINTS;
DROP TABLE f_map CASCADE CONSTRAINTS;
DROP TABLE f_city CASCADE CONSTRAINTS;
DROP TABLE f_member CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_f_board_board_num;
DROP SEQUENCE SEQ_f_city_city_num;
DROP SEQUENCE SEQ_f_favor_f_favor_num;
DROP SEQUENCE SEQ_f_festival_festival_num;
DROP SEQUENCE SEQ_f_map_map_num;
DROP SEQUENCE SEQ_f_member_mem_num;
DROP SEQUENCE SEQ_f_rep_rep_num;




/* Create Sequences */

CREATE SEQUENCE SEQ_f_board_board_num INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_f_city_city_num INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_f_favor_f_favor_num INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_f_festival_festival_num INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_f_map_map_num INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_f_member_mem_num INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_f_rep_rep_num INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;



/* Create Tables */

CREATE TABLE f_board
(
	board_num number NOT NULL,
	board_head varchar2(20) NOT NULL,
	board_content varchar2(1000),
	board_date date,
	mem_num number NOT NULL,
	festival_num number NOT NULL,
	PRIMARY KEY (board_num)
);


CREATE TABLE f_board_pic
(
	board_pic varchar2(3000),
	board_num number NOT NULL
);


CREATE TABLE f_city
(
	city_num number NOT NULL,
	city_name varchar2(10) NOT NULL,
	city_address varchar2(150) NOT NULL,
	city_lati number NOT NULL,
	city_long number NOT NULL,
	PRIMARY KEY (city_num)
);


CREATE TABLE f_favor
(
	f_favor_num number NOT NULL,
	mem_num number NOT NULL,
	festival_num number NOT NULL,
	favor_star number,
	PRIMARY KEY (f_favor_num)
);


CREATE TABLE f_festival
(
	festival_num number NOT NULL,
	festival_name varchar2(100) NOT NULL,
	festival_start date NOT NULL,
	festival_end date,
	festival_hpage varchar2(150),
	festival_theme varchar2(20) NOT NULL,
	festival_time varchar2(50),
	festival_count number,
	festival_content varchar2(1000),
	city_num number NOT NULL,
	PRIMARY KEY (festival_num)
);


CREATE TABLE f_festival_pic
(
	festival_pic varchar2(3000),
	festival_num number NOT NULL
);


CREATE TABLE f_map
(
	map_num number NOT NULL,
	map_phone number,
	map_name varchar2(50),
	map_category varchar2(10),
	city_num number NOT NULL,
	PRIMARY KEY (map_num)
);


CREATE TABLE f_member
(
	mem_num number NOT NULL,
	mem_id varchar2(50) NOT NULL UNIQUE,
	mem_pass varchar2(50) NOT NULL,
	mem_nickname varchar2(50) UNIQUE,
	mem_admin char NOT NULL,
	PRIMARY KEY (mem_num)
);


CREATE TABLE f_rep
(
	rep_num number NOT NULL,
	rep_date date,
	rep_content varchar2(1000),
	board_num number NOT NULL,
	mem_num number NOT NULL,
	PRIMARY KEY (rep_num)
);



/* Create Foreign Keys */

ALTER TABLE f_board_pic
	ADD FOREIGN KEY (board_num)
	REFERENCES f_board (board_num) ON DELETE CASCADE
;


ALTER TABLE f_rep
	ADD FOREIGN KEY (board_num)
	REFERENCES f_board (board_num) ON DELETE CASCADE
;


ALTER TABLE f_festival
	ADD FOREIGN KEY (city_num)
	REFERENCES f_city (city_num) ON DELETE CASCADE
;


ALTER TABLE f_map
	ADD FOREIGN KEY (city_num)
	REFERENCES f_city (city_num) ON DELETE CASCADE
;


ALTER TABLE f_board
	ADD FOREIGN KEY (festival_num)
	REFERENCES f_festival (festival_num) ON DELETE CASCADE
;


ALTER TABLE f_favor
	ADD FOREIGN KEY (festival_num)
	REFERENCES f_festival (festival_num) ON DELETE CASCADE
;


ALTER TABLE f_festival_pic
	ADD FOREIGN KEY (festival_num)
	REFERENCES f_festival (festival_num) ON DELETE CASCADE
;


ALTER TABLE f_board
	ADD FOREIGN KEY (mem_num)
	REFERENCES f_member (mem_num) ON DELETE CASCADE
;


ALTER TABLE f_favor
	ADD FOREIGN KEY (mem_num)
	REFERENCES f_member (mem_num) ON DELETE CASCADE
;


ALTER TABLE f_rep
	ADD FOREIGN KEY (mem_num)
	REFERENCES f_member (mem_num) ON DELETE CASCADE
;


insert into F_CITY values(SEQ_f_city_city_num.nextval,'제주도','제주특별자치도 서귀포시 표선면 녹산로 464-65',33.399067,126.706934);
insert into F_CITY values(SEQ_f_city_city_num.nextval,'강원도','강원 정성군 남면 문곡3리(민둥산 일원)',37.265587,128.722715);

insert into F_FESTIVAL values(SEQ_f_festival_festival_num.nextval,'제주 유채꽃 축제',sysdate,   sysdate,'http://www.jejuflowerfestival.com',   '가족',   '제한없음',0,'유채꽃은',1);
insert into F_FESTIVAL values(SEQ_f_festival_festival_num.nextval,'민둥산억새꽃 축제','2016/09/24','2016/11/13','http://ariaritour.com','가족','제한없음',0,'민둥산 억새꽃 축제는 산',2);

insert into F_CITY values(SEQ_f_city_city_num.nextval,'제주도','제주특별자치도 서귀포시 표선면 녹산로 464-65',33.399067,126.706934);
insert into F_CITY values(SEQ_f_city_city_num.nextval,'강원도','강원 정성군 남면 문곡3리(민둥산 일원)',37.265587,128.722715);
insert into F_CITY values(SEQ_f_city_city_num.nextval,'서울','강원 정성군 남면 문곡3리(민둥산 일원)',37.265587,128.722715);
insert into F_CITY values(SEQ_f_city_city_num.nextval,'경기도','강원 정성군 남면 문곡3리(민둥산 일원)',37.265587,128.722715);
insert into F_CITY values(SEQ_f_city_city_num.nextval,'충청도','강원 정성군 남면 문곡3리(민둥산 일원)',37.265587,128.722715);
insert into F_CITY values(SEQ_f_city_city_num.nextval,'전라도','강원 정성군 남면 문곡3리(민둥산 일원)',37.265587,128.722715);


insert into F_FESTIVAL values(SEQ_f_festival_festival_num.nextval,'제주 유채꽃 축제',sysdate,   sysdate,'http://www.jejuflowerfestival.com',   '가족',   '제한없음',0,'유채꽃은',1);
insert into F_FESTIVAL values(SEQ_f_festival_festival_num.nextval,'민둥산억새꽃 축제','2016/09/24','2016/11/13','http://ariaritour.com','가족','제한없음',0,'민둥산 억새꽃 축제는 산',2);
insert into F_FESTIVAL values(SEQ_f_festival_festival_num.nextval,'test','2016/10/24','2016/12/13','http://ariaritour.com','가족','제한없음',0,'민둥산 억새꽃 축제는 산',3);
insert into F_FESTIVAL values(SEQ_f_festival_festival_num.nextval,'test1','2016/11/24','2016/01/13','http://ariaritour.com','가족','제한없음',0,'민둥산 억새꽃 축제는 산',4);
insert into F_FESTIVAL values(SEQ_f_festival_festival_num.nextval,'test2','2016/12/24','2016/03/13','http://ariaritour.com','가족','제한없음',0,'민둥산 억새꽃 축제는 산',5);
insert into F_FESTIVAL values(SEQ_f_festival_festival_num.nextval,'test3','2016/05/24','2016/10/13','http://ariaritour.com','가족','제한없음',0,'민둥산 억새꽃 축제는 산',6);



INSERT INTO f_member
		VALUES(SEQ_f_member_mem_num.nextval,'jun@admin.com','a1234','운영자','v');
INSERT INTO f_member
		VALUES(SEQ_f_member_mem_num.nextval,'one@admin.com','a1234','일반회원1','n');
INSERT INTO f_city
		VALUES(SEQ_f_city_city_num.nextval,'서울','종로구 종각역','1','1');
INSERT INTO f_map
		VALUES(SEQ_f_map_map_num.nextval,'03112345678','테스트치킨','맛집',1);
INSERT INTO f_festival
		VALUES(SEQ_f_festival_festival_num.nextval,'test_festival','2016/11/11','2016/11/12','HTTP://www.test.com','싱글','종일',0,'test입니다.',1);
INSERT INTO f_festival
		VALUES(SEQ_f_festival_festival_num.nextval,'test_festival222','2016/11/11','2016/11/12','HTTP://www.test.com','싱글','종일',0,'test입니다.',1);

INSERT INTO f_board
		VALUES(SEQ_f_board_board_num.nextval,'일반','test3','2016/11/14',1,1);
INSERT INTO f_board
		VALUES(SEQ_f_board_board_num.nextval,'문의','test4','2016/11/14',2,1);
		
select replace(festival_content, chr(34), '\' || chr(34)) from f_festival where festival_num=1;
SELECT * FROM f_board
SELECT * FROM f_festival
SELECT * FROM f_member
SELECT * FROM f_rep
SELECT * FROM f_board_pic
select * from F_CITY
select * from F_FESTIVAL_PIC

update F_MEMBER set mem_admin=2 where mem_num=4;
update f_festival set festival_content='&quot;test축제입니다' where festival_num=1

UPDATE f_board SET
		board_head='문의',board_content='test',board_date=sysdate,festival_num='2'
		WHERE board_num=60
		
select f.*, c.city_name, c.city_address, c.city_lati, c.city_long
from f_festival f, f_city c
where f.city_num=c.city_num

select f.*, c.city_name, c.city_address, c.city_lati, c.city_long
from f_festival f, f_city c
where festival_start >= TO_DATE('201611','YYYYMM') AND  festival_start <  TO_DATE('201612','YYYYMM')
		and f.city_num=c.city_num;
