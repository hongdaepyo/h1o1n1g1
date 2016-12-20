
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
DROP SEQUENCE SEQ_f_favor_favor_num;
DROP SEQUENCE SEQ_f_festival_festival_num;
DROP SEQUENCE SEQ_f_map_map_num;
DROP SEQUENCE SEQ_f_member_mem_num;
DROP SEQUENCE SEQ_f_rep_rep_num;




/* Create Sequences */

CREATE SEQUENCE SEQ_f_board_board_num INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_f_city_city_num INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_f_favor_favor_num INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_f_festival_festival_num INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_f_map_map_num INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_f_member_mem_num INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_f_rep_rep_num INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;



/* Create Tables */

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
	favor_num number NOT NULL,
	mem_num number NOT NULL,
	festival_num number NOT NULL,
	favor_star number,
	PRIMARY KEY (favor_num)
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
	rep_content varchar2(3000),
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

select * from f_festival
select * from f_favor

select * from f_favor where mem_num = 1

select * from F_MEMBER where mem_num = 1
select * from f_festival_pic
select * from F_CITY
select f.*, c.city_name, c.city_address, c.city_lati, c.city_long, fp.festival_pic
		from f_festival f, f_city c, f_festival_pic fp
		where festival_start >= TO_DATE(201611,'YYYYMM') AND festival_start< TO_DATE(201612,'YYYYMM')
		and f.city_num=c.city_num and f.festival_num=fp.festival_num(+)
		order by festival_num

select f.*, fp.*
from f_festival f, f_festival_pic fp
where f.festival_num=fp.festival_num(+) and festival_start >= TO_DATE(201611,'YYYYMM') AND festival_start< TO_DATE(201612,'YYYYMM')

delete from f_festival_pic where festival_pic = 'e5afa437-39d5-4129-8ce5-37c880ae3754_Hydrangeas.jpg'

 select p.festival_pic,f.*,c.*
    from F_CITY c, F_FESTIVAL f, F_FESTIVAL_PIC p
    where c.city_num = f.city_num 
     and f.festival_num = p.festival_num(+) and c.city_name like '서울' || '%' 
     and f.festival_theme='연인' and f.festival_start>=TO_DATE(20161101,'YYYYMMDD') 
     and f.festival_start<TO_DATE(20161230,'YYYYMMDD')
