package part06;

import java.util.List;

public class DeptDTO {
	private String department_name;
	private int department_id;
	private List<EmpDTO> emp;

	public DeptDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public List<EmpDTO> getEmp() {
		return emp;
	}

	public void setEmp(List<EmpDTO> emp) {
		this.emp = emp;
	}
	
	
	

}
