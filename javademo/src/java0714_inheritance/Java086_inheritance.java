package java0714_inheritance;

/*
 * 상속(inheritance)
 * 1 기존의 클래스를 재사용해서 새로운 클래스를 정의하는 것이다.
 * 2 두 클래스를 조상과 자손으로 관계를 맺어주는 것
 * 3 상속를 해주는 클래스 : 부모클래스, 수퍼클래스, 기본클래스
 *   상속을 받는 클래스 :  자손클래스,  서브클래스, 유도클래스
 * 4  자손은 조상의 모든 자원을 상속받는다(생성자, 초기화블럭 제외:static( )) 
 * 5  자손의 자원은 부모보다 크거나 같아야 한다.
 * 6  상속을 할때 사용되는 키워드 : extends
 * 
 * extends
 * 1 단일상속만 가능하다.(클래스에 클래스를 상속할때만)
 * 
 * class A{ }
 * class B extends A{}
 * 상속관계의 클래스를 is a관계라 한다.
 * B는 A이다
 * 
 * class 도형{}
 * class 삼각형 extends 도형{}
 *  삼각형은 도형이다.
 *  //////////////////
 *  class Test{  }
 *  
 *  class Sample{
 *    static void main(String[] args){
 *      Test tt=new Test();
 *     }
 *  }
 *  
 *  Sample은 Test을 포함한다. (has is)(포함된 관계)
 *  
 */

class Father{
	int a=3;
	void prn(){
		System.out.println("a="+a);
	}
}//end Father class

//Child클래스는 Father 클래스를 상속받는다.(Child는 Father이다.)
class Child extends Father{
	int b=5;
}//end Child class


public class Java086_inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child cd=new Child();
		cd.prn();
		System.out.println("b="+cd.b);
	}//end main()

}//end class
