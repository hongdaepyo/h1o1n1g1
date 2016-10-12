---------------------2016-08-02---------------------------------------
오라클에서 제공되는 명령어
1 DQL(Data Query Language) : 데이터를 검색해서 추출할때 사용된다.(select)
2 DML(Data Manipulation Language) : 데이터는 추가, 수정, 삭제, 병합해주는 명령어들이다.(insert, update, delete, merge)
3 DDL(Data Definition Language ) : 테이블의 구조를 정의, 변경해주는 명령어들이다.(create, drop, alter, truncate)
4 DCL(Data Control Language) : 사용자의 권한을 부여,제거해주는 명령어들이다.(grant ,revoke)
5 TCL(Transaction Control Language) : 트랜잭션 설정,취소을 처리해주는 명령어들이다(commit, rollback, savepoint)

drop table emp01;

--테이블 구조를 복사한다.
create table emp01
as
select first_name, salary
from employees where 1=0; --일부러 false조건을 줘서 데이터는 빼고 틀만 가져옴

select * from emp01;

--테이블에 레코드 삽입
INSERT INTO 테이블(컬럼1, 컬럼2)
        문자, 숫자
VALUES('값1',값2);

INSERT INTO emp01(first_name, salary)
VALUES('candy',5000);

--테이블의 모든 컬럼에 데이터를 삽입할때는 컬럼명을 생략 할 수 있다.
INSERT INTO emp01
VALUES('Steven',4000);

--묵시적 NULL삽입 방법, null값이 허용되지 않는 컬럼이면 불가
INSERT INTO emp01(first_name)
VALUES('Lex');

--명시적 NULL삽입 방법
INSERT INTO emp01
VALUES ('Paran',null);

----------------------------------
UPDATE
 테이블의 내용을 수정하는 명령어이다.
 update 테이블명 set 컬럼1=값1,컬럼2=값2 where 컬럼=값;
---------------------------------
--emp01테이블 first_name컬럼의 값이 young일때 candy컬럼의 값을 8000으로 수정하라.
update emp01 set salary=8000
where first_name='candy';

------------------------------------
DELETE
delete from 테이블명 where 절
------------------------------------

--emp01테이블에서 first_name컬럼의 값이 candy일때 데이터를 삭제하라.
DELETE FROM EMP01
WHERE first_name='candy';

------------------------------
트랜잭션(Transaction)
 논리적인 작업단위를 의미한다.
 즉 하나의 작업이 시작해서 정상적으로 종료될때 까지의 과정을 말한다.
 commit : 트랜잭션 정상종료
 rollback : 트랜잭션 취소
 savepoint : 트랜잭션의 중간점을 지정

 preferences -> data management -> sql development -> sql editor -> sql files (오토커밋 설정)
 
 은행(ATM) -> 기계 카드삽입 ->기계가 카드는 읽는다 -> 인출금액 입력->
  -> 비밀번호 입력-> 기계에서 출금액 처리-> 출금금액 제공-> 카드제공
-----------------------------------------------------------
commit

INSERT INTO EMP01
VALUES('Alpa',3000);

INSERT INTO emp01
VALUES('korea',9000);

SAVEPOINT sp

DELETE FROM EMP01
WHERE first_name='Alpa';

rollback to sp

commit

select * from EMP01;

--테이블 구조 정의
create table 테이블명(
  컬럼명 자료형,
  컬럼명 자료형
);

자료형(data type)
varchar2-가변길이 문자를 저장
char-고정길이 문자를 저장
number(m)-정수저장
number(m,n)-실수 저장
date-날짜

create table student(
 name varchar2(20),
 age number(3),
 avg number(5,2),
 bday date
);

--정상삽입
INSERT INTO student(name, age, avg, bday)
VALUES('홍길동', 30, 97.85, sysdate);

--'박차고 나온 세상에' : 크기 초과(20바이트까지만 가능)
INSERT INTO student(name, age, avg, bday)
VALUES('박차고 나온 세상에', 30, 253.38, SYSDATE)

--4000:크기초과(3자리까지만 가능)
INSERT INTO student(name, age, avg, bday)
VALUES('옹달샘', 4000, 97.85, sysdate)

--2921.8589 : 크기초과(5자리까지만 가능)-소수점을 포함하지 않는다.
INSERT INTO student(name, age, avg, bday)
VALUES('캔디', 25, 2921.8589, SYSDATE);

--평균의 소수점 2자리까지 반올림해서 921.86
INSERT INTO student(name, age, avg, bday)
VALUES('포동이', 25, 921.8589, SYSDATE);

--평균의 소수점 2자리까지 반올림해서 21.85
INSERT INTO student(name, age, avg, bday)
VALUES('금순이', 35, 21.8535, SYSDATE);

--조건에 맞아서 그냥 들어감 21.8
INSERT INTO student(name, age, avg, bday)
VALUES('복덩이', 35, 21.8, SYSDATE);

