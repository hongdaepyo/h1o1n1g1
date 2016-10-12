package java0711_method;
/*
 * 생성자(constructor)
 * 1. 멤버변수의 초기화를 위해 한번만 호출된다.
 * 2. 클래스에는 반드시 한개 이상의 생성자가 있어야 한다.
 * 3. 생성자명은 클래스명하고 같다.
 * 4. 생성자는 리턴값이 없다.(void를 쓰지 않는다.) 
 * 5. 클래스에 생성자가 정의되여 있지 않으면 JVM은 기본생성자를 제공한다.
 * 6. 기본생성자의 접근제어자는 클래스의 접근제어자를 따르고 구조는
 *     생성자명( ) { } 이다.
 * 
 * 기본생성자(default constructor)
 * 1 매개변수가 없는 생성자이다. => 생성자명( ) { }
 * 2 클래스에 생성자가 없으면 JVM에서 기본생성자를 추가해 준다.
 * 
 * this : 객체 자신을 의미한다.
 * this.멤버변수
 * this.메소드( )
 * this( ) 
 */

class Product{
	String code;
	String pName;
	int cnt;
	
	//기본제공되는 생성자
	//생성자가 제공되어 있으면 기본생성자는 제공되지 않는다.
	Product(){
	}
	
	Product(String c, String p, int t){
		code =c;
		pName =p;
		cnt =t;
	}
	
	public void prn(){
		System.out.printf("%s %s %d\n",code,pName,cnt);
	}
	
}//end class

public class Java062_constructor {

	public static void main(String[] args) {
		//초기값 null null 0
		Product pt=new Product();
		pt.prn();
		
		//초기값 a001 식품류 2
		Product pd =new Product("a001","식품류",2);
		pd.prn();
		
		Product pp=new Product();
		pp.code="b003";
		pp.pName="육류";
		pp.cnt=10;
		pp.prn();
		

	}//end main()

}//end class
