package java0707_statement;

public class Java034_for {

	public static void main(String[] args) {
		int cnt=1;
		int sum=0;
		for(int row=1; row<=5; row++){
			//sum=0;
			for(int col=1; col<=5; col++){
				sum+=cnt;
				System.out.printf("%d\t",cnt++);
				
			}
			System.out.println(sum);
			sum=0;
		}

	}//end main()

}//end class
