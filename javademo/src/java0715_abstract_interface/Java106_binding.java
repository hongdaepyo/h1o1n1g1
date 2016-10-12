package java0715_abstract_interface;

public class Java106_binding {

	public static void main(String[] args) {
		
		//결합도(의존성)가 높다.
		/*LgTv lg=new LgTv();
		lg.turnOn();
		lg.turnOff();
		
		lg.soundUp();
		lg.soundDown();*/
		
		SamsungTv ss=new SamsungTv();
		ss.turnOn();
		ss.turnOff();
		
		ss.soundUp();
		ss.soundDown();
	}//end main()

}//end class
