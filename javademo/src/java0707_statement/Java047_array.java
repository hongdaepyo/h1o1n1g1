package java0707_statement;

/*
* num배열에서 아래와 같이 출력이 되도록 프로그램을 구현하시오.
* [출력결과]
* 1   2   *   4   5   
* *   7   8   *  10       
* 11  *  13  14   *
* 16 17   *  19  20
* 
*/

public class Java047_array {

	public static void main(String[] args) {
		int[][] num = new int[4][5];

		int cnt = 1;
		for (int row = 0; row < num.length; row++) {
			for (int col = 0; col < num[row].length; col++) {
				num[row][col] = cnt++;
			}
		}

		for (int row = 0; row < num.length; row++) {
			for (int col = 0; col < num[row].length; col++) {
				{
					if ((num[row][col]) % 3 == 0) {
						System.out.printf("   *");
					} else {
						System.out.printf("%4d", num[row][col]);
					}
				}
			}
			System.out.println();

		}

	}// end main()

}// end class
