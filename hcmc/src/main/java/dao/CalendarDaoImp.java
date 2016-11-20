package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.FestivalDTO;

public class CalendarDaoImp implements CalendarDao{

	public CalendarDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<FestivalDTO> FestivalList() {
		return sqlSession.selectList("cal.list");
	}
	
	
	
	
}
