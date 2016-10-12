package java0718_api;

public class Java114_String {

	public static void main(String[] args) {
		String sn="java";
		String sg="java";
		String st= new String("java");
		String ss= new String("java");
		
		//==주소비교
		System.out.printf("sn==sg:%b\n",sn==sg);
		System.out.printf("st==ss:%b\n",st==ss);
		
		//equals() : 메모리에 저장된 문자열 비교
		System.out.printf("sn.equals(sg):%b\n",sn.equals(sg));
		System.out.printf("sn.equals(ss):%b\n",st.equals(ss));
		
		//toString() : 메모리에 저장된 문자열 리턴
		System.out.println(sn.toString());
		System.out.println(sn);
		
	}//end main()

}//end class
