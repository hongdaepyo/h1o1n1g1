package java0712_static_access;

class MeTest{
	
	private MeTest(){
		System.out.println("private");
	}
	
	MeTest(int a){
		System.out.println(a);
	}
}//end class

public class Java083_access {

	public static void main(String[] args) {
		//MeTest()생성자의 접근제어자(access modifier)가
		//선언되어 있기 때문에 외부클래스에서 호출할 수 없다.
		//MeTest mt=new MeTest();
		
		MeTest ms=new MeTest(10);

	}//end main()

}//end class
