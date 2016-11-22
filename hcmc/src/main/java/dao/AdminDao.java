package dao;

import java.util.List;

import dto.FestivalDTO;
import dto.MemDTO;
import dto.MemberDTO;

public interface AdminDao {
	public List<FestivalDTO> fListMethod();
	public List<MemberDTO> mListMethod();
	public void fUpdateMethod(FestivalDTO fdto);
	public void mUpdateMethod(MemDTO mdto);
}
