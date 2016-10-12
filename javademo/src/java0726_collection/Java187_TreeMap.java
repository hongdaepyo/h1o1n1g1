package java0726_collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/*
 * TreeMap
 * 1 Map 인터페이스를 구현한 클래스
 * 2 정렬을 제공해주는 클래스
 */
public class Java187_TreeMap {

	public static void main(String[] args) {
		TreeMap<Integer, String> tree=new TreeMap<Integer, String>();
		tree.put(10, "java");
		tree.put(30, "jsp");
		tree.put(20, "spring");
		
		Set<Integer> set=tree.keySet();
		Iterator<Integer> ite=set.iterator();
		while(ite.hasNext()){
			Integer key=ite.next();
			System.out.printf("%d:%s\n",key,tree.get(key));
		}
		
	}//end main()

}//end class
