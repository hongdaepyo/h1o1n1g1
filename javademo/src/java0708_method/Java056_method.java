package java0708_method;

public class Java056_method {
	static char[] data = new char[] {'j','A','v','a'};

	public static void main(String[] args) {
		System.out.println("문자열의 길이:"+length());
		System.out.println("2인덱스의 요소값 가져오기:"+charAt(2));
		

	}//end main()
	
	public static int length() {
		//data 배열의 크기를 리턴하는 프로그램을 구현하세요.
		
		return data.length;
	}
	
	public static char charAt(int index){
		//data 배열에서 index에 해당하는 문자를 리턴하는 프로그램을 구현하세요.
		
		return data[index];
	}

}//end class
