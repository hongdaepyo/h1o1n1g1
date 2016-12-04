package service;

import java.util.List;

import dto.CityDTO;
import dto.FestivalDTO;

public interface CalendarService {
	public List<FestivalDTO> FestivalList(int month, int year);
	public FestivalDTO festivalInfoProcess(int festival_num);
	public CityDTO cityInfoProcess(int festival_num);
	public void readCountProcess(int festival_num);
}
