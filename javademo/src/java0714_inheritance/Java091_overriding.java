package java0714_inheritance;

/*
 * PetOver을 상속받은 DogOver, BirdOver클래스를
 *  main()메소드처럼 구현했을 때 아래와 같이 출력이 되도록
 *  구현하시오.
 *  
 * [출력결과]
 * 슈퍼클래스 move() : 애완동물이 움직입니다.
 * 서브클래스 move() : 새가 날아갑니다.
 */

class PetOver {
	int age; // 애완동물 개월수

	public void move() {
		System.out.println("슈퍼클래스 move() : 애완동물이 움직입니다.");
	}
}

class DogOver extends PetOver{
	
}

class BirdOver extends PetOver{
	@Override
	public void move() {
		System.out.println("서브클래스 move() : 새가 날아갑니다.");
	}
}

public class Java091_overriding {

	public static void main(String[] args) {
		
		DogOver dog1 = new DogOver();
		BirdOver bird1 = new BirdOver();
		dog1.move();
		bird1.move();
		

	}//end main()

}//end class
