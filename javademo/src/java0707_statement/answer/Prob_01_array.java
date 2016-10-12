package java0707_statement.answer;
/*
 * 4행 4열 data배열에 가로 세로 합계를 구하는 프로그램을 구현하시오.
 * [출력결과]
 *  1   2   3   6
 *  4   5   6  15
 *  7   8   9  24
 * 12  15  18  45
 */

public class Prob_01_array {

	public static void main(String[] args) {
		int[][] data = new int[4][4];
		int cnt = 1;
		// 여기를 구현하시오.
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// data[i][3]+=cnt;
				data[i][j] = cnt++;
				data[i][3] += data[i][j]; // 각 행의 누적
				data[3][j] += data[i][j]; // 각 열의 누적
				data[3][3] += data[i][j]; // 전체 누적
			}

		}

	}// end main()

}// end class
