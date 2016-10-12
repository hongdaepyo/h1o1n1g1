package java0707_statement;

//3의 배수만 제외하고 출력하는 프로그램을 구현하세요.
public class Java032_for {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++){
			//for문에서는 continue;를 만나면 증감식으로 이동된다.
			if(i%3==0){
				//반복문에서만 continue키워드를 사용한다.
				continue;
			}
			System.out.println(i);
		}

	}//end main()

}//end class
