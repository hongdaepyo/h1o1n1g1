package dao;

import java.util.HashMap;
import java.util.List;

import dto.CityDTO;
import dto.FavorDTO;
import dto.FestivalDTO;

public interface CalendarDao {
	public List<FestivalDTO> FestivalList(HashMap<String, Integer> map);
	public List<FavorDTO> FavorListMethod(int mem_num);
	
	public List<String> fespicMethod(int festival_num);
	public FestivalDTO festivalInfoMethod(int festival_num);
	public CityDTO cityInfoMethod(int festival_num);
	public void readCount(int festival_num);
	public void favorInsertMethod(HashMap<String, Integer> map);
	
}
