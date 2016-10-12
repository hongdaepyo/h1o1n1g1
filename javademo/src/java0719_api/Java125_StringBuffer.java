package java0719_api;
/*
 * java.lang.String : 불변
 * java.lang.StringBuffer : 가변, 비동기화
 * java.lang.StringBuilder : 가변, 동기화
 */
public class Java125_StringBuffer {

	public static void main(String[] args) {
		String sg=new String("java test");
		String ss=sg.replace("java", "jsp");
		System.out.println(sg);
		System.out.println(ss);
		
		System.out.println("///////////////////////");
		StringBuffer sb=new StringBuffer("spring test");
		sb.replace(0, 6, "framwork");
		System.out.println(sb);

	}//end main()

}//end class
