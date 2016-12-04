package service;

import java.util.HashMap;
import java.util.List;

import dao.CalendarDao;
import dto.CityDTO;
import dto.FestivalDTO;

public class CalendarServiceImp implements CalendarService{
	private CalendarDao dao;
	
	
	public void setDao(CalendarDao dao) {
		this.dao = dao;
	}	
	
	@Override
	public List<FestivalDTO> FestivalList(int month, int year) {		
		String yearstr;
		
		if(month<10)//달력에서 받아온 날짜중 달이 1~9월일 때 앞에 0을 붙여줌
			yearstr=String.valueOf(year)+"0"+String.valueOf(month);
		else
			yearstr=String.valueOf(year)+String.valueOf(month);

		int yearint1 = Integer.parseInt(yearstr);
		int yearint2 = yearint1+1;
		
		if(month==0){//해가 바뀔 때 처리(이전 해로 넘어갈 때)
			month=12; year--;
			yearstr=String.valueOf(year)+String.valueOf(month);
			yearint1 = Integer.parseInt(yearstr);
			
		}else if(month==12){//해가 바뀔 때 처리(다음 해로 넘어갈 때)
			month=1; year++;
			yearstr=String.valueOf(year)+"0"+String.valueOf(month);
			yearint2 = Integer.parseInt(yearstr);
		}//해가 바뀔 때 처리
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("y1", yearint1);
		map.put("y2", yearint2);
		return dao.FestivalList(map);
	}//달력페이지에서 받아온 달과 해를 맵에 담아 dao에 전달하고 결과를 리턴
	
	@Override
	public FestivalDTO festivalInfoProcess(int festival_num) {
		return dao.festivalInfoMethod(festival_num);
	}//축제정보페이지에 필요한 축제정보를 축제번호로 검색하여 가져와서 리턴

	@Override
	public CityDTO cityInfoProcess(int festival_num) {
		return dao.cityInfoMethod(festival_num);
	}//축제정보페이지에 필요한 도시정보를 축제번호로 검색하여 가져와서 리턴
	
	@Override
	public void readCountProcess(int festival_num) {
		dao.readCount(festival_num);
		
	}
}
