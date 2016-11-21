
/* Drop Tables */

DROP TABLE f_rep CASCADE CONSTRAINTS;
DROP TABLE f_map CASCADE CONSTRAINTS;
DROP TABLE f_favor CASCADE CONSTRAINTS;
DROP TABLE f_board CASCADE CONSTRAINTS;
DROP TABLE f_festival CASCADE CONSTRAINTS;
DROP TABLE f_city CASCADE CONSTRAINTS;
DROP TABLE f_member CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_f_festival_fnum;
DROP SEQUENCE SEQ_f_map_mapnum;
DROP SEQUENCE SEQ_f_board_bnum;
DROP SEQUENCE SEQ_f_member_mnum;
DROP SEQUENCE SEQ_f_map_map_num;
DROP SEQUENCE SEQ_f_member_mem_num;
DROP SEQUENCE SEQ_f_rep_rep_num;
DROP SEQUENCE SEQ_f_rep__board_num;
DROP SEQUENCE SEQ_f_festival_festival_num;
DROP SEQUENCE SEQ_f_board_board_num;
DROP SEQUENCE SEQ_f_city_city_num;




/* Create Sequences */

CREATE SEQUENCE SEQ_f_festival_fnum INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_f_map_mapnum INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_f_board_bnum INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_f_member_mnum INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_f_map_map_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_f_member_mem_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_f_rep_rep_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_f_rep__board_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_f_festival_festival_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_f_board_board_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_f_city_city_num INCREMENT BY 1 START WITH 1 nocache nocycle;



/* Create Tables */

CREATE TABLE f_rep
(
	rep_num number NOT NULL,
	rep_date date,
	rep_content varchar2(1000),
	board_num number NOT NULL,
	mem_num number NOT NULL,
	PRIMARY KEY (rep_num)
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


CREATE TABLE f_favor
(
	mem_num number NOT NULL,
	festival_num number NOT NULL,
	favor_star number
);


CREATE TABLE f_board
(
	board_num number NOT NULL,
	board_head varchar2(20) NOT NULL,
	board_upload varchar2(300),
	board_content varchar2(1000),
	board_date date,
	mem_num number NOT NULL,
	festival_num number,
	PRIMARY KEY (board_num)
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


CREATE TABLE f_member
(
	mem_num number NOT NULL,
	mem_id varchar2(50) NOT NULL UNIQUE,
	mem_pass varchar2(50) NOT NULL,
	mem_nickname varchar2(50) UNIQUE,
	mem_admin char NOT NULL,
	PRIMARY KEY (mem_num)
);


CREATE TABLE f_festival
(
	festival_num number NOT NULL,
	festival_name varchar2(100) NOT NULL,
	festival_start date NOT NULL,
	festival_end date,
	festival_pic varchar2(300),
	festival_hpage varchar2(150),
	festival_theme varchar2(20) NOT NULL,
	festival_time varchar2(50),
	festival_count number,
	festival_content varchar2(1000),
	city_num number NOT NULL,
	PRIMARY KEY (festival_num)
);



/* Create Foreign Keys */

ALTER TABLE f_rep
	ADD FOREIGN KEY (board_num)
	REFERENCES f_board (board_num)
;


ALTER TABLE f_festival
	ADD FOREIGN KEY (city_num)
	REFERENCES f_city (city_num)
;


ALTER TABLE f_map
	ADD FOREIGN KEY (city_num)
	REFERENCES f_city (city_num)
;


ALTER TABLE f_board
	ADD FOREIGN KEY (mem_num)
	REFERENCES f_member (mem_num)
;


ALTER TABLE f_rep
	ADD FOREIGN KEY (mem_num)
	REFERENCES f_member (mem_num)
;


ALTER TABLE f_favor
	ADD FOREIGN KEY (mem_num)
	REFERENCES f_member (mem_num)
;


ALTER TABLE f_favor
	ADD FOREIGN KEY (festival_num)
	REFERENCES f_festival (festival_num)
;


ALTER TABLE f_board
	ADD FOREIGN KEY (festival_num)
	REFERENCES f_festival (festival_num)
;

select * from F_MEMBER where mem_num=1
select * from F_MEMBER order by mem_num

insert into F_MEMBER
values (SEQ_f_member_mem_num.nextval,'test3@naver.com','a1234',null,1);

insert into F_MEMBER
values (SEQ_f_member_mem_num.nextval,'test4@naver.com','a12345','테스트용',1);


insert into F_CITY values(SEQ_f_city_city_num.nextval,'제주도','제주특별자치도 서귀포시 표선면 녹산로 464-65',33.399067,126.706934);
insert into F_CITY values(SEQ_f_city_city_num.nextval,'강원도','강원 정성군 남면 문곡3리(민둥산 일원)',37.265587,128.722715);

insert into F_FESTIVAL values(SEQ_f_festival_festival_num.nextval,'제주 유채꽃 축제',sysdate,   sysdate,'','http://www.jejuflowerfestival.com',   '가족',   '제한없음',0,'유채꽃은',1);
insert into F_FESTIVAL values(SEQ_f_festival_festival_num.nextval,'민둥산억새꽃 축제','2016/09/24','2016/11/13','','http://ariaritour.com','가족','제한없음',0,'민둥산 억새꽃 축제는 산',2);

insert into f_favor values(1,2,10);
insert into f_favor values(2,2,8);

select * from f_city;
select * from f_festival;
select * from F_FAVOR;

rownum 을 쓰려면 order by 가 설정되어 있어야함
delete from F_FAVOR

select rownum from F_FAVOR

select f.*, a.*
from f_festival f,
	(select avg(favor_star) as "star" from f_favor where festival_num=2) a
where festival_num=2

select f.*, a.*
from f_festival f, f_favor fa,
	(select avg(favor_star) as "average" from f_favor where festival_num=2) a
where f.festival_num=fa.festival_num


select c.city_name, f.festival_name
from f_city c, f_festival f
where c.city_num = f.city_num;

SELECT *
  FROM F_FESTIVAL
 WHERE festival_start >= TO_DATE('201611','YYYYMM') AND  festival_start <  TO_DATE('201611','YYYYMM');
 
 select TO_DATE('201609','YYYYMM')+1
 from dual
 
 