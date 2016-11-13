package service;

import java.util.List;

import dto.MemberDTO;

public interface MyPageService {
	public MemberDTO memberListProcess(int mem_num);
	public List<MemberDTO> testProcess(int mem_num);

}
