package java0715_abstract_interface;

public class Java104_casting {

	public static void main(String[] args) {
		int a=10;
		double b=a;//묵시적 형변환
		
		byte c=(byte)a;//명시적 형변환
		
		display(10,20);
		
		prn((int)1.5f,(int)2.5f);

	}//end main()

	public static void display(double x, double y){
		System.out.printf("x=%.1f y=%.1f\n",x,y);
	}//end display()
	
	public static void prn(int x, int y){
		System.out.printf("x=%d y=%d\n",x,y);
	}//end prn()
}//end class
