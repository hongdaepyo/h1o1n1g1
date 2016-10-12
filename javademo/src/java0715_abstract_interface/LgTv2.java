package java0715_abstract_interface;

public class LgTv2 implements Tv {
	public String toMessage(){
		return "GOLD";
	}
	
	public void turnOn() {
		System.out.println("LG TV -전원을 켠다.");
	}

	public void turnOff() {
		System.out.println("LG TV-전원을 끈다.");
	}

	public void soundUp() {
		System.out.println("LG TV-소리를 높인다.");
	}

	public void soundDown() {
		System.out.println("LG TV-소리를 줄인다.");
	}
}// end class
