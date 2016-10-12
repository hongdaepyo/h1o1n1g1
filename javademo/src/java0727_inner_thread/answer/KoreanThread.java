package java0727_inner_thread.answer;

public class KoreanThread extends Thread{
	char[] arr={'ㄱ','ㄴ','ㄷ','ㄹ','ㅁ','ㅂ','ㅅ','ㅇ','ㅈ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
	
	@Override
	public void run(){
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
