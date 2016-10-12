package java0707_statement;

/*
 * 배열은 기본적으로 고정배열다.
 * 2차원 배열부터는 가변배열을 제공한다.
 * 자바에서 가변배열을 제공하는 이유는 메모리 손실을 최소화하기 위해서이다.
 */

public class Java046_array {

	public static void main(String[] args) {
		//가변배열을 생성할때는 제일 마지막의 배열 크기는 지정하지 않는다.
		int[][] num=new int[3][];
		num[0]=new int[2]; //0행의 열의 크기 생성
		num[1]=new int[3]; //1행의 열의 크기 생성
		num[2]=new int[4]; //2행의 열의 크기 생성
		
		int cnt=1;
		for(int row=0;row<num.length;row++){
			for(int col=0;col<num[row].length;col++){
				num[row][col]=cnt++;
			}
		}
		for(int row=0;row<num.length;row++){
			for(int col=0;col<num[row].length;col++){
				System.out.printf("%4d",num[row][col]);
			}
			System.out.println();
		}
		
		

	}//end main()

}//end class
