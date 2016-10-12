package java0705_basic_operator;
/*
 * 변수: 하나의 값을 저장하기 위한 공간이다.
 * 상수: 한 번만 값을 저장할 수 있는 공간이다.
 * 리터널: 그 자체로 값을 의미한다.
 */
public class java004_value {

	public static void main(String[] args) {
		int data=10;
		final int NUM=20;
		// 상수 표현할 때는 final, 상수는 대문자로 하는게 관례
		data=50;
		//상수에는 새로운 값을 할당할 수 없다.
		//NUM=60;
		
	}//end main()
}//end class
