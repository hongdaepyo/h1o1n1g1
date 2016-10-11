package part08_xml_annotation;

import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		//XML설정 파일에서 @Configuration 어노테이션 클래스사용하기
		ApplicationContext context=new ClassPathXmlApplicationContext("part08_xml_annotation/di.xml");
		Random ran=(Random)context.getBean("ran");
		System.out.println("난수:"+ran.nextDouble());

	}//end main()

}//end class
