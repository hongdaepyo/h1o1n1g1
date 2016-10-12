package java0708_method;
/*
 * 자바에서 제공하는 데이터 타입
 * 1 기본 데이터 타입 : byte, short, int, long,
 *                 float, dobule, boolean, char
 * 2 참조 데이터 타입 : 배열, 클래스, 인터페이스
 * 
 * [인자전달방식]
 * 1 call by value-값복사
 *    인자값을 전달할때 기본 데이터 타입을 넘겨주는 형식이다.
 * 2 call by reference-주소복사
 *    인자값을 전달할때 참조 데이터 타입을 넘겨주는 형식이다.
 */
public class Java052_method {

	public static void main(String[] args) {
		int a=10, b=20;
		callByValue(a, b);
		System.out.printf("a=%d, b=%d\n",a,b);

	}//end main()
	
	public static void callByValue(int x, int y){
		int temp;
		temp=x;
		x=y;
		y=temp;
		System.out.printf("x=%d, y=%d\n",x,y);
	}

}//end class
