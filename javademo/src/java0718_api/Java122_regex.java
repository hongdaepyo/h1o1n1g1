package java0718_api;
/*
 * 정규식(Regular Expression)
 * 1 정규식이란 텍스트 테이터 중에서 원하는 조건(패턴)과 일치하는 문자열을 
 *   찾아내기 위해 사용하는 것으로 미리 정의된 기호와 문자를 이용해서 작성한
 *   문자열을 말한다.
 * 
 */
public class Java122_regex {

	public static void main(String[] args) {
		String sn="java korea";
		String sg="";
		String st="java     korea";
		
		//sn변수에 저장된 문자열에서 'a' or 'r'이면 '_'로 변경해서 sg변수에 저장하고
		//나머지는 그대로 사용한다.
		for(int i=0; i<sn.length();i++){
			if(sn.charAt(i)=='a'||sn.charAt(i)=='r')
			sg+='_';
			else
				sg+=sn.charAt(i);
		}
		System.out.println(sg);
		
		System.out.println("regular expression을 이용한 문자변경");
		//[]대괄호는 or을 의미.
		
		//sn변수에 저장된 문자열에서 a이거나 r이면 "_"로 변경한다.
		System.out.println(sn.replaceAll("[ar]", "_"));
		
		//sn변수에 저장된 문자열에서 a이거나 r이 포함되면 true 아니면 false을 리턴한다.
		System.out.println(sn.matches(".*[ar].*"));
		
		//{2,3} 2개부터 3개까지의 공백을 "@"으로 나타낸다.
		System.out.println(st.replaceAll("\\s{2,3}", "@"));

	}//end main()

}//end class
