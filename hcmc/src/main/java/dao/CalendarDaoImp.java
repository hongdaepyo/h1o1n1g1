package dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.CityDTO;
import dto.FavorDTO;
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
	public List<FestivalDTO> FestivalList(HashMap<String, Integer> map) {		
		return sqlSession.selectList("cal.list",map);
	}//달력페이지에서 받아온 달과 해를 맵에 담아 dao에 전달하고 결과를 리턴
	
	@Override
	public FestivalDTO festivalInfoMethod(int festival_num) {
		return sqlSession.selectOne("cal.fes_info",festival_num);
	}//축제정보페이지에 필요한 축제정보를 축제번호로 검색하여 가져와서 리턴

	@Override
	public CityDTO cityInfoMethod(int festival_num) {
		return sqlSession.selectOne("cal.fes_info_city",festival_num);
	}//축제정보페이지에 필요한 도시정보를 축제번호로 검색하여 가져와서 리턴
	
	@Override
	public void readCount(int festival_num) {
		sqlSession.update("cal.readCount", festival_num);		
	}

	@Override
	public void favorInsertMethod(HashMap<String, Integer> map) {
		sqlSession.insert("cal.favor_insert",map);
	}

	@Override
	public List<FavorDTO> FavorListMethod(int mem_num) {
		System.out.println("logindao"+mem_num);
		return sqlSession.selectList("cal.favor_list",mem_num);
	}//회원이 즐겨찾기 등록한 모든 즐겨찾기 목록을 가져옴
	
	@Override
	public List<String> fespicMethod(int festival_num) {
		return sqlSession.selectList("cal.fes_info_pic",festival_num);
	}
	
}
