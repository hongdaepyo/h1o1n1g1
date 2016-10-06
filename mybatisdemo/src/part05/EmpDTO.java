package part05;

public class EmpDTO {
	private int employee_id, department_id;
	private String first_name;
	private DeptDTO dept;
	private LocDTO loc;
	
	public DeptDTO getDept() {
		return dept;
	}

	public void setDept(DeptDTO dept) {
		this.dept = dept;
	}

	public LocDTO getLoc() {
		return loc;
	}

	public void setLoc(LocDTO loc) {
		this.loc = loc;
	}

	public EmpDTO() {
		// TODO Auto-generated constructor stub
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

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	
	

}
