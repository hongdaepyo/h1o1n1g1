package service;

import dao.LoginDao;

public class LoginServiceImp implements LoginService{
	private LoginDao dao;
	
	public LoginServiceImp() {
		// TODO Auto-generated constructor stub
	}
	public void setDao(LoginDao dao) {
		this.dao = dao;
	}

	@Override
	public String loginCheckProcess(String mem_id, String mem_pass) {
		return null;
	}
	@Override
	public String memberRegisterProcess(String mem_id, String mem_pass) {
		return dao.memberRegisterMethod(mem_id, mem_pass);
	}
	
	

}
