package dao;

public interface LoginDao {
	public String loginCheckMethod(String mem_id, String mem_pass);
	public String memberRegisterMethod(String mem_id, String mem_pass);
}
