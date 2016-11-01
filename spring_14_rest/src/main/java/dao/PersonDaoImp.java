package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.PersonDTO;

public class PersonDaoImp implements PersonDao{
	private SqlSessionTemplate sqlSession;
	
	public PersonDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<PersonDTO> list() {
		
		return sqlSession.selectList("per.all");
	}

	@Override
	public PersonDTO list(int num) {
		
		return sqlSession.selectOne("per.one", num);
	}

	@Override
	public void register(PersonDTO dto) {
		sqlSession.insert("per.ins", dto);
		
	}

	@Override
	public void update(PersonDTO dto) {
		sqlSession.update("per.upt",dto);
		
	}

	@Override
	public void delete(int num) {
		sqlSession.delete("per.del",num);
		
	}

	@Override
	public PersonDTO list(PersonDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("per.search",dto);
	}
	
	

}
