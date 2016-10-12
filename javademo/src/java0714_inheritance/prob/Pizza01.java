package java0714_inheritance.prob;
/*
 * Pizza 클래스를 상속 받아 PizzaTopping 클래스를 만든다.
 * Pizza클래스에서 setPrice메소드를 구현하여
 * 불고기피자는 8000원, 포테이토 피자 6000원, 나머지 피자는 5000원을 리턴하게 한다 
 * PizzaTopping 생성자에는 수량을 추가하여 피자의 총가격 getTotalPrice()을 호출받아 나타낸다
 * 
 * [출력결과]
 * 
 * 홍길동께 배달이 시작되었습니다
 * 피자:포테이토  수량:3
 * 총 주문금액은: 18000
 */



//재료 
class Pizza{
	String name;
	String type;
	int price;
	
	public Pizza() {
	
	}
	
	public Pizza(String name, String type) {
		this.name=name;
		this.type=type;
		setPrice(type);
	}
	public void setPrice(String type){
		if(type=="불고기"){
			price= 8000;
		}
		else if(type=="포테이토"){
			price= 6000;
		}
		else {
			price= 5000;
		} 
	}
	
}

class PizzaTopping extends Pizza{
	int qty;
	
	public PizzaTopping(String name, String type, int qty ) {
		super(name, type);
		this.qty=qty;
		order();
	}
	
	public int getTotalPrice(){
		return price*qty; 
		
	}

	private void delivery(){
		System.out.println(name+"께 배달이 시작되었습니다");
	}
	
	public void order(){
		delivery();
		System.out.println("피자:"+type+ "  수량:"+qty);
		
	}
	
	public void total(){
		System.out.println("총 주문금액은: "+price*qty);
	}
}

public class Pizza01 {

	public static void main(String[] args) {
		
		PizzaTopping pt=new PizzaTopping("홍길동","포테이토",3);
		pt.total();
	}
	
}
