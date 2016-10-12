package java0718_api;
/*
 * [출력결과]
 * aerok
 */
public class Java118_String {

	public static void main(String[] args) {
		String sn ="korea";
		char[] data = display(sn);
		System.out.println(data);

	}//end main()
	
	public static char[] display(String alpa){
		//alpa매개변수에 저장된 문자열을 reverse한후 반환하는
		//프로그램을 구현하세요.
		char[] arr = new char[alpa.length()];
		for(int i=0;i<alpa.length();i++){
		arr[i]=alpa.charAt(alpa.length()-1-i);
		}
		return arr;
		
	}

}//end class
