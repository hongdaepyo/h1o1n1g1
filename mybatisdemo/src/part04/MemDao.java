package part04;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemDao {
	
	SqlSession session;
	public MemDao() {
		
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
	}
	
	//listMethod 정의
	public List<MemDTO> listMethod(){
		return session.selectList("per.all");
	}
	
	public void deleteMethod(String[] chk){
		session.delete("per.del", chk);
	}

}
