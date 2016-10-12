package java0705_basic_operator;

/*
 * 자바에서 문자를 표현하기 위해 유니코드를 사용한다.
 * '0' => 48
 * 'a' => 97
 * 'A' => 65
 */
public class java006_casting {

	public static void main(String[] args) {
		char data='a';
		int asc=data;
		System.out.println(asc);
		
		//data-32의 결과 리턴 데이터타입은 int이다.
		char alpaUpper=(char)(data-32);
		System.out.println(alpaUpper);
		
		short num=128;
		//명시적형변환을 할때 값의 범위에 주의한다.
		byte one=(byte)num;
		System.out.println(one);

	}//end main()

}//end class
