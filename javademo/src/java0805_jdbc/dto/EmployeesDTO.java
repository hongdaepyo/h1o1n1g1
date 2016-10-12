package java0805_jdbc.dto;

public class EmployeesDTO {
	private int employee_id;
	private String first_name;
	private int salary;
	private int department_id;
	
	public EmployeesDTO() {

	}	
		
	public int getEmployee_id() {
		return employee_id;
	}
	
	public void setDepartment_id(int deparment_id) {
		this.department_id = deparment_id;
	}
	public int getDepartment_id() {
		return department_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}// end class
