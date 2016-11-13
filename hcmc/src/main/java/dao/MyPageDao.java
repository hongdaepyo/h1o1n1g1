package dao;

import java.util.List;

import dto.MemberDTO;

public interface MyPageDao {
	public MemberDTO MemberListMethod(int mem_num);
	public List<MemberDTO> testMethod(int mem_num);

}
