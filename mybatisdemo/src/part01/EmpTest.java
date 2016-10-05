package part01;

import java.util.HashMap;
import java.util.List;

import part01.dto.EmployeeDTO;

public class EmpTest {

	public static void main(String[] args) {
		EmployeeDAO dao=new EmployeeDAO();
		
		System.out.println("총 레코드수:"+dao.countMethod());
		
		List<EmployeeDTO> list=dao.allMethod();
		
		//List<EmployeeDTO> list=dao.searchMethod("lex");
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		//"lex", 9000
		map.put("first_name", "lex");
		map.put("salary", 9000);
		//List<EmployeeDTO> list=dao.searchMethod(map);
		for(EmployeeDTO dto : list)
			System.out.printf("%s %d %s \n",dto.getFirst_name(), dto.getSalary(), dto.getHire_date());

	}//end main()

}//end class