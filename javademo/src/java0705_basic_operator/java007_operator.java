package java0705_basic_operator;
/*
 * 연산자(operator)
 * 어떠한 기능을 수행하는 기호(+,-, *,/,%, >, <,==, !=....)
 * 
 * 피연산자(operand)
 * 연산자의 작업 대상(변수, 상수, 리터널, 수식)
 * 
 * 연산자 종류
 * 1 산술연산자 : +, -, *, /, %
 * 2 비교연산자 : >, <, >=, <=, !=, ==
 * 3 논리연산자 : &&(and), ||(or), !(not)
 * 4 삼항연산자(조건연산자) : 조건식?참:거짓
 * 5 대입연산자 : =, +=, -=, *=, /=....
 * 6 단항연산자 : ++(1씩증가),--(1씩감소)
 */
public class java007_operator {

	public static void main(String[] args) {
		int numX=10;
		int numY=5;
		
		//int=int+int
		int res=numX+numY;
		
		short numA=3;
		short numB=5;
		//int데이터 타입 이하끼리 연산하면 결과는 int데이터 타입이다.
		int data=numA+numB;
		
		//다른 데이터 타입끼리 연산이 되면 결과 데이터 타입은 큰 데이터 타입이다.
		//int=short+int
		int pk=numA+numX;
		
		byte ma=2;
		
		//int=byte+short;
		int pn=ma+numA;
		

	}//end main()

}//end class












