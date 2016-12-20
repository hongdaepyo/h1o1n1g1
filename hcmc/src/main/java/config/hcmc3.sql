
/* Drop Tables */

DROP TABLE f_map CASCADE CONSTRAINTS;
DROP TABLE f_favor CASCADE CONSTRAINTS;
DROP TABLE f_rep CASCADE CONSTRAINTS;
DROP TABLE f_board_pic CASCADE CONSTRAINTS;
DROP TABLE f_board CASCADE CONSTRAINTS;
DROP TABLE f_member CASCADE CONSTRAINTS;
DROP TABLE f_festival_pic CASCADE CONSTRAINTS;
DROP TABLE f_festival CASCADE CONSTRAINTS;
DROP TABLE f_city CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_f_board_bnum;
DROP SEQUENCE SEQ_f_board_board_num;
DROP SEQUENCE SEQ_f_city_city_num;
DROP SEQUENCE SEQ_f_favor_f_favor_num;
DROP SEQUENCE SEQ_f_festival_festival_num;
DROP SEQUENCE SEQ_f_festival_fnum;
DROP SEQUENCE SEQ_f_map_mapnum;
DROP SEQUENCE SEQ_f_map_map_num;
DROP SEQUENCE SEQ_f_member_mem_num;
DROP SEQUENCE SEQ_f_member_mnum;
DROP SEQUENCE SEQ_f_rep_rep_num;
DROP SEQUENCE SEQ_f_rep__board_num;




/* Create Sequences */

CREATE SEQUENCE SEQ_f_board_bnum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_f_board_board_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_f_city_city_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_f_favor_f_favor_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_f_festival_festival_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_f_festival_fnum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_f_map_mapnum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_f_map_map_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_f_member_mem_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_f_member_mnum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_f_rep_rep_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_f_rep__board_num INCREMENT BY 1 START WITH 1;



/* Create Tables */

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
	f_favor_num number NOT NULL,
	mem_num number NOT NULL,
	festival_num number NOT NULL,
	favor_star number,
	PRIMARY KEY (f_favor_num)
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


CREATE TABLE f_city
(
	city_num number NOT NULL,
	city_name varchar2(10) NOT NULL,
	city_address varchar2(150) NOT NULL,
	city_lati number NOT NULL,
	city_long number NOT NULL,
	PRIMARY KEY (city_num)
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
	festival_content varchar2(3000),
	city_num number NOT NULL,
	PRIMARY KEY (festival_num)
);


CREATE TABLE f_board
(
	board_num number NOT NULL,
	board_head varchar2(20) NOT NULL,
	board_content varchar2(3000),
	board_date date,
	mem_num number NOT NULL,
	festival_num number NOT NULL,
	PRIMARY KEY (board_num)
);


CREATE TABLE f_rep
(
	rep_num number NOT NULL,
	rep_date date,
	rep_content varchar2(3000),
	board_num number NOT NULL,
	mem_num number NOT NULL,
	PRIMARY KEY (rep_num)
);


CREATE TABLE f_board_pic
(
	board_pic varchar2(3000),
	board_num number NOT NULL
);


CREATE TABLE f_festival_pic
(
	festival_pic varchar2(3000),
	festival_num number NOT NULL
);



/* Create Foreign Keys */

ALTER TABLE f_board
	ADD FOREIGN KEY (mem_num)
	REFERENCES f_member (mem_num)
;


ALTER TABLE f_favor
	ADD FOREIGN KEY (mem_num)
	REFERENCES f_member (mem_num)
;


ALTER TABLE f_rep
	ADD FOREIGN KEY (mem_num)
	REFERENCES f_member (mem_num)
;


ALTER TABLE f_map
	ADD FOREIGN KEY (city_num)
	REFERENCES f_city (city_num)
;


ALTER TABLE f_festival
	ADD FOREIGN KEY (city_num)
	REFERENCES f_city (city_num)
;


ALTER TABLE f_favor
	ADD FOREIGN KEY (festival_num)
	REFERENCES f_festival (festival_num)
;


ALTER TABLE f_board
	ADD FOREIGN KEY (festival_num)
	REFERENCES f_festival (festival_num)
;


ALTER TABLE f_festival_pic
	ADD FOREIGN KEY (festival_num)
	REFERENCES f_festival (festival_num)
;


ALTER TABLE f_rep
	ADD FOREIGN KEY (board_num)
	REFERENCES f_board (board_num)
;


ALTER TABLE f_board_pic
	ADD FOREIGN KEY (board_num)
	REFERENCES f_board (board_num)
;

delete from F_FAVOR
SELECT * FROM f_board
SELECT * FROM f_festival
SELECT * FROM f_member
SELECT * FROM f_rep
SELECT * FROM f_board_pic
select * from F_CITY
select * from F_FESTIVAL_PIC

select p.festival


alter system set processes=500 scope=spfile;
