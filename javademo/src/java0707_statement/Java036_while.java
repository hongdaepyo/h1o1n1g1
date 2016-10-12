package java0707_statement;
/*
 * while(조건식){
 * 수행할문장;
 * }
 * 
 */
public class Java036_while {

	public static void main(String[] args) {
		for(int i=1;i<=5;i++){
			System.out.println("////");
		}
		
		int j=1;
		while(j<=5){
			System.out.println(j);
			j++;
		}
		
		System.out.println();
		int k=0;
		while(k++<=5){
		/*while(++k<=5) 증감부터
		  while(k++<=5) 비교부터
		 */
			System.out.println(k);
		}
	}//end main()

}//end class
