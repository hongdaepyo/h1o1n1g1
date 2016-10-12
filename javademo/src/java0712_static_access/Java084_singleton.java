package java0712_static_access;
/*
 * 싱글톤 패턴(singleton pattern)
 * 1 객체를 생성할때 마다 같은 형태의 객체를 생성할때 사용한다.
 * 2 방법
 *   - 클래스안에서 자신의 객체를 생성한다.
 *     private static UserCalendar cal=new UserCalendar();
 *   
 *   - public static으로 선언된 메소드에서 생성된 객체를 리턴한다.
 *    public static UserCalendar getInstance(){
	  	return cal;
	   }   
	   
 *   - 생성자의 접근제어자는 private으로 선언한다.
 *     private UserCalendar(){}
 */
class MemberDAO{
	
	private static MemberDAO dao=new MemberDAO();
	private MemberDAO(){}
	
	public static MemberDAO getInstance(){
		return dao;
	}
	
	public void prn(){
		System.out.println("prn");
	}
	
}//end class

public class Java084_singleton {

	public static void main(String[] args) {
		//MemberDAO dd=new MemberDAO();
		//DB접근하기 위해 사용
		MemberDAO md=MemberDAO.getInstance();
		md.prn();

	}//end main()

}//end class
