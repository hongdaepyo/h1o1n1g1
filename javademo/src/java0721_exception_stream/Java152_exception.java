package java0721_exception_stream;

//throw : 강제적으로 예외를 발생시킬때 사용한다.
public class Java152_exception {

	public static void main(String[] args) {
		int num = 9;
		process(num);

	}// end main()

	public static void process(int data) {
		try {
			if (data < 10)
				throw new ArithmeticException("10이상만 입력하세요");
			System.out.println(data);
		} catch (ArithmeticException ex) {
			System.out.println(ex.toString());
		}
	}// end process()
}// end class
