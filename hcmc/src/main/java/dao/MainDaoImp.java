package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.BoardDTO;

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
		System.out.println("daodaodao"+sqlSession.selectList("main.board"));
		return sqlSession.selectList("main.board");
	}

}
