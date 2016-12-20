package service;

import java.util.List;

import dto.BoardDTO;
import dto.FestivalDTO;

public interface MainService {
	public List<BoardDTO> mainProcess();
	public List<FestivalDTO> cityProcess(String city_name);

}
