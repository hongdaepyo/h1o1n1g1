
/* Drop Tables */

DROP TABLE p_center_parts CASCADE CONSTRAINTS;
DROP TABLE p_car_parts CASCADE CONSTRAINTS;
DROP TABLE p_members CASCADE CONSTRAINTS;
DROP TABLE p_cars CASCADE CONSTRAINTS;
DROP TABLE p_centers CASCADE CONSTRAINTS;
DROP TABLE p_locations CASCADE CONSTRAINTS;
DROP TABLE p_parts CASCADE CONSTRAINTS;
DROP TABLE p_kinds CASCADE CONSTRAINTS;
DROP TABLE p_fuels CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE p_center_parts
(
	center_id varchar2(3) NOT NULL,
	part_id varchar2(40) NOT NULL
);


CREATE TABLE p_car_parts
(
	car_id varchar2(18) NOT NULL,
	kind_id varchar2(25) NOT NULL,
	part_id varchar2(40) NOT NULL
);


CREATE TABLE p_cars
(
	car_id varchar2(18) NOT NULL,
	eff number(3,1) NOT NULL,
	fuel_kind varchar2(9) NOT NULL,
	car_maker varchar2(20) NOT NULL,
	PRIMARY KEY (car_id)
);


CREATE TABLE p_locations
(
	location_id varchar2(5) NOT NULL,
	si varchar2(15) NOT NULL,
	gu varchar2(12) NOT NULL,
	dong varchar2(12) NOT NULL,
	gps_x number(3,0) NOT NULL,
	gps_y number(3,0) NOT NULL,
	PRIMARY KEY (location_id)
);


CREATE TABLE p_kinds
(
	kind_id varchar2(25) NOT NULL,
	PRIMARY KEY (kind_id)
);


CREATE TABLE p_parts
(
	part_id varchar2(40) NOT NULL,
	kind_id varchar2(25) NOT NULL,
	part_maker varchar2(10) NOT NULL,
	PRIMARY KEY (part_id)
);


CREATE TABLE p_centers
(
	center_id varchar2(3) NOT NULL,
	center_name varchar2(40) NOT NULL,
	center_phone varchar2(13) NOT NULL,
	location_id varchar2(5) NOT NULL,
	PRIMARY KEY (center_id)
);


CREATE TABLE p_members
(
	member_id varchar2(12) NOT NULL,
	member_name varchar2(12) NOT NULL,
	member_birthday date NOT NULL,
	member_phone varchar2(13),
	password varchar2(12) NOT NULL,
	gender char NOT NULL,
	buy_date date NOT NULL,
	distance number NOT NULL,
	car_id varchar2(18) NOT NULL,
	location_id varchar2(5) NOT NULL,
	kind_id varchar2(25) NOT NULL,
	PRIMARY KEY (member_id)
);


CREATE TABLE p_fuels
(
	fuel_kind varchar2(9) NOT NULL,
	price number(5,0) NOT NULL,
	PRIMARY KEY (fuel_kind)
);



/* Create Foreign Keys */

ALTER TABLE p_car_parts
	ADD FOREIGN KEY (car_id)
	REFERENCES p_cars (car_id)
;


ALTER TABLE p_members
	ADD FOREIGN KEY (car_id)
	REFERENCES p_cars (car_id)
;


ALTER TABLE p_members
	ADD FOREIGN KEY (location_id)
	REFERENCES p_locations (location_id)
;


ALTER TABLE p_centers
	ADD FOREIGN KEY (location_id)
	REFERENCES p_locations (location_id)
;


ALTER TABLE p_parts
	ADD FOREIGN KEY (kind_id)
	REFERENCES p_kinds (kind_id)
;


ALTER TABLE p_members
	ADD FOREIGN KEY (kind_id)
	REFERENCES p_kinds (kind_id)
;


ALTER TABLE p_car_parts
	ADD FOREIGN KEY (kind_id)
	REFERENCES p_kinds (kind_id)
;


ALTER TABLE p_car_parts
	ADD FOREIGN KEY (part_id)
	REFERENCES p_parts (part_id)
;


ALTER TABLE p_center_parts
	ADD FOREIGN KEY (part_id)
	REFERENCES p_parts (part_id)
;


ALTER TABLE p_center_parts
	ADD FOREIGN KEY (center_id)
	REFERENCES p_centers (center_id)
;


ALTER TABLE p_cars
	ADD FOREIGN KEY (fuel_kind)
	REFERENCES p_fuels (fuel_kind)
;



