package dao;

import java.util.List;

import dto.FestivalDTO;
import dto.MemberDTO;

public interface AdminDao {
	public List<FestivalDTO> fListMethod();
	public List<MemberDTO> mListMethod();
}
