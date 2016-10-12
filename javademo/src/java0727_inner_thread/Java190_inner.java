package java0727_inner_thread;
/*
 * 지역클래스에서 외부클래스 메서드의 매개변수, 지역변수를
 * 호출하기 위해서는 final이 선언되여 있어야 한다.
 * 하지만, jdk8버전부터는 final이 선언되여 있지 않아도 호출이 가능하다.
 */
class OuterLocal{
	private int x;
	static int y;
	final private int z=10;
	
	public void call(final int a){
		final int b=20;
		//final이 붙어야 하는데 자바8부터는 JVM에서 자동으로 붙여줌
		int c=30;
		//메소드 안에선 final이 붙지 않으면 변수로 취급하는데 InnerLocal에서는 상수로 취급
		class InnerLocal{
			void prn(){
				x=5;
				y=150;
				System.out.println("x="+x);
				System.out.println("y="+y);
				System.out.println("z="+z);
				System.out.println("a="+a);
				System.out.println("b="+b);
				System.out.println("c="+c);
			}
		}//end InnerLocal
		
		InnerLocal inner=new InnerLocal();
		inner.prn();
		
	}//end call
}//end OuterLocal

public class Java190_inner {

	public static void main(String[] args) {
		OuterLocal outer=new OuterLocal();
		outer.call(100);
		

	}// end main()

}// end class
