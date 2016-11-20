package service;

import java.util.List;

import dao.CalendarDao;
import dto.FestivalDTO;

public class CalendarServiceImp implements CalendarService{
	private CalendarDao dao;
	
	
	public void setDao(CalendarDao dao) {
		this.dao = dao;
	}	
	
	@Override
	public List<FestivalDTO> FestivalList() {
		return dao.FestivalList();
	}
	
}
