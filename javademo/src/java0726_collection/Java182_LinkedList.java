package java0726_collection;

import java.util.LinkedList;

/*
 * 큐 (Queue)
 * 1 FIFO(First In First Out):제일 먼저 저장한 것을 제일 먼저 꺼내게 된다.
 * 2 최근 사용문서, 인쇄작업대기목록, 버퍼
 */
public class Java182_LinkedList {

	public static void main(String[] args) {
		LinkedList<String> nList=new LinkedList<String>();
		//추가
		nList.offer(new String("java"));
		nList.offer(new String("jsp"));
		nList.offer(new String("spring"));
		
		while(!nList.isEmpty())
		System.out.println(nList.poll());
		

	}//end main()

}//end class
