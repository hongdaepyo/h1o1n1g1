package service;

import java.util.List;

import dao.MainDao;
import dao.MainDaoImp;
import dto.BoardDTO;
import dto.FestivalDTO;

public class MainServiceImp implements MainService{
	private MainDao dao;
	
	public MainServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setDao(MainDao dao) {
		this.dao = dao;
	}

	@Override
	public List<BoardDTO> mainProcess() {
		System.out.println("service"+dao.mainMethod());
		return dao.mainMethod();
	}

	@Override
	public List<FestivalDTO> cityProcess(String city_name) {
		return dao.cityMethod(city_name);
	}

}
