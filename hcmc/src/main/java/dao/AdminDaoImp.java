package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.FestivalDTO;
import dto.MemDTO;
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
	}

	@Override
	public List<MemberDTO> mListMethod() {
		return sqlSession.selectList("admin.member");
	}

	@Override
	public void fUpdateMethod(FestivalDTO fdto) {
		sqlSession.update("admin.f_update",fdto);
	}

	@Override
	public void mUpdateMethod(MemDTO mdto) {
		sqlSession.update("admin.m_update",mdto);
		
	}

}
