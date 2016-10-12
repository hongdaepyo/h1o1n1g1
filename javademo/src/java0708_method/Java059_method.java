package java0708_method;

public class Java059_method {

	public static int total(int toeic, int it) {
		// 두 매개변수의 합계를 계산하여 리턴한다.

		return toeic + it;
	}

	public static String rs(int tot) { // tot=815
		// 총점이 800이상이면 합격, 미만이면 불합격
		if (tot >= 800)
			return "합격";
		else
			return "불합격";

	}

	public static void main(String[] args) {
		int toeic = 750, it = 65;

		System.out.println("입사총점:" + total(toeic, it) + "점");
		System.out.println("입사결과:" + rs(total(toeic, it)) + "입니다");

	}// end main()

}// end class
