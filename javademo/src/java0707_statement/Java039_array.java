package java0707_statement;

//같은 타입의 데이터들을 묶어서 관리하려고
//new는 배열을 생성하기 위해서 사용이 되는 키워드다

public class Java039_array {

	public static void main(String[] args) {
		/*int ko=90;
		int en=80;
		int jp=40;
		*/
		int[] jumsu=new int[3];
		/*
		 * new: 힙 메모리에 배열을 생성해주는 키워드이다.
		 * 배열에 저장된 값을 요소(element)라 한다.
		 * 배열은 생성될때 요소에 접근할 수 있도록 인덱스가 제공된다.
		 * (인덱스는 0부터 시작한다.)
		 * 
		 * 배열의 크기를 리턴해주는 키워드는 length 이다.
		 * length()는 메소드
		 */
		for(int i=0;i<jumsu.length;i++){
			System.out.printf("jumsu[%d]=%d\n",i,jumsu[i]);
		}
		jumsu[0]=90;
		jumsu[1]=80;
		jumsu[2]=40;
		for(int i=0;i<3;i++){
			System.out.printf("jumsu[%d]=%d\n",i,jumsu[i]);
		}
		
		String data = "java";
		System.out.println("문자열길이:"+data.length());

	}// end main()

}// end class
