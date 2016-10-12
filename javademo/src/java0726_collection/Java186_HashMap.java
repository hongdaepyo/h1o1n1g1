package java0726_collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 * HashMap
 * 1 Map인터페이스를 구현한 클래스
 * 2 Hashtable은 동기화 처리이고, HashMap은 비동기화 처리한다.
 * 3 Hashtable과 HashMap의 다른 기능들은 똑같다.
 */

public class Java186_HashMap {

	public static void main(String[] args) {
		//      키 유형,    데이터유형
		/*HashMap<Integer, String> map=new HashMap<Integer,String>();
		map.put(1, "ko");
		map.put(2, "jp");
		map.put(3, "ca");*/
		
		HashMap<Integer, Number> map=new HashMap<Integer,Number>();
		map.put(1,new Integer(10));
		map.put(2,new Double(4.5));
		map.put(3,new Float(2.3f));
		
		System.out.println(map.get(2));
		
		Set<Integer> set=map.keySet();
		Iterator<Integer> ite=set.iterator();
		while(ite.hasNext()){
			Integer key=ite.next();
			System.out.printf("%d:%s\n",key,map.get(key));
		}

	}//end main()

}//end class
