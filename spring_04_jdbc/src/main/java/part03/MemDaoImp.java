package part03;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

/*
 * SqlSessionTemplate 클래스
 * 1. 개발자가 중복된 코드를 입력해야 하는 작업을 줄일 수 있도록 돕고 있다.
 * 2. JDBC뿐만 아니라 myBatis, JMS와 같은 다양한 기술에 대해 탬플릿을 제공한다.
 * 3. 예로 Jdbc인 경우 SqlSessionTemplate클래스를 제공하고 있으며, SqlSessionTemplate클래스를
 * 사용함으로써 try~catch~finally 및 커넥션 관리를 위한 중복된 코드를 줄이거나 없앨 수 있다.
 * 
 */

public class MemDaoImp implements MemDao{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemDaoImp() {
		
	}
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<MemDTO> list() {
		
		return sqlSessionTemplate.selectList("mem.all");
	}

	@Override
	public void insertMethod(MemDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMethod(MemDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMethod(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemDTO one(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countMethod() {
		// TODO Auto-generated method stub
		return 0;
	}
}//end class
