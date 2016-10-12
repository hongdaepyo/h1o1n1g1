package java0722_stream_collection;

import java.util.Vector;

/*
 * 배열: length
 * 문자열: length()
 * 컬렉션: size() 
 */
public class Java172_collection {

	public static void main(String[] args) {
		//Vector 생성자에 인자값이 없으면 용량의 기본값은 10이다.
		Vector<String> v=new Vector<String>();
		v.addElement(new String("java"));
		
		//Vector 생성자 인자값이 하나이면 최초 생성될 용량의 값이다.
		//용량의 증가는 2배이다.
		v=new Vector<String>(2);
		v.addElement(new String("seoul"));
		v.addElement(new String("busan"));
		v.addElement(new String("inchon"));
		
		//Vector 생성자의 첫번째 인자값은 최초로 생성되는 용량의 값이고
		//두번째 인자값은 증가되는 값이다.
		v=new Vector<String>(2,1);
		v.addElement(new String("홍길동"));
		v.addElement(new String("영순이"));
		v.addElement(new String("갑돌이"));
		
		v=new Vector<String>();
		v.addElement(new String("apple"));
		//필요없는 메모리 공간을 제거한다.
		v.trimToSize();
		
		//capacity( ): 벡터의 용량 리턴(메모리에 요소를 저장할 수 있는 크기)
		System.out.println("용량:"+v.capacity());
		//size( ):벡터에 저장된 요소 갯수
		System.out.println("크기:"+v.size());

	}//end main()

}//end class
