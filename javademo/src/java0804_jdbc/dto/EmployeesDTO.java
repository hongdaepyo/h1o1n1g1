package java0804_jdbc.dto;

public class EmployeesDTO {
	private int employee_id;
	private String first_name;
	private int salary;
	//join 해서 사용할 때는 아래처럼 선언되어 있어야 한다.
	private DepartmentsDTO mdto;
	private LocationsDTO ldto;

	public EmployeesDTO() {

	}	
	
	public LocationsDTO getLdto() {
		return ldto;
	}
	
	public void setLdto(LocationsDTO ldto) {
		this.ldto = ldto;
	}

	public DepartmentsDTO getMdto() {
		return mdto;
	}

	public void setMdto(DepartmentsDTO mdto) {
		this.mdto = mdto;
	}

	public int getEmployee_id() {
		return employee_id;
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
