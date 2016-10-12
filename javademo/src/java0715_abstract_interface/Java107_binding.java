package java0715_abstract_interface;

public class Java107_binding {

	public static void main(String[] args) {
		
//		Tv tv=new LgTv2();
		Tv tv=new SamsungTv2();
		process(tv);

	}//end main()
	
	public static void process(Tv tv){
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soundUp();
	}

}//end class
