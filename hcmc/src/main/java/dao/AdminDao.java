package dao;

import java.util.List;

import dto.BoardDTO;
import dto.FestivalDTO;
import dto.MemberDTO;
import dto.MemberDTO;

public interface AdminDao {
	public List<FestivalDTO> fListMethod();
	public List<BoardDTO> bListMethod();
	public List<MemberDTO> mListMethod();
	public void fUpdateMethod(FestivalDTO fdto);
	public void bUpdateMethod(BoardDTO bdto);
	public void mUpdateMethod(MemberDTO mdto);
	public void fDeleteMethod(FestivalDTO fdto);
	public void fAddMethod(FestivalDTO fdto);
	public void fInsMethod(FestivalDTO fdto);
}
