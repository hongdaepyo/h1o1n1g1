package dao;

import java.util.List;

import dto.BoardDTO;
import dto.FestivalDTO;
import dto.MemberDTO;

public interface MyPageDao {
	public MemberDTO MemberListMethod(int mem_num);
	public List<BoardDTO> MyBoardListMethod(int mem_num);
	public List<?> MyFavorListMethod(int mem_num);
	public String nickUpdateMethod(MemberDTO mdto);
	public MemberDTO passwordUpdateMethod(MemberDTO mdto);
	

}
