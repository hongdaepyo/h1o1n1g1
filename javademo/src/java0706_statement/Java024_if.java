package java0706_statement;

/*
 * switch(식){
 *   case 값1 : 문장1; break;
 *   case 값2 : 문장2; break;
 *   case 값3 : 문장3; break;
 *   default : 문장4;
 * }
 * 
 * 식의 결과리턴타입 : byte, short, int,  char, enum(7버전부터),String(7버전부터)
 * 
 * switch~case에서 break을 만나면 현재 수행중인 조건문을 완전히 빠져나와
 *   다음문장을 수행한다.
 */

public class Java024_if {

	public static void main(String[] args) {
		int jumsu = 100;
		char res;
		switch (jumsu / 10) {
		//break;가 없으면 다음 케이스의 문장수행
		case 10:
		case 9:
			res = 'A';
			break;
		case 8:
			res = 'B';
			break;
		case 7:
			res = 'C';
			break;
		case 6:
			res = 'D';
			break;
		default:
			res = 'F';
		}

		System.out.printf("%d점수는 %c학점입니다.\n", jumsu, res);

	}// end main()

}// end class
