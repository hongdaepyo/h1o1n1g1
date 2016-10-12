package java0722_stream_collection;

import java.util.Vector;

/*
 * 컬렉션 클래스을 선언하고 생성할 때 제너릭을 선언한다. 
 * 제너릭(generic):클렉션 클래스에 저장된 객체를 가져올때
 * 다운캐스팅하는 작업을 생략할 수 있도록 제공해주는 기능이다.
 */
public class Java170_collection {

	public static void main(String[] args) {
		Vector<Integer> v=new Vector<Integer>();
		v.addElement(new Integer(100));
		v.addElement(new Integer(200));
		
		Integer t1=v.get(0);
		System.out.println(t1);
		Integer t2=v.get(1);
		System.out.println(t2);
		
		System.out.println("//일반 반복문////////////////////////////////");
		for(int i=0; i<v.size();i++)
			System.out.println(v.get(i));
		
		System.out.println("//개선된 반복문////////////////////////////////");
		//for(데이터 타입 변수 : 배열, 컬렉션){}
		for(Integer it:v)
			System.out.println(it);
		
		System.out.println("/////////////////////////////////////////");
		
		Vector<Number> vt=new Vector<Number>();
		vt.addElement(new Integer(10));
		vt.addElement(new Double(10.4));
		vt.addElement(new Float(4.8F));
		
		for(Number nb : vt)
			System.out.println(nb);
		

	}//end main()

}//end class
