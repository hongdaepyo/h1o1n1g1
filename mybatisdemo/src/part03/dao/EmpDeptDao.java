package part03.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import part02.dto.MemDTO;
import part03.dto.DeptDTO;
import part03.dto.EmpDTO;

public class EmpDeptDao {
	SqlSession session;
	public EmpDeptDao() {
		
		String resource="config/configuration.xml";
		
		try {
			Reader reader=Resources.getResourceAsReader(resource);
			SqlSessionFactoryBuilder build=new SqlSessionFactoryBuilder();
			SqlSessionFactory factory= build.build(reader);
			session=factory.openSession(true);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end EmpDeptDao
	
	public List<EmpDTO> allMethod(){
		return session.selectList("empdept.all");
	}
	
	public List<EmpDTO> emp_deptMethod(){
		return session.selectList("empdept.emp_dept");
	}
	
	public List<DeptDTO> dept_empMethod(){
		return session.selectList("empdept.dept_emp");
	}
	
	public List<EmpDTO> partMethod(){
		return session.selectList("empdept.dnator");
	}
}//end class
