package java0727_inner_thread;

class OuterStatic{
	private int x;
	static private int y;
	static void call(){
		y=9;
		//x=3; 메모리에 생성된 시점이 다르므로 오류발생
	}
	static class InnerStatic{
		int z;
		void prn(){
			//static 내부클래스에서는 외부클래스의 비-static자원을 호출할 수 없다.
			//x=10;
			y=20;
			z=30;
			System.out.println(y);
		}
	}
}

public class Java189_Inner {

	public static void main(String[] args) {
		OuterStatic.call();
		OuterStatic.InnerStatic inner=new OuterStatic.InnerStatic();
		inner.prn();
	}// end main()

}// end class
