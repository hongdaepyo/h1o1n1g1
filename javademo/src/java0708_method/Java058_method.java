package java0708_method;

public class Java058_method {
	static char[] arr={'j','a','v','a',' ','t','e','s','t'};

	public static void main(String[] args) {
		
		System.out.println(reverse(arr));
		System.out.println(process());

	}//end main()
	
	public static int[] process(){
		return new int[]{1,2,3};
	}
	
	public static char[] reverse(char[] data){
		//data의 요소 앞뒤를 바꿔서 리턴하는 프로그램을 구현하세요.
		
		char[] num =new char[data.length];
		for(int i=0;i<data.length;i++){
			num[i] = data[data.length-1-i];}
				
		return num;
		
	}//end reverse()

}//end class
