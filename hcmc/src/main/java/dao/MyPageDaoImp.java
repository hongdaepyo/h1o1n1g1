package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.MemberDTO;

public class MyPageDaoImp implements MyPageDao{
	private SqlSessionTemplate sqlSession;
	
	public MyPageDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public MemberDTO MemberListMethod(int mem_num) {
		// TODO Auto-generated method stub
		System.out.println("daoimp");
		return sqlSession.selectOne("mypage.mem_list",mem_num);
	}

	@Override
	public List<MemberDTO> testMethod(int mem_num) {
		System.out.println("daoimp");
		return sqlSession.selectList("mypage.mem_list",mem_num);
	}

}
