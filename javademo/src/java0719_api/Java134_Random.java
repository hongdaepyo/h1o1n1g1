package java0719_api;

import java.util.Random;

public class Java134_Random {

	public static void main(String[] args) {
		Random ran = new Random();
		int[] num = new int[6];
		// 1부터10까지의 정수값을 num배열에 저장
		for (int i = 0; i < num.length; i++) {
			num[i] = ran.nextInt(10) + 1;
			//중복체크를 위한 반복문
			for (int j = 0; j < i; j++) {
				if (num[i] == num[j]) {
					i--;
					break;
				}
			}
		}
		for (int data : num)
			System.out.println(data);

	}// end main()

}// end class
