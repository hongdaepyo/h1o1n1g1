package part01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	/*
	 * 컨테이너(container)
	 * 1 BeanFactory - getBean()
	 * 2 ApplicationContext - container가 성생될때
	 * 3 WebApplicationContext - was(Tomcat)가 쉽게  실행했을때 
	 */
	public static void main(String[] args) {
		//xml에 선언해 놓은 bean들을 applicationcontext라는 컨테이너에 담아서 저장한다.
		//컨테이너에 담아 놓은 것을 getBean으로 호출한다.
		/*
		 * part/di.xml에 언급된 빈들을 생성하고 관리해주는 객체를container라 한다.
		 * 현재 사용되고 잇는 container은 ApplicationContext이다.	 */
		ApplicationContext context=new ClassPathXmlApplicationContext("part01/di.xml");
		Service svc=(Service) context.getBean("svc");
		svc.prn();

	}//end main()

}//end class
