package java0726_collection;

import java.util.LinkedList;

/*
 * stack(스택)
 * 1. LIFO(Last In First Out): 마지막에 저장된 요소를 먼저 꺼내온다.
 * 2. 수직계산, 수식괄호검사, undo/redo, 뒤로/앞으로
 * 
 * 큐나 스택은 완전히 꺼내옴 get으로 복사해서 가져올수는 있지만 복사해올 목적으로는 stack queue를 쓰진 않는다.
 */

public class Java181_LinkedList {

	public static void main(String[] args) {
		LinkedList<String> nList= new LinkedList<String>();
		nList.push(new String("java"));
		nList.push(new String("jsp"));
		nList.push(new String("spring"));
		
		while(!nList.isEmpty())
		System.out.println(nList.pop());

	}//end main()

}//end class
