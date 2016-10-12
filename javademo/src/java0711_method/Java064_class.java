package java0711_method;

class Rect{
	int width;
	int height;
	
	public Rect() {
		
	}
	
	//사각형의 둘레를 구하는 로직
	int girth(){
		return (width+height)*2;
	}
	
	//사각형의 넓이를 구하는 로직
	int area(){
		return width*height;
	}
}

public class Java064_class {

	public static void main(String[] args) {
		Rect rt=new Rect();
		rt.width=5;
		rt.height=3;
		System.out.println("둘레:"+rt.girth());
		System.out.println("넓이:"+rt.area());		
		

	}//end main()

}//end class
