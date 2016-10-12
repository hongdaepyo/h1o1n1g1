package java0721_exception_stream;

import java.util.Scanner;

public class Java158_stream {
		public static void main(String[] args){
			
			Scanner sc=new Scanner(System.in);
			String name="";
			int x=0;
			int y=0;
			double key=0.0;
			System.out.print("데이터 입력 name x y key:");
			name=sc.next();
			x=sc.nextInt();
			y=sc.nextInt();
			key=sc.nextDouble();
			
			System.out.printf("%s %d %d %.1f\n",name, x,y, key);
			
			sc.close();
			
		}//end main()

}//end class
