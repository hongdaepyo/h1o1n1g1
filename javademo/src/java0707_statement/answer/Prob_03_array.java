package java0707_statement.answer;

/*
 * 배열에 저장된 요소의 갯수만큼 문자를 출력하는 프로그램을 구현하시오.
 * 출력결과
 * @@@
 * @@
 * @@@@@
 * @@@@@@
 * @
 */

public class Prob_03_array {

	public static void main(String[] args) {
		int num[]=new int[]{3,2,5,6,1};
		
		//여기를 구현하시오
		for(int index=0; index<num.length;index++){
			//System.out.println(num[index]);
			for(int cnt=1;cnt<=num[index];cnt++){
				System.out.print("@");
			}
			System.out.println();
		};
	}//end main()

}//end class
