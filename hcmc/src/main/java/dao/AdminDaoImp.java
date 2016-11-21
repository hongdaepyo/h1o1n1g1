package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.FestivalDTO;
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

}
