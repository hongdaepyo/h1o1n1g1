package java0715_abstract_interface;
/* 
 * -(private) +(public) *(protected)
 * class와 interface를 이용하여 성적처리
 * 클래스명 : User
 *  -name:String
 *  +User()
 *  +User(name:String)
 *  +toString():String
 *  
 *  인터페이스명 : Score
 *  +sol:int  (초기값:20)
 *  +getScore():int
 *  
 *  인터페이스명 : Print
 *  +toPaint():String
 *  
 *  [출력화면]
 *  이름 : 홍길동
 *  점수 : 60점
 */
interface Score{
	public int sol =20;
	public int getScore();
}
interface Print{
	public String toPaint();
}
class User{
	private String name;
	public User(){
		
	}
	public User(String name){
		this.name=name;
		
	}
	
	public String toString(){
		return "이름: " + name + "\n";
		
	}
	
}//end User class

class UserTest extends User implements Score,Print{
	int s;
	public UserTest(String name,int num){
		super(name);
		this.s=num;
	}

	@Override
	public String toPaint() {
		return super.toString()+"점수: "+getScore()+"점\n";
	}

	@Override
	public int getScore() {
		return sol*s;
	}
	
	
}
public class Java102_interface {

	public static void main(String[] args) {
		UserTest ut=new UserTest("홍길동",3);
		System.out.println(ut.toPaint());

	}//end main()

}//end class
