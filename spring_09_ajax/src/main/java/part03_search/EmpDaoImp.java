package part03_search;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class EmpDaoImp implements EmpDao{
	private SqlSessionTemplate sqlsession;
	
	public EmpDaoImp() {
		
	}
	
	public void setSqlsession(SqlSessionTemplate sqlsession) {
		this.sqlsession = sqlsession;
	}

	@Override
	public List<EmployeeDTO> search(String data) {
		
		return sqlsession.selectList("emp.list",data);
	}
}
