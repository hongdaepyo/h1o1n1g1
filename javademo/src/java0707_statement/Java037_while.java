package java0707_statement;

public class Java037_while {

	public static void main(String[] args) {
		int cnt=1;
		while(true){
			//while문은 조건식을 생략할 수 없다.
			System.out.println(cnt++);
			if(cnt==6)
				break;
		}
		
	}//end main()

}//end class
