package java0720_api.prob;
/*
 * javac Prob001_String.java
 * 					   0번째  1번째 인덱스에 저장
 * java Prob001_String JAva Test
 */

/*1 프로그램 실행할때  "JAva Test" 문자열을 args배열에서 값을 받아 출력결과에 같이
 *  나오도록 프로그램을 구현하시오.
 *  java Prob001_String JAva Test
 *   * 
 * 2 출력결과
 *   source : JAva Test 
 *   convert: jaVA tEST
 *   length: 9
 *   reverse : tseT avAJ
 */

public class Prob001_String {

	public static void main(String[] args) {
		
		System.out.printf("source : %s %s\n", args[0], args[1]);
		char[] arr = new char[args[0].length() + args[1].length() + 1];
		String data = "";
		for (int i = 0; i <= args[0].length(); i++) {
			if (i == args[0].length()) {
				arr[i] = ' ';
				break;
			}
			arr[i] = args[0].charAt(i);
		}

		for (int i = 0; i < args[1].length(); i++) {
			arr[i + args[0].length() + 1] = args[1].charAt(i);
		} // 배열생성

		String data2 = args[0] + " " + args[1];
		StringBuffer ss = new StringBuffer(data2);
		ss.reverse();// 순서반대

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 'a' && arr[i] <= 'z') {
				arr[i] = (char) (arr[i] - 32);
			} else if (arr[i] >= 'A' && arr[i] <= 'Z') {
				arr[i] = (char) (arr[i] + 32);
			}
			data += arr[i];

		} // 대소문자 변환
		System.out.printf("convert: %s\n", data);
		System.out.printf("length : %d\n", arr.length);
		System.out.println("reverse: " + ss);

	}

}// end class
