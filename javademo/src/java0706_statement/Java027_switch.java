package java0706_statement;

//자주색으로 표시되는 것들이 예약어(keyword)

public class Java027_switch {

	public static void main(String[] args) {

		char ope = '1';
		int numX = 10;
		int numY = 5;
		int res = 0;

		switch (ope) {
		case '+':
			res = numX + numY;
			break;
		case '-':
			res = numX - numY;
			break;
		case '*':
			res = numX * numY;
			break;
		case '/':
			res = numX / numY;
			break;
		default:
			System.out.println("사칙연산이 아닙니다.");
			return; //현재 수행중인 메소드를 빠져나온다.
		}
		System.out.printf("%d %c %d = %d\n", numX, ope, numY, res);

	}// end main()

}// end class
