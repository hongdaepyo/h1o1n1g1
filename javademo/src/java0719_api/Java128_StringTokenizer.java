package java0719_api;

import java.util.StringTokenizer;

public class Java128_StringTokenizer {

	public static void main(String[] args) {
		//StringTokenizer(문자열, 구분자)
		//문자열의 구분자가 공백일때는 2번째 인자값은 생략할 수 있다.
		StringTokenizer st=new StringTokenizer("java,jsp", ",");
		System.out.println(st.countTokens());
		
		//nextToken은 메모리에 저장된 토큰을 완전히 꺼내옴
		//i=0,st.countTokens()=2
		//i=1,st.countTokens()=1 => false for문 빠져나옴
		for(int i=0;i<st.countTokens();i++){
			System.out.println(st.nextToken());
		}
		
		//메모리에 저장된 토큰을 가져올 수 있으면 true 아니면 false를 리턴한다.
		while(st.hasMoreTokens())
			//메모리에 저장된 토큰을 가져온다.
			System.out.println(st.nextToken());

	}//end main()

}//end class
