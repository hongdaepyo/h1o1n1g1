package java0705_basic_operator.prob;

/*
 * 동전교환프로그램
 * 1 가장적은 동전으로 교환할 수 있는 프로그램작성하시오
 * 2 [출력결과]
 *   500원: 15개
     100원: 2개
     50원: 1개
     10원: 2개
     1원: 7개
     
     System.out.printf("500원:%d개\n", mok);
     money=money%500; //money %=500;
     mok=money/100;
     System.out.printf("100원:%d개\n", mok);
     money=money%100
     mok=money/50
     System.out.printf("50원:%d개\n", mok);
     money=money%50;
     mok=money/10;
     System.out.printf("10원:%d개\n", mok);
     money=money%10;
     mok=money/1;
     System.out.printf("1원:%d개\n", mok);
     
     
 */

public class Prob0705_05 {

	public static void main(String[] args) {
		int money = 7777;
		int mok=money/500;
		
		//여기에 작성하시오
		System.out.println("500원:"+  mok+"개");
		money -=500*mok;
		mok = money/100;
		System.out.println("100원:"+  mok+"개");
		money -=100*mok;
		mok = money/50;
		System.out.println("50원:"+  mok+"개");
		money -= 50*mok;
		mok = money/10;
		System.out.println("10원:"+  mok+"개");
		money -= 10*mok;
		mok = money/1;
		System.out.println("1원:"+  mok+"개");
		
		
		
		
	}//end main()

}//end class



