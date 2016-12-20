package dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDTO;
import dto.FavorDTO;
import dto.FestivalDTO;
import dto.MemberDTO;

public interface MyPageDao {
	public MemberDTO MemberListMethod(int mem_num);
	public List<BoardDTO> MyBoardListMethod(int mem_num);
	public List<FavorDTO> MyFavorListMethod(int mem_num);
	public String nickUpdateMethod(MemberDTO mdto);
	public MemberDTO passwordUpdateMethod(MemberDTO mdto);
	public void memberDeleteMethod(int mem_num);
	public List<FestivalDTO> myPageFListMethod();
	public void myFavorDeleteMethod(int favor_num);
	

}
