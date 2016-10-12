package java0804_jdbc;

import java.util.ArrayList;
import java.util.Scanner;

import java0804_jdbc.dao.EmpDAO;
import java0804_jdbc.dto.EmpDTO;

public class Java199_jdbc {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("이름을 입력하세요?");
		String word=sc.nextLine();
		
		EmpDAO dao=EmpDAO.getInstance();
		ArrayList<EmpDTO> aList=dao.searchMethod(word);
		for(EmpDTO dto:aList){
			System.out.printf("%d %s %d %s\n",
					dto.getEmployee_id(), dto.getFirst_name(),
					dto.getSalary(),dto.getHire_date());
		}

	}//end main()

}//end class
