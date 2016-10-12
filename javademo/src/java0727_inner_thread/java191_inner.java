package java0727_inner_thread;
/*
 * 익명클래스: 특정 위치에서만 사용하기 위해
 */
abstract class InnerAnonymous{
	abstract void prn();
}//end InnerAnonymous

class OuterAnonymous{
	private int x;
	public void call(){
		InnerAnonymous tt=new InnerAnonymous(){
			@Override
			void prn() {
				x=5;
				System.out.println(x);
			}
		};
		tt.prn();
	}//end call()
}//end OuterAnonymous

public class java191_inner {

	public static void main(String[] args) {
		OuterAnonymous outer=new OuterAnonymous();
		outer.call();
		

	}//end main()

}//end class
