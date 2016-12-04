package dao;

import java.util.HashMap;
import java.util.List;

import dto.FestivalDTO;

public interface SearchDao {
	
	public List<FestivalDTO> searchList(HashMap<String, String> map);
	public int totalCount(HashMap<String, String> map);
	public List<FestivalDTO> monthList(HashMap<String, Integer> map);
}
