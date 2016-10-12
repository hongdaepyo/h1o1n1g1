package java0712_static_access;

class OrderStatic {
	
	static{
		System.out.println("static");
	}
	
	public OrderStatic() {
	System.out.println("constructor");
}
	public void prn(){
		System.out.println("prn");
	}
}
public class Java077_static {


	public static void main(String[] args) {
		OrderStatic ss=new OrderStatic();
		ss.prn();

	}//end main()

}//end class
