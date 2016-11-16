package service;

import java.util.List;

import dto.MemDTO;

public interface MyPageService {
	public MemDTO memberListProcess(int mem_num);
	public MemDTO testListProcess(MemDTO mdto);
	public String nickUpdateProcess(MemDTO mdto);
	public MemDTO passwordUpdateProcess(MemDTO mdto);

}
