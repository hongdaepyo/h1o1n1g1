package java0705_basic_operator;

/*
 * 연산자 우선순위
 * 단항연산자 > 산술연산자 > 비교연산자 > 논리연산자 > 삼항연산자 > 대입연산자
 */
public class Java015_operator {

	public static void main(String[] args) {
		int a = 10;
		int b = 3;
		int c = 5;

		int res = (a > b) && (a == b) ? a + b : a - b;
		System.out.println(res);

	}// end main()

}// end class
