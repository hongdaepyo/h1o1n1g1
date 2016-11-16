package service;

import java.util.List;

import dao.MyPageDao;
import dto.MemDTO;

public class MyPageServiceImp implements MyPageService{
	private MyPageDao dao;
	
	public MyPageServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setDao(MyPageDao dao) {
		this.dao = dao;
	}
	@Override
	public MemDTO memberListProcess(int mem_num) {
		System.out.println("serviceimp/////"+mem_num);
		return dao.MemberListMethod(mem_num);
	}

	@Override
	public MemDTO testListProcess(MemDTO mdto) {
		System.out.println("serviceimp");
		return dao.testListMethod(mdto.getMem_num());
	}

	@Override
	public String nickUpdateProcess(MemDTO mdto) {
		return dao.nickUpdateMethod(mdto);
	}

	@Override
	public MemDTO passwordUpdateProcess(MemDTO mdto) {
		return dao.passwordUpdateMethod(mdto);
	}

	
}
