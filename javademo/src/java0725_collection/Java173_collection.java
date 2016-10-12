package java0725_collection;

import java.util.Vector;

public class Java173_collection {

	public static void main(String[] args) {
		//제너릭을 적어주면 꺼내올때 다운캐스팅을 해주지 않아도됨.
		Vector<Integer> v=new Vector<Integer>();
		v.add(new Integer(10));//추가
		v.add(new Integer(20));
		v.add(new Integer(30));
		
		//1인덱스의 요소가 제거된다.
		v.remove(1);
		
		//0인덱스에 40요소를 삽입한다.
		v.add(0,new Integer(40));//삽입
		
		for(Integer it:v)
			System.out.println(it);

	}//end main()

}//end class
