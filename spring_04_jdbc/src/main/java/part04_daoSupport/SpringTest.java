package part04_daoSupport;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-jdbc</artifactId>
		<version>3.2.3.RELEASE</version>
	</dependency>
	
	<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
	<dependency>
		<groupId>org.aspectj</groupId>
		<artifactId>aspectjweaver</artifactId>
		<version>1.8.6</version>
	</dependency>*/

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("part04_daoSupport/jdbc.xml");
		MemDao dao=(MemDao)context.getBean("dao");
		
		//dao.insertMethod(new MemDTO("박나리",40,"서울"));
		//dao.updateMethod(new MemDTO(26,"김나사"));
		//dao.deleteMethod(25);
		
		/*List<MemDTO> list=dao.list();
		for(MemDTO dto : list)
			System.out.printf("%d %s %d %s\n",
								dto.getNum(), dto.getName(), 
								dto.getAge(), dto.getLoc());*/
		
		MemDTO dto=dao.one(26);
		System.out.printf("%d %s %d %s\n",
				dto.getNum(), dto.getName(), 
				dto.getAge(), dto.getLoc());
		
		System.out.println("count:"+dao.countMethod());

	}//end main()

}//end class
