package java0708_method;

/*
 * method(메소드) 정의
 * 1 값을 계산하기 위해서 사용되는 기능이다.
 * 2 객체의 동작을 처리하기 위한 기능이다.
 * 
 * method(메소드) 구조 : 메소드 선언부+메소드 구현부
 * 리턴타입 메소드명(데이터타입 매개변수 ){
 *    메소드가 처리해야할 조직을 구현 ;
 *    return 값;   
 * }
 * 리턴값이 없으면 리턴 타입에 void 적어줌.
 * 1. 리턴값이 없고 매개변수도 없다.
 * void add( ){
 *   int x=10;
 *   int y=20;
 *   System.out.println(x+y);
 * }
 * 
 * 2. 리턴값이 없고 매개변수는 있다.
 *  void plus(int x, int y){
 *   System.out.println(x+y);
 *  }
 *  
 * 3. 리턴값은 있으나 매개변수는 없다.
 *   double avg( ){
 *      int total=15;
 *      return total/3.0;
 *    }
 * 4. 리턴값도 있고 매개변수도 있다.
 *   double avg(int x, int y){
 *   return (x+y)/2.0;
 *   }
 */


public class Java048_method {

	//프로그램을 실행하면 JVM에서 main()스레드가 main()메소드를 호출한다.
	public static void main(String[] args) {
		makeTest();
		add();
		
		
	}//end main()
	public static void makeTest(){
		System.out.println("makeTest run");
	}//end makeTest()
	public static void add(){
		int x=10;
		int y=20;
		System.out.println(x+y);
	}//end add()

}//end class











