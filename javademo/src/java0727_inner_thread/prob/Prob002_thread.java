package java0727_inner_thread.prob;
/*
 * [문제2] Thread객체를 생성한후 다음과 같이 출력하시오

클래스명 : KoreanThread
클래스명 : EnglishLowerThread
클래스명 : EnglishUpperThread
클래스명 : Prob002_thread.java
		       EnglishLowerThread t1=new EnglishLowerThread();
			   EnglishUpperThread t2=new EnglishUpperThread();
			   KoreanThread t3=new KoreanThread();
	   
	           -- 사용자가 나머지 구현하시오--   
	           
[조건]	     
각각 데이타는 배열에 저장한후 사용한다

[출력화면]	 
abcdefghijklmnopqrstuvwxyz
ABCDEFGHIJKLMNOPQRSTUVWXYZ
ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ
 */
class KoreanThread extends Thread{
	String str=new String("ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ");
	public KoreanThread() {

	}
	@Override
	public void run() {
		for(int i=0;i<str.length();i++){
			try {
				char ko=str.charAt(i);
				System.out.print(ko);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println();
		
		
	}
}//end KoreanThread
class EnglishLowerThread extends Thread{
	String str2=new String("abcdefghijklmnopqrstuvwxyz");
	public EnglishLowerThread() {
		
	}
	@Override
	public void run() {
		
		for(int i=0;i<str2.length();i++){
			try {
				char el=str2.charAt(i);
				System.out.print(el);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
		
		
	}
	
}//end EnglishLowerThread
class EnglishUpperThread extends Thread{
	String str3=new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	public EnglishUpperThread() {
		
	}
	@Override
	public void run() {
		for(int i=0;i<str3.length();i++){
			try {
				char eu=str3.charAt(i);
				System.out.print(eu);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println();
	}
	
}//end EnglishUpperThread
public class Prob002_thread {

	public static void main(String[] args) {
		EnglishLowerThread t1=new EnglishLowerThread();
		   EnglishUpperThread t2=new EnglishUpperThread();
		   KoreanThread t3=new KoreanThread();
		   
		   t1.start();
		   try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   t2.start();
		   try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   t3.start();
		   try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end main()

}//end class
