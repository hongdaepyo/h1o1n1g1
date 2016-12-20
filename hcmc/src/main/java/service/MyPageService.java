package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDTO;
import dto.FavorDTO;
import dto.FestivalDTO;
import dto.MemberDTO;

public interface MyPageService {
	public MemberDTO memberListProcess(int mem_num);
	public List<BoardDTO> myBoardListProcess(int mem_num);
	public List<FavorDTO> myFavorListProcess(int mem_num);
	public String nickUpdateProcess(MemberDTO mdto);
	public MemberDTO passwordUpdateProcess(MemberDTO mdto);
	public void memberDeleteProcess(int mem_num);
	public List<FestivalDTO> myPageFList();
	public void myFavorDelProcess(int favor_num);
	

}
