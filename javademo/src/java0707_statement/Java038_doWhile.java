package java0707_statement;
/*
 * do{
 *    수행할 문장;
 *    }while(조건식);
 */

public class Java038_doWhile {

	public static void main(String[] args) {
		   char chk='y';
		do{
			System.out.println("주문하시겠습니까?(y/n)");
		}while(chk=='z');

	}//end main()

}//end class
