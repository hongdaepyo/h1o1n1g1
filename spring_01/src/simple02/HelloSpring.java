package simple02;

public class HelloSpring {
/*
 *  인터페이스를 이용해 결합도를 남춤
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageBean bean=new MessageBeanKorea();
		bean.sayHello("스프링");
		
		bean=new MessageBeanEnglish();
		bean.sayHello("Spring");

	}//end main()

}//end class