--이것도 조건에 맞아서 그냥 들어감 621.8
INSERT INTO student(name, age, avg, bday)
VALUES('개동이', 35, 621.8, SYSDATE);

--소수 2자리 제외하고 정수는 3자리인데 4자리라서 오류
INSERT INTO student(name, age, avg, bday)
VALUES('개동이', 35, 5621.8, SYSDATE);

SELECT * FROM student;

---------------------------------------------
ALTER
테이블의 구조를 변경해주는 명렁어이다.
---------------------------------------------
--테이블에 컬럼을 추가한다.
ALTER TABLE student
add(loc varchar2(50));

--데이터가 삽입되어 있는 상태에서 줄일 수는 없다.
ALTER TABLE student
MODIFY name varchar2(5);

--테이블에 컬럼을 삭제한다.
ALTER TABLE student
DROP COLUMN loc;

ALTER TABLE student
DROP COLUMN bday;

--테이블에 컬럼명을 수정한다.
ALTER TABLE student
RENAME COLUMN avg to hire;

commit

----------------------------------------------------------
TRUNCATE : 테이블에 저장된 데이터를 모두 제거한다.(auto COMMIT이 됨)
DROP : 테이블 자체를 제거한다.
DELETE : 테이블에 저장된 데이터를 모두 삭제한다.(auto COMMIT이 안됨)
------------------------------------------------------------

delete FROM student;
rollback

TRUNCATE TABLE student;
rollback

DROP TABLE student;
rollback

SELECT * FROM student;

---------------------------------------------------
무결성 제약조건
   무결성이 데이터베이스 내에 있는 데이터의 정확성 유지를 의미한다면
   제약조건은 바람직하지 않는 데이터가 저장되는 것을 방지하는 것을 말한다.
   무결성제약조건 5종류 : not null, unique, primary key, foreign key, check
    not null : null를 허용하지 않는다.
    unique : 중복된 값을 허용하지 않는다. 항상 유일한값이다.
    primary key : not null + unique
    foreign key : 참조되는 테이블의 컬럼의 값이 존재하면 허용된다.
    check : 저장 가능한 데이터값의 범위나 조건을 지정하여 설정한 값만을 허용한다.

   무결성제약조건 2가지 레벨 : 컬럼레벨, 테이블레벨

   컬럼레벨 설정
    create table emp06(
    id varchar2(10) constraint emp06_id_pk primary key,
    name varchar2(20) constraint emp06_name_nk not null,
    age number(3) constraint emp06_age_uk check(age between 20 and 50),
    gen char(2) constraint emp06_gen_uk check(gen in('m','w')));
  
   테이블레벨 설정- not null은 테이블 레벨에서 설정할 수 없다.
    create table emp07(
    id varchar2(10),
    --not null만 테이블 레벨에서 설정할수 없기때문에 컬럼레벨에서 지정
    name varchar2(20) constraint emp02_name_nk not null,
    age number(3),
    gen char(2),
    constraint emp07_id_pk primary key(id),
    constraint emp07_age_uk check(age between 20 and 50),
    constraint emp07_gen_uk check(gen in('m','w'))); 
    
    --ORA-02290: 체크 제약조건(HR.EMP06_AGE_UK)이 위배되었습니다
    INSERT INTO emp06(id, name, age, gen)
    VALUES('100','PARK',15,'m');
    
    SELECT * FROM emp06;
    SELECT * FROM emp07;
    
------------------------------------------------------
제약조건 추가
alter table 테이블명
    add(constraint constraint_name constraint_type(column_name));
-------------------------------------------------------------------------
CREATE TABLE emp08
as
SELECT employee_id, first_name, salary
FROM EMPLOYEES WHERE 1=0;

ALTER TABLE emp08
ADD CONSTRAINT emp08_employee_id_pk primary key(employee_id)

INSERT INTO emp08
VALUES(100,'STEVEN',5000);

--ORA-00001: 무결성 제약 조건(HR.EMP08_EMPLOYEE_ID_PK)에 위배됩니다
INSERT INTO emp08
VALUES(100,'LEX',4000)

-------------------------------------------------------------
 데이터 딕셔너리(Data Dictionary)
  데이터베이스를 운영하기 위한 정보들을 모두 특정한 곳에 모아두고 관리하는데 
  이것을 데이터 딕셔너리라고 한다.
  데이터 딕셔너리는  메모리구조와 파일에 대한 구조정보, 
  각 오브젝트들이 사용되는 공간들의 정보, 제약조건 정보,
  사용자에 대한 정보, 권한이나 프로파일, 롤에대한 정보, 
  감사에 대한정보들을 관리한다.
--------------------------------------------
-------------------------------------------------------------
constraint_type : primary key => p       foreign key =>r
				  check, not null=>c
				  unique =>u
