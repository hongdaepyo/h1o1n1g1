package service;

import java.util.HashMap;
import java.util.List;

import dto.CityDTO;
import dto.FavorDTO;
import dto.FestivalDTO;

public interface CalendarService {
	public List<FestivalDTO> FestivalList(int month, int year);
	public List<FavorDTO> favorListProcess(int mem_num);
	
	public List<String> fespicProcess(int festival_num);
	public FestivalDTO festivalInfoProcess(int festival_num);
	public CityDTO cityInfoProcess(int festival_num);
	public void readCountProcess(int festival_num);
	public HashMap<String, Integer> DateProcess(int month, int year);
	
	public void favorInsertProcess(int festival_num, int mem_num);
}
