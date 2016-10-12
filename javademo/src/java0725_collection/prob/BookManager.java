package java0725_collection.prob;

import java.util.ArrayList;

public class BookManager {
	public static int getRentalPrice(ArrayList<BookDTO> bookList, String kind) {
		// 구현하세요.
		//bookList.add(new BookDTO("Java Programming", "컴퓨터", 1400));
		/*ArrayList<BookDTO> bd = new ArrayList<>();
		int total=0;
		for(int i=0;i<bookList.size();i++){
			String[] arr=new String[bookList.size()];
			bookList.toArray(arr);*/
		int data=0;
		for(BookDTO dto:bookList){
			//private이라서 get메소드로 가져옴
			if(dto.getKind()==kind){
				data+=dto.getRentalPrice();
			}
		}
		
		return data;
	}//end getRentalPrice()
}//end class






