package java0708_method;

public class Java055_method {

	public static void main(String[] args) {
		int data = 10;
		boolean res = process(data);
		if (res)
			System.out.printf("%d는(은) 짝수입니다.\n",data);
		else
			System.out.printf("%d는(은) 홀수입니다.\n",data);

	}//end main()
	
	public static boolean process(int data){
		// data매개변수의 깞이 짝수이면 true,
		// 홀수이면 false를 리턴하는 프로그램을 구현하세요.
		
		if(data%2==0)
		   return true;
		else
		   return false;
			
	}

}//end class
