package java0712_static_access;
/*
 * 접근제어자(access modifier) 사용목적
 * 1 외부의 접근을 제한하기 위해서이다.
 * 2 외부로 부터 자원을 감추기 위해서이다.(은폐화,캡슐화)
 * 
 * 은폐화(encapsulation) 정의방법
 * 1 멤버변수의 접근제어자는 모두 private으로 지정한다.
 * 2 외부로 부터 멤버변수에 값을 할당하기 위한 setter메소드를 정의한다.
 * 3 setter메소드 정의방법
 *   - 접근제어자는 public으로 지정한다.
 *   - 리턴 타입은 void으로 지정한다.
 *   - 메소드명은 set으로 시작하고 멤버변수의 첫글자만 대문자로 지정하고 나머지는 같게 한다.
 *   ex) private int num;
 *       public void setNum(int num){
 *        this.num=num;
 *       }
 * 4 외부에 멤버변수의 값을 제공할때는 getter메소드를 이용한다.
 * 5 getter메소드 정의방법
 *   - 접근제어자는 public으로 지정한다.
 *   - 리턴타입은 멤버변수의 데이터 타입하고 같게한다.
 *   - 메소드명은 get으로 시작하고 멤버변수의 첫글자만 대문자로 지정하고 나머지는 같게 한다.
 *   ex) public int getNum(){
 *       return num;
 *       }
 */

class Time{
	private int hour;
	private int minute;
	private int second;
	public Time(){
		
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
	
	
}

public class Java085_encapsulation {

	public static void main(String[] args) {
		Time tt=new Time();
		tt.setHour(14);
		tt.setMinute(49);
		tt.setSecond(30);
		
		System.out.printf("%d:%d:%d\n",tt.getHour(),tt.getMinute(),tt.getSecond());
		

	}//end main()

}//end class
