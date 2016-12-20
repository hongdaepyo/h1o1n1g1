package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.BoardDTO;
import dto.FestivalDTO;

public class MainDaoImp implements MainDao{
	private SqlSessionTemplate sqlSession;
	
	public MainDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<BoardDTO> mainMethod() {
		return sqlSession.selectList("main.board");
	}

	@Override
	public List<FestivalDTO> cityMethod(String city_name) {
		System.out.println("city_name : "+city_name);
		return sqlSession.selectList("main.city_festival",city_name);
	}

}
