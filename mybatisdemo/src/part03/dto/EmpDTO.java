package part03.dto;

public class EmpDTO {
	private String employee_id, first_name, job_id, department_id;
	private DeptDTO dept;
	
	public EmpDTO() {
	
	}

	public EmpDTO(String employee_id, String first_name, String job_id, String department_id) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.job_id = job_id;
		this.department_id = department_id;
	}
	
	

	public DeptDTO getDept() {
		return dept;
	}

	public void setDept(DeptDTO dept) {
		this.dept = dept;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getDepartment_id() {
		
		return department_id;
	}

	public void setDepartment_id(String department_id) {		
		this.department_id = department_id;
	}
	
	
	
	
}// end class







