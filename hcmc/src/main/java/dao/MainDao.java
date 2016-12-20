package dao;

import java.util.List;

import dto.BoardDTO;
import dto.FestivalDTO;

public interface MainDao {
	public List<BoardDTO> mainMethod();
	public List<FestivalDTO> cityMethod(String city_name);

}
