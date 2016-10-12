package java0715_abstract_interface;

public class Java108_binding {

	public static void main(String[] args) {
		Object obj=new Object();
		System.out.println(obj.toString());
		
		String stn=new String("java");
		System.out.println(stn.toString());
		
		obj=stn;
		System.out.println(obj.toString());

	}//end main()

}//end class
