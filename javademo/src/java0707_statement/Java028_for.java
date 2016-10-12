package java0707_statement;

/*
 * for(초기식; 조건식; 증감식){
 *    수행할 문장;
 * }
 * 
 * 1. 조건식이 false일때 까지 반복문을 실행한다.
 * 2. for문 실행순서
 *    초기식 -> 조건식(true) ->수행할 문장 -> 증감식
 *          -> 조건식(true) ->수행할 문장 -> 증감식
 *          -> 조건식(false) -> for문을 빠져나옴
 * 3. 초기식은 한번만 수행한다.
 * 4. 초기식, 조건식, 증감식을 생략할 수 있다. for(;;){} 세미콜론 필수
 *    단 자리는 확보해 줘야 한다.
 * 5. 초기식, 증감식은 생략이나 여러식을 사용할 수 있다.
 * 6. 조건식을 생략하면 true로 인식한다.         
 */

public class Java028_for {

	public static void main(String[] args) {
		
		for(int num=1;num<=5;num++){
			System.out.println(num);
		}

	}//end main()

}//end class
