package java0727_inner_thread;

class User2 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int j=0;j<=5;j++)
			System.out.printf("%s j=%d\n",Thread.currentThread().getName(),j);
	}//end run()
}//end User2

public class Java193_Thread {

	public static void main(String[] args) {
		User2 user=new User2();
		//Runnable 인터페이스에는 start()가 없기때문에 Thread 클래스를 활용
		Thread th=new Thread(user);
		th.start();
		
		System.out.println("main thread end");
	}//end main()

}//end class
