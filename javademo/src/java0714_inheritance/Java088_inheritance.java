package java0714_inheritance;

class SuperConst {
	int x;
	int y;

	public SuperConst(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.printf("x=%d y=%d\n", x, y);
	}

}// end SuperConst class

class SubConst extends SuperConst {
	// 기본생성자의 접근제어자는 클래스의 접근제어자를 따른다.
	SubConst() {
		super(10, 20);
	}

}// end SubConst class

public class Java088_inheritance {

	public static void main(String[] args) {
		SubConst sc = new SubConst();

	}
}
