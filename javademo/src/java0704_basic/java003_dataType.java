package java0704_basic;

//주석 : 코드에 대한 설명을 의미한다.
//한라인에 대한 주석 처리

/*
     여러 라인에 대한 주석
 */

/*
 * 자바에서 제공하는 데이터타입
 * 1 기본데이터 타입 (소문자)
 *   숫자:정수 =>byte(1byte), short(2byte), int(4byte), long(8byte) 
 *   	 실수 =>float(4byte), double(8byte)
 *   문자: char(2byte)
 *   논리: boolean(1byte)
 * 2 참조 데이터 타입
 *   배열, 클래스, 인터페이스
 * 
 * 시스템에서 인식하는 데이터 타입의 크기
 * byte < short, char < int < long < float < double
 */

public class java003_dataType {

	public static void main(String[] args) {
		//변수 : 하나의 값을 저장하기 위한 메모리 공간
		int num = 10;
		
		//data변수에 젖아할 수 있는 값의 데이터 타입은 int이므로
		//double 타입인 3.5은 data 변수에 저장 할 수 없다.
		//int data = 3.5;
		
		// byte 범위 -128 ~ 127
		
		//long 타입인 숫자는 뒤에 L 붙임
		//float 타입 숫자는 뒤에 F 붙임
		byte check=127;
		// short 범위 -32768 ~ 32767
		short kt=127;
		int kn=127;
		long ko=43L;
		float avg=4.5F;
		double sum=9.3;
	    char alpa='a';
	    boolean is=true;
	    //변수 선언으로 메모리 확보하고 나중에 변수불러와서 수정
	    is=false;                                                                                      
	    
		
	}

}





