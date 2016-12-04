package dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.FestivalDTO;
import dto.MemberDTO;

public class SearchDaoImp implements SearchDao{
	private SqlSessionTemplate sqlSession;
	
	public SearchDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<FestivalDTO> searchList(HashMap<String, String> map) {
		return sqlSession.selectList("search.search_list",map);
	}
	
	@Override
	public int totalCount(HashMap<String, String> map) {
		return sqlSession.selectOne("search.totalcount", map);
	}
	

	@Override
	public List<FestivalDTO> monthList(HashMap<String, Integer> map) {
		return sqlSession.selectList("search.month_festival",map);
	}
	

}
	