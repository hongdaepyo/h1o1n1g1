package java0726_collection.prob;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/*
 * LinkedList
 * 1 List : 순서적으로 데이터를 저장
 * 2 Stack : LIFO
 * 3 Queue : FIFO
 */

public class Prob001_LinkedList {

	public static void main(String[] args) {
		/*
		 * booklist.txt파일의 데이터를 Stack으로 처리하여 출력되도록 
		 * 프로그램을 구현하시오.
		 *  title             	publisher   writer     price
		 	JSP Programming  	JSPPub     JSPExpert   21000
			Servlet Programming WeBBest 	GoodName	 20000
			JDBC Programming 	JDBCBest 	NaDo SQL 	30000
			SQL Fundmental 		SQLBest		 Na SQL 	47000
			Java Programming 	JavaBest	 Kim kava	 25000
		 */
		
		File file =new File(".\\src\\java0726_collection\\prob\\booklist.txt");
		Scanner sc=null;
		Book bk=null;
		LinkedList<Book> list =new LinkedList<Book>();
		try {
			sc=new Scanner(file);
			int i=0;
			while(sc.hasNextLine()){
				String[] st=sc.nextLine().split("/");
				if(st[i].length()>0)
				list.push(new Book(st[0],st[1],st[2],st[3]));
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("title               publisher  writer    price");
			while(!list.isEmpty()){
				bk=list.pop();
				System.out.printf("%-20s%-11s%-10s%5s\n",
						bk.getTitle(),bk.getPublisher(),bk.getWriter(),bk.getPrice());
			}
			sc.close();
		}
		
	
	}//end main()

}//end class











