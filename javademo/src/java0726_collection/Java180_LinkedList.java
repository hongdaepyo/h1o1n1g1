package java0726_collection;


import java.util.LinkedList;
import java.util.ListIterator;

public class Java180_LinkedList {

	public static void main(String[] args) {
		LinkedList<String> nList=new LinkedList<String>();
		//추가
		nList.add(new String("java"));
		nList.add(new String("jsp"));
		nList.add(new String("spring"));
		
		ListIterator<String> ite=nList.listIterator();
		System.out.println("앞->뒤");
		while(ite.hasNext())
			System.out.println(ite.next());
		
		System.out.println("뒤->앞");
		while(ite.hasPrevious())
			System.out.println(ite.previous());
		

	}//end main()

}//end class
