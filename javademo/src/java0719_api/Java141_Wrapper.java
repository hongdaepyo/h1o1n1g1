package java0719_api;
/*
 * 이름, 학점을 입력하는 프로그램을 구현하시오.
 * 입력 : 홍길동,80,93
 * 
 * [출력결과]
 * 이름: 홍길동
 * 국어: 80
 * 영어: 93
 * 평균: 86.5 (double로 계산)
 */

import java.util.Scanner;

public class Java141_Wrapper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("입력 :");
		String data=sc.nextLine();
		String[] arr=data.split(",");	
		System.out.println("이름: "+arr[0]);
		System.out.println("국어: "+arr[1]);
		System.out.println("영어: "+arr[2]);
		double avg=(Double.parseDouble(arr[1])+Double.parseDouble(arr[2]))/2;
		System.out.println("평균: "+avg);

	}// end main()

}// end class







