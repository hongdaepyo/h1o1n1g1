package java0712_static_access.prob;

/* 0.04로 변동된 금리로 출력이 되도록 main( )메소드에 로직을
 * 추가하세요.
 * 
 * [출력결고]
** 입금 당시의 금리 **
1994	kim		1000	0.07
1997	lee		1000	0.12
2005	park	1000	0.05

** 2005년 현재의 금리 **
1994	kim		1000	0.05
1997	lee	 	1000	0.05
2005	park	1000	0.05

** 0.04로 변동된 금리 **
1994	kim		1000	0.04
1997	lee		1000	0.04
2005	park	1000	0.04

 */
class BankAccount {
	private int year;
	private String name;
	private int money;
	private static double rate;
	
	public BankAccount(int year, String name, int money, double r) {
		this.year = year;
		this.name = name;
		this.money = money;
		rate=r;
	}
	public static void setRate(double r){
		//유효성검사
		if(r < 0.02 || r > 0.12){
			System.out.println("금리 좀 확인 하시고 입력하시죠!!");
			System.exit(0);
		}
		rate=r;
	}
	public void view(){
		System.out.println(year+"\t"+name+"\t"+money+"\t"+rate);
	}
}//end class
public class Prob002_static_access {

	public static void main(String[] args) {
		System.out.println("** 입금 당시의 금리 **");
		BankAccount ba1=new BankAccount(1994, "kim", 1000, 0.07);	ba1.view();
		BankAccount ba2=new BankAccount(1997, "lee", 1000, 0.12);	ba2.view();
		BankAccount ba3=new BankAccount(2005, "park", 1000, 0.05);	ba3.view();
		
		System.out.println("\n** 2005년 현재의 금리 **");
		ba1.view();
		ba2.view();
		ba3.view();
		
		System.out.println("\n** 0.04로 변동된 금리 **");
        //여기에서 구현하세요./////////////////////////////////
		//ba1.setRate(0.04);
		BankAccount.setRate(0.04);
		ba1.view();
		ba2.view();
		ba3.view();
		//////////////////////////////////////////////////
       
	}//end main()

}//end class
