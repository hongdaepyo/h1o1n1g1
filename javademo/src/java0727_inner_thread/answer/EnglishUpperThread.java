package java0727_inner_thread.answer;

public class EnglishUpperThread extends Thread {
	
	char[] arr={'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
	          'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	

	@Override
	public  void run(){
		for(char ch : arr){
			System.out.print(ch);
			try {
				sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
