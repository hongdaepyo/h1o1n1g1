package java0719_api;


public class Java126_StringBuffer {

	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("java test");
		
		//4인덱스에 ",jsp"문자열을 삽입한다.
		sb.insert(4, ",jsp"); //java,jsp test
		System.out.println(sb);
		
		//4인덱스부터 8미만 사이의 문자열을 삭제한다.
		sb.delete(4, 8); //java test
		System.out.println(sb);
		
		//0인덱스의 문자를 삭제한다.
		sb.deleteCharAt(0); //ava test
		System.out.println(sb);
		
		//" sample" 문자열을 추가한다.
		sb.append(" sample");//ava test sample
		System.out.println(sb);
		
		//문자열을 반대로 변경해서 리턴한다.
		sb.reverse();//elpmas tset ava
		System.out.println(sb);
		
		String data="mybatis orm";
		StringBuffer ss=new StringBuffer(data);
		ss.reverse();
		System.out.println(ss);
		
		//char 배열을 String으로 바꾸어서 사용
		char[] arr=new char[]{'k','o','r','e','a'};
		String sn=new String(arr);
		StringBuffer sf=new StringBuffer(sn);
		sf.reverse();
		System.out.println(sf);

	}//end main()

}//end class
