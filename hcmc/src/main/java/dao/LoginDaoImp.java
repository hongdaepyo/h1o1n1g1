package dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.MemberDTO;

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
	public String memberRegisterMethod(MemberDTO mdto) {
		HashMap<String, String> map =new HashMap<String, String>();
		map.put("id", mdto.getMem_id());
		map.put("pass", mdto.getMem_pass());
		sqlSession.insert("login.mem_register",map);
		return null;
	}//회원가입창에 입력된 id와 password를 맵에 담아 전달해서 등록
	
	///////은지/////////////////////////////////////////////////
	
	@Override
	public void LoginInsert(MemberDTO mdto) {
		sqlSession.insert("login.login_insert",mdto);
	}//id와 password를 MemberDTO에 담아 전달해서 등록// 아직 쓰이는 곳 없음

	@Override
	public MemberDTO LoginSelect(String mem_id) {
		return sqlSession.selectOne("login.login_select", mem_id);
	}//id를 넘겨주고 일치하는 회원의 모든 정보를 가져와서 리턴

	@Override
	public MemberDTO LoginSearch(MemberDTO mdto) {		
		return sqlSession.selectOne("login.login_search", mdto);
	}//id와 password를 MemberDTO에 담아 전달하고 일치하는 회원의 모든 정보를 가져와서 리턴


	@Override
	public boolean LoginCount(MemberDTO mdto) {
		int chk=sqlSession.selectOne("login.login_count",mdto);
		if(chk==1) //id와 password를 MemberDTO에 담아 전달하고 일치하는 회원 수를 가져와서 비교
			return true;
		else
			return false;
	}//일치하는 아이디의 존재여부를 리턴

	@Override
	public MemberDTO Login_Mem_Num(int mem_num) {
		return sqlSession.selectOne("login.login_mem_num_search",mem_num);
	}//일치하는 회원번호로 회원 정보 가져옴

	@Override
	public void AuthUpdate(int mem_num) {
		sqlSession.update("login.authUpdate",mem_num);
	}//회원번호가 일치하는 회원의 권한을 일반회원으로 업데이트해줌

}