SELECT * FROM user_constraints where constraint_name like '%EMP%'
SELECT * FROM user_tables;
SELECT * FROM user_sequences;

--------------------------------------
  제약조건 수정
  alter table 테이블명
        modify(column_name constraint constraint_name constraint_type);
-------------------------------------------------------------------------
alter table emp08
modify(first_name constraint emp08_firstName_UN unique);

ORA-00001: 무결성 제약 조건(HR.EMP08_FIRSTNAME_UN)에 위배됩니다
insert into emp08 values(200,'STEVEN',6000);

insert into emp08 values(200,'Lex',6000);

------------------------------------------------------------- 
  제약조건 삭제
    alter table 테이블명 drop constraint constraint_name;
-------------------------------------------------------------

alter table emp08 drop constraint emp08_firstName_un;
insert into emp08 values(300,'Lex',7000);

select * from emp08;

----------------------------------------------------
 create table dept01(
   deptno number(2) constraint dept01_deptno_pk primary key,
   dname  varchar2(20));

   insert into dept01 values(10,'accounting');
   insert into dept01 values(20,'sales');
   insert into dept01 values(30,'research');
   select * from dept01;
   
   create table loc01(
   locno number(2),
   locname varchar2(20),
   constraint loc01_locno_pk primary key(locno));
   
   insert into loc01 values(11,'seoul');
   insert into loc01 values(22,'jeju');
   insert into loc01 values(33,'pusan');
   select * from loc01;


   create table emp09(
   empno number(2) primary key,
   deptno number(2) constraint emp09_deptno_fk references dept01(deptno),
   locno number(2) ,
   constraint emp09_locno_fk foreign key(locno) references loc01(locno));

insert into emp09 values(1,10,11);
insert into emp09 values(2,10,22);

--ORA-02291: 무결성 제약조건(HR.EMP09_DEPTNO_FK)이 위배되었습니다- 부모 키가 없습니다
insert into emp09 values(3,40,11);

commit

--emp09테이블에서 참조한 값이 없기 때문에 정상적으로 삭제가 된다.
delete from dept01 where deptno=20;

--ORA-02292: 무결성 제약조건(HR.EMP09_DEPTNO_FK)이 위배되었습니다- 자식 레코드가 발견되었습니다
delete from dept01 where deptno=10;
rollback
select * from emp09
select * from dept01

-----------------------------------------------
   다른 테이블에서 현재 테이블을 참조해서 사용하고 있을때는
    제약조건을 제거한후 현재 테이블의 데이터를 삭제한다.
 ------------------------------------------------
--제약조건 없애주고 나면 지워짐
alter table emp09 drop constraint emp09_deptno_fk;
delete from dept01 where deptno=10;

 ------------------------------------------------------------------
 시퀀스(sequence)
   테이블 내의 유일한 숫자를 자동으로 생성하는 자동번호 발생이므로 시퀀스를
   기본 키로 사용하면 사용자의 부담을 줄일 수 있다.
   create sequence 시퀀스명
     start with  n - 시퀀스 시작번호
     increment by n  -시퀀스 증가치
     nocache   -cache는 메모리상의 시퀀스값을 관리하게 하는데 기본값이 20이다.
              -nocache은 메모리상의 시퀀스를 관리하지 않는다.
     nocycle  - cycle은 지정된 시퀀스값이 최대값까지 증가를 완료하면 start with
                옵션에 지정된 시작값에시 다시 시퀀스를 시작한다.
              - nocycle은  증가가 완료되면 에러를 유발한다.

    maxvalue n;- 시퀀스가 가질수 있는 최대값을 지정한다.
              maxvalue의 기본값은 ascending일때 1027승, descending 일때 -1이다.
--------------------------------------------------------------------------

 create table emp10(
  num number,
  name varchar2(20)); 
              
  --시퀀스 생성
  create sequence emp10_num_seq
  start with 1
  increment by 1
  nocache
  nocycle; 
  
  drop sequence emp10_num_seq;
  
  --nextval=> 다음 시퀀스,   currval=> 현재 시퀀스
  
 --데이터 삽입
  insert into emp10 values(emp10_num_seq.nextval,'kor');
  insert into emp10 values(emp10_num_seq.nextval,'eng');
  select emp10_num_seq.nextval from dual;
 --현재 시퀀값 가져오기
  select emp10_num_seq.currval from dual;
 select * from emp10;
 
 commit

--------------------------------------------------
자바에서 사용할 테이블 생성
----------------------------------------------------
 create table mem(
 num number,
 name varchar2(20),
 age  number(3),
 loc varchar2(10));
  
 create sequence mem_num_seq
 start with 1
 increment by 1
 nocache
 nocycle;

 insert into mem values(mem_num_seq.nextval, '홍길동',30,'서울');
 select * from mem order by num;
 commit;
 
  


