package java0804_jdbc;

import java.util.ArrayList;

import java0804_jdbc.dao.JoinDAO;
import java0804_jdbc.dto.EmployeesDTO;


public class Java200_jdbc {

	public static void main(String[] args) {
		JoinDAO dao=JoinDAO.getInstance();
		ArrayList<EmployeesDTO> aList=dao.listMethod();
		for(EmployeesDTO dto:aList){
			System.out.printf("%d %s %d %d %s %d %s\n",
					dto.getEmployee_id(),
					dto.getFirst_name(),
					dto.getSalary(),
					dto.getMdto().getDepartment_id(),
					dto.getMdto().getDepartment_name(),
					dto.getLdto().getLocation_id(),
					dto.getLdto().getCity());
		}

	}//end main()

}//end class
