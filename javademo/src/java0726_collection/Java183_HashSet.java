package java0726_collection;

import java.util.HashSet;

/*
 * HashSet
 * 1 Set인터페이스를 구현한 클래스이다.
 * 2 중복허용안되고, 순서유지 안된다.
 */
public class Java183_HashSet {

	public static void main(String[] args) {
		HashSet<Integer> set=new HashSet<Integer>();
		set.add(new Integer(10));
		set.add(new Integer(20));
		set.add(new Integer(30));
		
		set.add(new Integer(30));
		for(Integer it:set)
			System.out.println(it);
		
		

	}//end main()

}//end class
