package dao;

import java.util.List;

import dto.FestivalDTO;
import dto.MemDTO;

public interface MyPageDao {
	public MemDTO MemberListMethod(int mem_num);
	public MemDTO testListMethod(int mem_num);
	public String nickUpdateMethod(MemDTO mdto);
	public MemDTO passwordUpdateMethod(MemDTO mdto);
	public FestivalDTO festivalInfoMethod(int festival_num);

}
