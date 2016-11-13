package dto;

public class MemberDTO {
	private int mem_num;
	private String mem_id, mem_pass, mem_nickname;
	private char mem_admin;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pass() {
		return mem_pass;
	}

	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}

	public String getMem_nickname() {
		return mem_nickname;
	}

	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}

	public char getMem_admin() {
		return mem_admin;
	}

	public void setMem_admin(char mem_admin) {
		this.mem_admin = mem_admin;
	}
	
	

}
