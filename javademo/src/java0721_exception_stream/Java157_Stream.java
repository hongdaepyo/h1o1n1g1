package java0721_exception_stream;


import java.util.Scanner;

public class Java157_Stream {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 0;
		int y = 0;

		System.out.print("x:");
		//x = Integer.parseInt(sc.nextLine());
		x=sc.nextInt();
		System.out.print("y:");
		//y = Integer.parseInt(sc.nextLine());
		y=sc.nextInt();
		System.out.printf("x+y=%d\n", x + y);

		sc.close();

	}//end main()

}//end class
