package java0706_statement;
/*
 * case의 값은 정렬을 하지 않아도 되지만 가독성때문에 일반적으로
 *   정렬을 해서 구현을 한다.
 * case의 값에 변수를 사용할 수 없다.(리터널, 상수만 가능하다)
 */
public class Java025_switch {

	public static void main(String[] args) {
		int num = 2;
		final int DATA = 2;
		switch (num) {
		// case 조건에 상수가능
		case 1:
			System.out.println(1);
			break;
		case 3:
			System.out.println(3);
			break;
		case 4:
			System.out.println(4);
			break;
		case DATA:
			System.out.println(2);
			break;
		default:
			System.out.println(5);
			break;
		}

	}// end main()

}// end class
