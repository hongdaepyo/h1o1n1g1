package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.MemDTO;

public class MyPageDaoImp implements MyPageDao{
	private SqlSessionTemplate sqlSession;
	
	public MyPageDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public MemDTO MemberListMethod(int mem_num) {
		// TODO Auto-generated method stub
		System.out.println("daoimp///////"+mem_num);
		return sqlSession.selectOne("mypage.mem_list",mem_num);
	}

	@Override
	public MemDTO testListMethod(int mem_num) {
		System.out.println("daoimp");
		return sqlSession.selectOne("mypage.mem_list",mem_num);
	}

	@Override
	public String nickUpdateMethod(MemDTO mdto) {
		sqlSession.update("mypage.nick_update",mdto);
		return null;
	}

	@Override
	public MemDTO passwordUpdateMethod(MemDTO mdto) {
		sqlSession.update("mypage.pass_update",mdto);
		return sqlSession.selectOne("mypage.mem_list",mdto.getMem_num());
	}

}
