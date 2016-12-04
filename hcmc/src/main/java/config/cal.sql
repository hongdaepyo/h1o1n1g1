insert into F_CITY values(SEQ_f_city_city_num.nextval,'제주도','제주특별자치도 서귀포시 표선면 녹산로 464-65',33.399067,126.706934);
insert into F_CITY values(SEQ_f_city_city_num.nextval,'강원도','강원 정성군 남면 문곡3리(민둥산 일원)',37.265587,128.722715);

insert into F_FESTIVAL values(SEQ_f_festival_festival_num.nextval,'제주 유채꽃 축제',sysdate,   sysdate,'','http://www.jejuflowerfestival.com',   '가족',   '제한없음',0,'유채꽃은',1);
insert into F_FESTIVAL values(SEQ_f_festival_festival_num.nextval,'민둥산억새꽃 축제','2016/09/24','2016/11/13','','http://ariaritour.com','가족','제한없음',0,'민둥산 억새꽃 축제는 산',2);

select * from f_city;
select * from f_festival;

select c.city_name, f.festival_name
from f_city c, f_festival f
where c.city_num = f.city_num;

select *
from F_FESTIVAL


SELECT * FROM F_FESTIVAL
 		WHERE festival_start >= TO_DATE(201611,'YYYYMM') AND festival_start< TO_DATE(201612,'YYYYMM')
