package java0719_api;

import java.util.Scanner;

public class Java135_Scanner {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("이름입력:");
		
		//nextLine()메소드를 만나면 대기상태가 되며
		//사용자가 데이터를 입력하고 Enter를 하면
		//nextLine()메소드에서 읽는다.
		String name=sc.nextLine();
		
		System.out.print("연봉: ");
		int salary=sc.nextInt();
		
		System.out.print("평가: ");
		double avg=sc.nextDouble();
		System.out.printf("%s %d %.1f\n",name,salary,avg);
		

	}//end main()

}//end class
