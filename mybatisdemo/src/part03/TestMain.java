package part03;

import java.util.List;

import part03.dao.EmpDeptDao;
import part03.dto.DeptDTO;
import part03.dto.EmpDTO;

public class TestMain {

	public static void main(String[] args) {
		EmpDeptDao dao = new EmpDeptDao();
		/*
		 * List<EmpDTO> aList=dao.allMethod(); for(EmpDTO dto: aList)
		 * System.out.printf("%s %s %s %s\n", dto.getEmployee_id(),
		 * dto.getFirst_name(), dto.getJob_id(), dto.getDepartment_id());
		 */

		/*
		 * List<EmpDTO> alist=dao.emp_deptMethod(); for(EmpDTO dto: alist)
		 * System.out.printf("%s %s %s %s %s\n", dto.getEmployee_id(),
		 * dto.getFirst_name(), dto.getJob_id(), dto.getDepartment_id(),
		 * dto.getDept().getDepartment_name());
		 */

		/*List<DeptDTO> aList = dao.dept_empMethod();
		for (DeptDTO dto : aList) {
			for (EmpDTO edto : dto.getEmp()) {
				System.out.printf("%s %s %s %s\n", dto.getDepartment_id(), dto.getDepartment_name(), edto.getEmployee_id(), edto.getFirst_name());
			}
		}*/
		
		List<EmpDTO> aList=dao.partMethod();
		for(EmpDTO dto: aList)
			 System.out.printf("%s %s %s %s\n", dto.getEmployee_id(),
			 dto.getFirst_name(), dto.getJob_id(), dto.getDepartment_id());
		

	}// end main()

}// end class
