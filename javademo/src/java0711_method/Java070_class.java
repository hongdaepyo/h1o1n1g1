package java0711_method;

/*
 * 아래를 참조하여 main()메소드를 추가하는 로직을 구현하세요.
 * 
 * [실행결과]
 * 상품                     가격     상품제고  팔린수량
 * Nikon            400000    30    50
 * Sony             450000    20    35
 * FujiFilm         350000    10    25
 */
class Goods {
	String name;// 상품 이름
	int price;// 상품 가격
	int numberOfStock;// 상품 재고
	int sold;// 팔린 수량 

	Goods(String name, int price, int numberOfStock, int sold) { // 생성자
		this.name = name;
		this.price = price;
		this.numberOfStock = numberOfStock;
		this.sold = sold;
	}

	public void prn() {
		System.out.printf("%-14s %8d %5d %5d\n", name, price, numberOfStock, sold);
	}
}// end class////////////////////////

public class Java070_class {

	public static void main(String[] args) {
		Goods [] goodsArray = new Goods[3];
		
		//여기에서 구현하세요///////////////////////	
		goodsArray[0]=new Goods("Nikon",400000,30,50);
		goodsArray[1]=new Goods("Sony",450000,20,35);
		goodsArray[2]=new Goods("FujiFilm",350000,10,25);
		
		  
	  ///////////////////////////////////
		
		System.out.printf("%-16s %8s %8s %5s\n", "상품", "가격", "상품제고", "팔린수량");
		for(int i=0; i<goodsArray.length;i++){
			goodsArray[i].prn();
		}
		

	}// end main()

}// end class
