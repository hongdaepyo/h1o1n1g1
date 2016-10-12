package java0711_method;

/*
 * 칼의 노래             대출중
 * 어두운 상점의 거리    대출가능
 * 
 */
class Book{
	String title;

	String process(boolean state){
		if(state)
			return "대출가능";
		else
			return "대출중";
	}//end process
}//end class

public class Java060_class {

	
	public static void main(String[] args) {
		int data=10;
		// 객체참조변수  생성자
		Book bk=new Book();
		bk.title="칼의 노래";
		System.out.printf("%s %s\n", bk.title, bk.process(false));
		
		Book bn=new Book();
		bn.title="어두운 상점의 거리";
		System.out.printf("%s %s\n", bn.title, bn.process(true));
		

	}//end main()

}//end class
