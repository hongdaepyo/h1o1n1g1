package java0705_basic_operator;

public class java016_print {

	public static void main(String[] args) {
		//데이터 출력하고 나서 줄바꿈이 일어남
		System.out.println("java");
		//데이터만 출력하고 끝남 \t=탭키 \n=엔터키 %s=문자열 %f=실수 %c=문자
		//System.out.printf("출력형식",값1, 값2, 값3....);
		System.out.print("jsp\t");
		System.out.print("spring\n");
		/*
		 * 출력기호
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %b : 논리
		 * %s : 문자열 |%숫자s 에서 숫자는 자릿수를 의미
		 * %% : %
		 * \ : 키보드에서 지원하는 문자를 표기할때
		 */
		
		System.out.printf("%s님의 평균은 %.1f 이므로 %c 입니다.\n","홍길동",95.0,'A');
		System.out.printf("당신의 색깔은 \"%s\"입니다.\n","빨강");
		System.out.printf("%d %% %d=%d\n",3,2,3%2);
		System.out.printf("%s\n","abcdefghi");
		System.out.printf("%5s\n","ab");
		System.out.printf("%6s\n","자바");
		System.out.printf("%f\n",12345.45);
		System.out.printf("%5.1f\n",12.4);
		
		
		
		

	}//end main()

}//end class
