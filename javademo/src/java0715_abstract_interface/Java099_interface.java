package java0715_abstract_interface;

import java.io.Serializable;

//Ctrl + shift + O


/*
 * 인터페이스(interface)
 * 1 추상메소드와 상수만 가지고 있는 형태이다.
 * 2 클래스 작성에 도움을 줄 목적으로  제공이 되는 표준 명세서이다.
 * 3 implements : 클래스에 인터페이스를 상속할때 사용되는 키워드이다.
 * 4 인터페이스는 다중상속이 된다.
 * 5 인터페이스는 접근제어자로 public, protected만 제공된다.
 *   default로 선언된 멤버변수,메소드는 컴파일러에서 public으로 처리한다.
 * 6 인터페이스에서는 추상메소드에 abstract키워드는 명시 하지 않으면
 *   컴파일러가 abstract키워드를 붙여 처리한다.
 */
interface CarRun{
	int car_count=0; //public static final, final이 붙어서 상수가 되기 때문에 반드시 값을 할당
	void work(); //public abstract
}

class TrunkRun implements CarRun, Serializable{

	@Override
	public void work() {
		System.out.println("트럭이 짐을 싣고 있다.");
	}
	
}//end TrunkRun

public class Java099_interface {

	public static void main(String[] args) {
		//인터페이스는 객체생성을 할 수 없다.
		//CarRun cr=new CarRun();
		TrunkRun tr=new TrunkRun();
		tr.work();
	}//end main()

}//end class
