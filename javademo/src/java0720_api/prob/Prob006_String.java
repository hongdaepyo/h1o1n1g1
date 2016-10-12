package java0720_api.prob;

/*
 * [출력결과]
 *  영어 소문자 갯수:3
 *  영어 대문자 갯수:3
 *  숫자 갯수:2
 */

public class Prob006_String {

	public static void main(String[] args) {
		String data = "ke4RdTA5";

		display(process(data));
	}// end main()

	public static char[] process(String data) {
		char[] ca=data.toCharArray();
		
		return ca;
	}// end process()

	public static void display(char[] arr) {
		int counta = 0;
		int countA = 0;
		int countd = 0;
		/*for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 'a' && arr[i] <= 'z') {
				counta++;
			} else if (arr[i] >= 'A' && arr[i] <= 'Z') {
				countA++;
			} else if (arr[i] >= '0' && arr[i] <= '9') {
				countd++;
			}
		}*/
		for(char i:arr){
			if (i >= 'a' && i <= 'z') {
				counta++;
			} else if (i >= 'A' && i <= 'Z') {
				countA++;
			} else if (i >= '0' && i <= '9') {
				countd++;
			}	
		}
		System.out.println("영어 소문자 갯수:" + counta);
		System.out.println("영어 대문자 갯수:" + countA);
		System.out.println("숫자 갯수:" + countd);

	}// end display()

}// end class
