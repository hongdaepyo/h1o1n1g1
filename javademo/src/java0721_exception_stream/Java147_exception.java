package java0721_exception_stream;

public class Java147_exception {

	public static void main(String[] args) {
		int[] arr = new int[3];
		try {
			arr[4] = 10;
			System.out.println(arr[4]);
		} catch (ArrayIndexOutOfBoundsException ex) {
			// 예외 정보
			// System.out.println(ex.getMessage()); //4
			//System.out.println(ex.toString()); //java.lang.ArrayIndexOutOfBoundsException:4
			ex.printStackTrace(); //예외 경로를 추적
			
		} finally {
			System.out.println("program end");
		}
	}// end main()

}// end class
