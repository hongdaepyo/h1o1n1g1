package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.BoardDTO;
import dto.FestivalDTO;
import dto.MemberDTO;

public class MyPageDaoImp implements MyPageDao{
	private SqlSessionTemplate sqlSession;
	
	public MyPageDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public MemberDTO MemberListMethod(int mem_num) {
		return sqlSession.selectOne("mypage.mem_list",mem_num);
	}//회원번호가 일치하는 회원의 모든 정보를 가져와서 리턴
	
	@Override
	public List<BoardDTO> MyBoardListMethod(int mem_num) {
		return sqlSession.selectList("mypage.my_board_list",mem_num);
	}//회원 번호가 일치하는 모든 게시글을 가져와서 리턴

	@Override
	public String nickUpdateMethod(MemberDTO mdto) {
		sqlSession.update("mypage.nick_update",mdto);
		return null;
	}//마이페이지에서 입력받은 닉네임과 회원번호를 MemberDTO에 담아 전달하고 회원 번호가 일치하는 회원 닉네임으로 업데이트

	@Override
	public MemberDTO passwordUpdateMethod(MemberDTO mdto) {
		sqlSession.update("mypage.pass_update",mdto);
		return sqlSession.selectOne("mypage.mem_list",mdto.getMem_num());
	}//회원 비밀번호를 변경하고 새 회원정보 리턴

	@Override
	public List<?> MyFavorListMethod(int mem_num) {
		return sqlSession.selectOne("mypage.my_favor_list",mem_num);
	}//내 즐겨찾기 목록을 표시 //아직 안쓰임

	

	

}
