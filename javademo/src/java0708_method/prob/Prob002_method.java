package java0708_method.prob;

/* 
 *  [출력결과]
 * 	 35276은 숫자입니다.
 * 	 2_8a은 문자입니다.
 */
public class Prob002_method {
	public static void main(String[] args) {
		System.out.print("35276은 ");
		prnDisplay(numCheck("3"));

		System.out.print("2_8a은 ");
		prnDisplay(numCheck("2_8a"));
	}// end main()

	public static boolean numCheck(String data) { // 35a2243
		// data값이 숫자면 true 아니면 false을 반환하는 로직 구현
		
		
		
		
		return false;
	}// end numCheck()

	public static void prnDisplay(boolean chk) {
		// chk값이 true이면 "숫자입니다."
		// chk값이 false이면 "문자입니다." 로 출력하는 로직구현
		if(chk==true){
			System.out.println("숫자입니다.");
		}else{
			System.out.println("문자입니다.");
		}
		

	}// end prnDisplay()

}// end class
