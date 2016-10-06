select d.department_id,
		d.department_name, e.employee_id, e.first_name
		from departments d,
		employees e
		where d.department_id=e.department_id
		order by d.department_id
		
		
select e.employee_id, e.first_name, d.department_name, l.street_address
from employees e, departments d, locations l
where e.department_id=d.department_id and d.location_id=l.location_id

#도시별 부서명, 사원이름, 사원연봉을 출력
select l.city, d.department_name, e.first_name, e.salary
from locations l, departments d, employees e
where l.location_id=d.location_id
and d.department_id=e.department_id
order by l.city