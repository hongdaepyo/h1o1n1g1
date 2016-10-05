select d.department_id,
		d.department_name, e.employee_id, e.first_name
		from departments d,
		employees e
		where d.department_id=e.department_id
		order by d.department_id