package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.MyPageDao;
import dto.BoardDTO;
import dto.FavorDTO;
import dto.FestivalDTO;
import dto.MemberDTO;

public class MyPageServiceImp implements MyPageService{
	private MyPageDao dao;
	
	public MyPageServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setDao(MyPageDao dao) {
		this.dao = dao;
	}
	@Override
	public MemberDTO memberListProcess(int mem_num) {
		return dao.MemberListMethod(mem_num);
	}//회원번호가 일치하는 회원의 모든 정보를 가져와서 리턴
	
	@Override
	public List<BoardDTO> myBoardListProcess(int mem_num) {
		return dao.MyBoardListMethod(mem_num);
	}//회원 번호가 일치하는 모든 게시글을 가져와서 리턴

	@Override
	public String nickUpdateProcess(MemberDTO mdto) {
		return dao.nickUpdateMethod(mdto);
	}//마이페이지에서 입력받은 닉네임과 회원번호를 MemberDTO에 담아 전달하고 회원 번호가 일치하는 회원 닉네임으로 업데이트

	@Override
	public MemberDTO passwordUpdateProcess(MemberDTO mdto) {
		return dao.passwordUpdateMethod(mdto);
	}//패스워드 업데이트

	@Override
	public List<FavorDTO> myFavorListProcess(int mem_num) {
		return dao.MyFavorListMethod(mem_num);
	}//나의 즐겨찾기 조회 //아직 안쓰임

	@Override
	public void memberDeleteProcess(int mem_num) {
		dao.memberDeleteMethod(mem_num);
		
	}

	@Override
	public List<FestivalDTO> myPageFList() {
		return dao.myPageFListMethod();
	}

	@Override
	public void myFavorDelProcess(int favor_num) {
		dao.myFavorDeleteMethod(favor_num);
	}

	
	
}
