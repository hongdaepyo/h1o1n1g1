package service;

import java.util.List;

import dto.FestivalDTO;

public interface SearchService {
	public List<FestivalDTO> searchProcess(String city_name, String festival_theme, String festival_start);
	public int totalProcess(String city_name, String festival_theme, String festival_start);
	public List<FestivalDTO> monthProcess();

}
