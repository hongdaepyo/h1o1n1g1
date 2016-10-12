package java0706_statement;

/*
 * 다중 if~else
 * if(조건식1){
 *  수행할 문장;
 *  }else if(조건식2){
 *   수행할 문장;
 *   }else if(조건식3){
 *    수행할 문장;
 *    }else{
 *    수행할 문장;
 *    }
 */

public class Java020_if {

	public static void main(String[] args) {
		char code='B';
		if(code=='A'){
			System.out.println("식품류");
		}else if(code=='B'){
			System.out.println("육류");
		}else if(code=='C'){
			System.out.println("야채류");
		}else{
			System.out.println("기타");
		}
		
		System.out.println("마트 코드 분류");
		

	}//end main()

}//end class
