package java0712_static_access;

//import 외부클래스의 위치를 알려주기 위해서 사용
import java.util.Scanner;
import java.awt.Frame;
/*
 * package 패키지명;
 * import 패키지명.클래스명;
 * import 패키지명.인터페이스명;
 * 
 * class 클래스명{
 *   static{ } : 클래스가 메모리에 로딩되는 시점에 멤버변수의 값을 할당한다.
 *   멤버변수 : 객체의 특징
 *   생성자 : 멤버변수에 초기값 할당
 *   메소드 : 객체의 동작-객체가 가지고 있는 값을 이용해서 계산하는 기능이다
 * }
 * 
 * package : 
 * 1 비슷한 작업을 수행하는 클래스 및 인터페이스를 묶어줄때 사용한다.
 * 2 open API에서 제공하는 클래스 및 인터페이스명의 중복을 피하기 위해서 사용한다.
 *    domain : www.naver.com
 *    package : com.naver.클래스명(인터페이스명);
 * 
 * 접근제어자 (access modifier)
 * 접근 범위 크기 순서: private < default < protected < public
 *  : 멤버 또는 클래스에 사용되어, 외부로부터의 접근을 제한한다.
 *  1 private : 같은 클래스내에서만 접근이 가능하다.
 *  2 default : 같은 패키지내에서만 접근이 가능하다.
 *  3 protected : 같은 패키지내에서, 그리고 다른 패키지의 자손클래스에서 접근이가능하다.
 *  4 public  : 접근 제한이 없다.
 *  
 *  클래스 : default, public 사용가능하다.
 *  변수, 생성자, 메소드 : private, default, protected, public사용가능하다.
 */

public class Java080_access {

	private int var_private = 1;
	int var_default = 2;
	protected int var_protected = 3;
	public int var_public = 4;

}// end class
