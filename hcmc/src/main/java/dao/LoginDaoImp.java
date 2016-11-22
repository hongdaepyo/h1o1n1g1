package dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

public class LoginDaoImp implements LoginDao{
	private SqlSessionTemplate sqlSession;
	
	public LoginDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public String loginCheckMethod(String mem_id, String mem_pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String memberRegisterMethod(String mem_id, String mem_pass) {
		HashMap<String, String> map =new HashMap<String, String>();
		map.put("id", mem_id);
		map.put("pass", mem_pass);
		sqlSession.insert("login.mem_register",map);
		return null;
	}
	

}
