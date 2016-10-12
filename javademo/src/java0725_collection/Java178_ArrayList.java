package java0725_collection;

import java.util.List;
import java.util.Arrays;

public class Java178_ArrayList {

	public static void main(String[] args) {
		String[] arr={"oracle","mysql","mssql"};
		
		//배열->컬렉션(List)
		List<String> list=Arrays.asList(arr);
		for(String sn:list)
			System.out.println(sn);

	}//end main()

}//end class
