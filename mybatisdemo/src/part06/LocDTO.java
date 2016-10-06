package part06;

import java.util.List;

public class LocDTO {
	private String city;
	private int location_id;
	private List<DeptDTO> dept;
	
	public LocDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}


	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}


	public List<DeptDTO> getDept() {
		return dept;
	}


	public void setDept(List<DeptDTO> dept) {
		this.dept = dept;
	}

}
