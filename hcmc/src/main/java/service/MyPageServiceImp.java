package service;

import java.util.List;

import dao.MyPageDao;
import dto.MemberDTO;

public class MyPageServiceImp implements MyPageService{
	private MyPageDao dao;
	
	public MyPageServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setDao(MyPageDao dao) {
		this.dao = dao;
	}

	@Override
	public MemberDTO memberListProcess(int mem_num) {
		System.out.println("serviceimp");
		return dao.MemberListMethod(mem_num);
	}

	@Override
	public List<MemberDTO> testProcess(int mem_num) {
		System.out.println("serviceimp");
		return dao.testMethod(mem_num);
	}

	
}
