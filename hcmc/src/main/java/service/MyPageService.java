package service;

import java.util.List;

import dto.BoardDTO;
import dto.FestivalDTO;
import dto.MemberDTO;

public interface MyPageService {
	public MemberDTO memberListProcess(int mem_num);
	public List<BoardDTO> myBoardListProcess(int mem_num);
	public List<?> myFavorListProcess(int mem_num);
	public String nickUpdateProcess(MemberDTO mdto);
	public MemberDTO passwordUpdateProcess(MemberDTO mdto);
	

}
