package java0719_api;

import java.util.StringTokenizer;

public class Java129_StringTokenizer {

	public static void main(String[] args) {
		//구분자가 연속적으로 입력되어 있으면 두번째 구분자부터는 무시를 한다.
		StringTokenizer st=new StringTokenizer("java,,jsp/spring", ",/");
		System.out.println("countToken:"+st.countTokens()); //3
		while(st.hasMoreTokens())
			System.out.println(st.nextToken());
		
		System.out.println("///////////////////////////");
		//무조건 구분자 갯수만큼 문자열을 나눈다.
		String[] data="java,,jsp/spring".split("[,/]"); //4
		System.out.println("countToken:"+data.length);
		for(String ss:data)
			System.out.println(ss);

	}//end main()

}//end class
