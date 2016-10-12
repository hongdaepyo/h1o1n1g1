package java0718_api;

/*
 * [출력결과]
 *  java jsp spring
 */
public class Java120_String {

	public static void main(String[] args) {
		String stn = new String("java_jsp_spring");
		System.out.println(process(stn.toCharArray()));
	}// end main()

	public static char[] process(char arr[]) {
		// '_'를 ' '으로 변환후 반환하는 로직구현
		/*char[] data = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
			if (arr[i] == '_') {
				data[i] = ' ';
			}
		}*/
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '_') {
				arr[i] = ' ';
			}
		}
		return arr;
		
	}// end process()

}// end class
