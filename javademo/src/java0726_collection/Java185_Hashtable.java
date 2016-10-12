package java0726_collection;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/*
 * Hashtable
 * 1. Map인터페이스를 구현해놓은 클래스
 * 2. Map이터페이스를 구현해놓은 클래스들은 key, value쌍으로 저장한다.
 * 3. value을 구분해주는 것은 key이므로 key은 중복이 되면 안된다.
 */
public class Java185_Hashtable {

	public static void main(String[] args) {
		Hashtable<Integer, String> table=new Hashtable<Integer, String>();
		table.put(10, "java");
		table.put(20, "jsp");
		table.put(30, "spring");
		
		System.out.println(table.get(20));
		/*
		 * Enumeration(열거형) : Vector, Hashtable에서만 제공한다.
		 * Iterator(반복자) : Vector
		 * Hashtable외에 다른 컬렉션에서도 Enumeration와 같은 기능을 제공할 수 있도록 제공해줬다.
		 * 
		 */
		System.out.println("Enumeration====================================");
		//          키의타입
		Enumeration<Integer> enu=table.keys(); //키가져옴
		while(enu.hasMoreElements()){
			Integer key=enu.nextElement();
			System.out.printf("%d:%s\n",key,table.get(key));
		}
		
		System.out.println("Iterator=========================================");
		Set<Integer> set=table.keySet();
		Iterator<Integer> ite=set.iterator();
		while(ite.hasNext()){
			Integer ig=ite.next();
			System.out.printf("%d:%s\n",ig,table.get(ig));
		}
		

	}//end main()

}//end class
