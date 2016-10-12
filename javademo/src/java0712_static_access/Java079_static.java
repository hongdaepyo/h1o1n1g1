package java0712_static_access;

class staticTest{
	
	int x;
	int y;
	static int k;
	static int m;
	
	public static void process(int a, int b){
		/*
		 * x,y멤버변수가 비-static이므로 static이 선언된 process()메소드에서
		 * 호출할 수 없다.
		 * x=a;
		 * y=b;*/
		k=a;
		m=b;
	}
	
}//end class

public class Java079_static {

	public static void main(String[] args) {
		

	}//end main()

}//end class
