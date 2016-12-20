package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDTO;
import dto.FestivalDTO;
import dto.MemberDTO;
import dto.MemberDTO;

public interface AdminService {
	public List<FestivalDTO> fListProcess();
	public List<BoardDTO> bListProcess();
	public List<MemberDTO> mListProcess();
	public void fUpdateProcess(FestivalDTO fdto, HttpServletRequest req);
	public void bUpdateProcess(BoardDTO bdto);
	public void mUpdateProcess(MemberDTO mdto);
	public void fDeleteProcess(FestivalDTO fdto, HttpServletRequest req);
	public List<FestivalDTO> fAddProcess(FestivalDTO fdto);
	public void fInsProcess(FestivalDTO fdto, HttpServletRequest req);
}
