package java0711_method;
/*
 * 메뉴 데이터
 * 떡볶이 2000 1인분 =>3
 * 김말이 500  1개  =>2
 * 오뎅   300  1개  =>4
 * 
 * 출력결과
 * 메뉴:떡볶이
 * 가격: 2000    
 * 지불금액: 6000
 *  
 * 메뉴:김말이
 * 가격:500
 * 지불금액:1000
 * 
 * 메뉴:오뎅
 * 가격:300
 * 지불금액:1200
 */

class MenuShop {
	String menu; // 메뉴명
	int price; // 가격
	int per; // 개수, 인분

//생성자 만들기: 단축메뉴 -> source -> Generator constructor using fields...
	public MenuShop(String menu, int price, int per) {
		this.menu = menu;
		this.price = price;
		this.per = per;
	}

	int count() {
		// 지불금액을 구현하시오
		return price * per;
	}

	void prn() {
		// 출력결과와 같이 로직을 구현하시오.
		System.out.println("메뉴:" + menu);
		System.out.println("가격:" + price);
		System.out.println("지불금액:" + count());

	}

}// end class

public class Java065_class {

	public static void main(String[] args) {
		
		/* MenuShop ms = new MenuShop();
		 ms.menu = "떡볶이"; ms.price = 2000;
		 ms.per = 3; ms.prn();
		 
		MenuShop mh=new MenuShop(); 
		mh.menu="김말이"; mh.price=500; mh.per=2;
		 mh.prn();
		  
		 MenuShop mp=new MenuShop();
		 mp.menu="오뎅"; mp.price=300; mp.per=4;
		 mp.prn();*/
		 
		 
		//아래 생성자가 정상적으로 실행이 되도록 생성자를 추가하세요		
		 MenuShop ms = new MenuShop("떡볶이",2000,3);
		 ms.prn();
		 
		 MenuShop mh=new MenuShop("김말이",500,2);
		 mh.prn();
		 
		 MenuShop mp=new MenuShop("오뎅",300,4);
		 mp.prn();
		 
	}//end main()

}//end class


