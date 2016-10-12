package java0714_inheritance;
/*
 * 오버라이딩(overriding)
 * 1 조상클래스의 메소드를 자손클래스에서 재정의(메소드의 구현부) 하는 기능이다.
 * 2 메소드의 선언부는 그대로 사용한다.(리턴타입, 매개변수, 이름)
 *   단 접근제어자는 같거나 크면된다.
 *      private<default<protected<public
 *      
 *      
 * super
 * 1. 자손 클래스에서 조상클래스를 호출할때 사용한다.
 * 2. super.멤버변수
 *    super.메소드( )
 *    super( )=>생성자
 *    
 */

class First {
	int a = 10;

	public void prn() {
		System.out.println("a=" + a);
	}
}// end First class

class Second extends First {
	int b = 20;

	@Override
	public void prn() {
		System.out.println("b=" + b);
	}
	
	public void call(){
		super.prn();
		this.prn();
	}
}// end Second class

public class Java090_overriding {

	public static void main(String[] args) {
		Second ss = new Second();
		//ss.prn();
		ss.call();
		

	}// end main()

}// end class
