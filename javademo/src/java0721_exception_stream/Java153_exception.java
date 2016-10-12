package java0721_exception_stream;

/*
 * 사용자(프로그래머)가 예외클래스를 만들 수 있도록 제공이 되는데
 * 이때 java.lang.Exception을 상속받아 구현한다.
 */

class User extends Exception {
	public User(String message) {
		super(message);
	}
}// end User

public class Java153_exception {

	public static void main(String[] args) {
		int num = 9;
		try {
			if (num < 10 || num > 99)
				throw new User("2자리만 입력하세요.");

			System.out.println(num);
		} catch (User ex) {
			System.out.println(ex.toString());
		}

	}// end main()

}// end class
