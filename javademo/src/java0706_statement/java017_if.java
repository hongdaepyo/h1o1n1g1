package java0706_statement;

public class java017_if {
	/*
	 * 제어문(control statement) : 문장의 흐름을 제어해주는 기능이다. 1 종류 조건문 : if~else,
	 * switch~case 반복문 : for, while, do~while 기타 : break, continue, (label)
	 * 
	 * if (조건식){ 수행할 문장; }else{ 수행할 문장; }
	 * 
	 * java java017_if
	 */
	public static void main(String[] args) {
		int num = 7;
		if (num % 2 == 0) {
			System.out.printf("%d는 %s입니다.\n", num, "짝수");
		} else {
			System.out.printf("%d는 %s입니다.\n", num, "홀수");
		}
		
		System.out.println("program end");

	}// end main()

}// end class
