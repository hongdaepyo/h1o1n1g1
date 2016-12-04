package dao;

import java.util.HashMap;
import java.util.List;

import dto.CityDTO;
import dto.FestivalDTO;

public interface CalendarDao {
	public List<FestivalDTO> FestivalList(HashMap<String, Integer> map);
	public FestivalDTO festivalInfoMethod(int festival_num);
	public CityDTO cityInfoMethod(int festival_num);
	public void readCount(int festival_num);
}
