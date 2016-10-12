select * from departments;
select * from mem order by num;
delete from mem where num>=4;
-------------------------------2016-08-04---------------------
select e.employee_id, e.first_name, e.salary, d.department_id, d.department_name,
l.location_id, l.city
 from employees e, departments d, locations l
 where e.department_id=d.department_id
 and d.location_id=l.location_id

select employee_id, first_name, salary, hire_date
from employees
where lower(first_name) like '%alex%';

SELECT center_id, center_name, center_phone 
FROM p_centers
WHERE location_id= (select location_id
					from p_locations
					where dong = '장안동');
					
select a.dong
from p_locations, p_members
where location_id=(select location_id
				   where and b.location_id ='05048'
				   
select center_id, center_name, center_phone
from p_centers
where location_id = 02529;

select dong
from p_locations
where gu='마포구'
group by dong
order by dong;