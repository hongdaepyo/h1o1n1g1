package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.BoardDTO;
import dto.FestivalDTO;
import dto.MemberDTO;
import dto.MemberDTO;

public class AdminDaoImp implements AdminDao {
	private SqlSessionTemplate sqlSession;
	
	public AdminDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<FestivalDTO> fListMethod() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("admin.festival");
	}//모든 축제 정보를 축제 정보 순서로 정렬하여 가져와서 리턴
	
	@Override
	public List<BoardDTO> bListMethod() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("admin.board");
	}//모든 게시글 정보를 게시글 번호순으로 정렬하여 가져와서 리턴

	@Override
	public List<MemberDTO> mListMethod() {
		return sqlSession.selectList("admin.member");
	}//모든 회원 정보를 회원번호 순으로 정렬하여 가져와서 리턴

	@Override
	public void fUpdateMethod(FestivalDTO fdto) {
		sqlSession.update("admin.f_update",fdto);
		if(!fdto.getFestival_filename()[0].getOriginalFilename().equals("")){
			sqlSession.delete("admin.festival_pic_delete",fdto); //기존 파일은 삭제하고
			sqlSession.insert("admin.festival_pic_insert",fdto); //새 파일은 추가
		}
	}//FestivalDTO에 수정된 축제정보를 담아와서 업데이트 
	
	@Override
	public void bUpdateMethod(BoardDTO bdto) {
		sqlSession.update("admin.b_update",bdto);
	}//BoardDTO에 수정된 게시글 정보를 담아와서 업데이트

	@Override
	public void mUpdateMethod(MemberDTO mdto) {
		sqlSession.update("admin.m_update",mdto);	
	}//MemberDTO에 수정된 회원 정보를 담아와서 업데이트

	@Override
	public void fDeleteMethod(FestivalDTO fdto) {
		sqlSession.delete("admin.f_delete",fdto);
	}//FestivalDTO에 축제번호를 담아와서 해당 축제를 삭제???

	@Override
	public void fAddMethod(FestivalDTO fdto) {
		sqlSession.insert("admin.f_add",fdto);
	}//축제추가 폼에 입력된 정보를 FestivalDTO로 담아와서 입력

	@Override
	public void fInsMethod(FestivalDTO fdto) {
		sqlSession.insert("admin.f_insert",fdto);		
	}
	
	

}
