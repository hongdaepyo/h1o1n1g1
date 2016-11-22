package service;

import java.util.List;

import dto.FestivalDTO;
import dto.MemDTO;
import dto.MemberDTO;

public interface AdminService {
	public List<FestivalDTO> fListProcess();
	public List<MemberDTO> mListProcess();
	public void fUpdateProcess(FestivalDTO fdto);
	public void mUpdateProcess(MemDTO mdto);
}
