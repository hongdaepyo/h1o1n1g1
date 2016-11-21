package service;

import java.util.List;

import dto.FestivalDTO;
import dto.MemberDTO;

public interface AdminService {
	public List<FestivalDTO> fListProcess();
	public List<MemberDTO> mListProcess();
}
