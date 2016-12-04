package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import dao.SearchDao;
import dto.FestivalDTO;

public class SearchServiceImp implements SearchService{
	private SearchDao dao;
	
	public void setDao(SearchDao dao) {
		this.dao = dao;
	}

	

	@Override
	public List<FestivalDTO> searchProcess(String city_name, String festival_theme, String festival_start) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", city_name);
		map.put("theme", festival_theme);
		map.put("start", festival_start);
		System.out.println("serviceMap:"+map);
		return dao.searchList(map);
	}
	
	@Override
	public int totalProcess(String city_name, String festival_theme, String festival_start) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", city_name);
		map.put("theme", festival_theme);
		map.put("start", festival_start);
		return dao.totalCount(map);
	}
	
	@Override
	public List<FestivalDTO> monthProcess() {
		
		SimpleDateFormat yFormat = new SimpleDateFormat ( "yyyy", Locale.KOREA );
	      SimpleDateFormat mFormat = new SimpleDateFormat ( "MM", Locale.KOREA );
	      Date currentTime = new Date ( );
	      String years = yFormat.format ( currentTime); //오늘 해
	      String months = mFormat.format ( currentTime ); //오늘 달
	      String yearstr;
	      
	      int year = Integer.parseInt(years);
	      int month = Integer.parseInt(months);
	      
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
	      map.put("start", yearint1);
	      map.put("end", yearint2);
		return dao.monthList(map);
	}


}
