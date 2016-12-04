package dao;

import java.util.List;

import dto.MemberDTO;

public interface LoginDao {
	public String loginCheckMethod(String mem_id, String mem_pass);
	public String memberRegisterMethod(MemberDTO mdto);
	
	////////은지///////////////////////////////////////////////////////////
	public void LoginInsert(MemberDTO mdto);
	public MemberDTO LoginSelect(String mem_id);
	public MemberDTO LoginSearch(MemberDTO mdto);
	public boolean LoginCount(MemberDTO mdto);
	public MemberDTO Login_Mem_Num(int mem_num);
	public void AuthUpdate(int mem_num);
}
