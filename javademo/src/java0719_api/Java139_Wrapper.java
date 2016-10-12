package java0719_api;

public class Java139_Wrapper {

	public static void main(String[] args) {
		char data='d';
		//대문자
		System.out.println(Character.toUpperCase(data));
		
		//소문자
		System.out.println(Character.isLowerCase(data));
		
		//숫자
		System.out.println(Character.isDigit(data));
		
		//알파벳
		System.out.println(Character.isAlphabetic(data));

	}//end main()

}//end class
