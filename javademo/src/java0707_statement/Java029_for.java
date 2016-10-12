package java0707_statement;

public class Java029_for {

	public static void main(String[] args) {
		int sum = 0;
		int i;
		//for문에서 조건식을 생략할때는 종료되는 값을 정확히 모를때 생략한다.
		for (i = 1;; i++) {
			sum += i;
			if (sum >= 30) {
				break; //현재 수행중인 반복문을 빠져나온다.
			}

		}
		System.out.printf("i=%d sum=%d\n", i, sum);
	}// end main()

}// end class
