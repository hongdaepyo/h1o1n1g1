package part02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import part02.dao.MemDao;
import part02.dto.MemDTO;

public class MemTest {

	public static void main(String[] args) {
		MemDao dao = new MemDao();
		
		//dao.insertMethod(new MemDTO("박사랑",30,"평야"));
		//dao.insertMethod(new MemDTO("유대리",20));
		
		//num컬럼의 값이 ? 일때 loc컬럼의 값을 '제주'로 수정d
		/*HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("num", 8);
		map.put("loc", "제주");k
		dao.updateMethod(map);*/
		
		//dao.deleteMethod(8);
		
		/*List<MemDTO> alist=new ArrayList<MemDTO>();
			alist.add(new MemDTO(dao.keyMethod(),"java",20,"toronto"));
			alist.add(new MemDTO(dao.keyMethod(),"jsp",15,"summary"));
			dao.multiInsertMethod(alist);*/
		
		/*List<Integer> alist=new ArrayList<Integer>();
		alist.add(8);
		alist.add(1);
		System.out.println("total 삭제:"+dao.multiDeleteMethod(alist));*/
		
		Integer[] array=new Integer[2];
		array[0]=19;
		array[1]=18;
		System.out.println("total 삭제:"+dao.multiDeleteMethod(array));
		
		List<MemDTO> list=dao.allMethod();
		for(MemDTO dto: list)
			System.out.printf("%d %s %d %s\n", dto.getNum(), dto.getName(), dto.getAge(), dto.getLoc());

	}//end main()

}//end class
