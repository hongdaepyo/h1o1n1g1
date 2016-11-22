package service;

import java.util.List;

import dao.AdminDao;
import dto.FestivalDTO;
import dto.MemDTO;
import dto.MemberDTO;

public class AdminServiceImp implements AdminService{
	private AdminDao dao;
	
	public AdminServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	@Override
	public List<FestivalDTO> fListProcess() {
		return dao.fListMethod();
	}

	@Override
	public List<MemberDTO> mListProcess() {
		return dao.mListMethod();
	}

	@Override
	public void fUpdateProcess(FestivalDTO fdto) {
		dao.fUpdateMethod(fdto);
	}

	@Override
	public void mUpdateProcess(MemDTO mdto) {
		dao.mUpdateMethod(mdto);		
	}
	
	
	

}
