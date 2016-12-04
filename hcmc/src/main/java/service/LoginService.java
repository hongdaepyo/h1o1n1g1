package service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;

public interface LoginService {
	public String loginCheckProcess(String mem_id, String mem_pass);
	public String memberRegisterProcess(MemberDTO mdto, HttpServletRequest req);
	
	//////은지////////////////////////////////////////////////////////////
	
	public void loginInsertProcess(MemberDTO mdto);
	public MemberDTO loginSelectProcess(String mem_id);
	public void loginSearchProcess(MemberDTO mdto, HttpServletRequest request);
	public String loginCheckProcess(MemberDTO dto, HttpServletRequest req);
	public String AuthorChange(String ecode, int mem_num, HttpServletRequest req);
}
