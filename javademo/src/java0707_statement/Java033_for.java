package java0707_statement;

public class Java033_for {

	public static void main(String[] args) {
		int cnt=0;
		for(int row=1; row<=3; row++){
			for(int col=1; col<=5; col++){
				System.out.printf("%d\t",++cnt);
			}
			System.out.println();
		}

	}//end main()

}//end class
