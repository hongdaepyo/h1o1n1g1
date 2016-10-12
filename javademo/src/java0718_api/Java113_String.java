package java0718_api;
/*
 * 문자열 관련 클래스
 * java.lang.String
 * java.lang.StringBuffer
 * java.lang.StringBuilder
 * java.util.StringTokenizer
 */

class StringTest{
	private char[] arr;
	public StringTest(){
		
	}
	
	public StringTest(char[] arr){
		this.arr=arr;
	}
	
	public int length(){
		return arr.length;
	}
	
	public char charAt(int index){
		return arr[index];
	}
	
	public boolean isUpper(int index){
		if(arr[index]>='A'&&arr[index]<='Z')
			return true;
		else
			return false;
	}
	
	public boolean isLower(int index){
		if(arr[index]>='a' && arr[index]<='z')
			return true;
		else
			return false;
	}
	
	
	public char[] toData(){
		return arr;
	}
}//end StringTest

public class Java113_String {

	public static void main(String[] args) {
		char[] data={'j','a','v','a'};;
		StringTest st = new StringTest(data);
		System.out.println(st.length());

	}//end main()

}//end class
