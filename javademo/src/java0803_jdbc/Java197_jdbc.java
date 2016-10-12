package java0803_jdbc;
/*
 * 1.ClassNotFoundException 
 *  해결)JRE System Library에서 ojdbc14.jar파일 확인
 *  
 * 2.java.sql.SQLException: IO 예외 상황: The Network Adapter ... 
 *   Listener refused....
 *   제어판->관리도구->서비스->OracleServiceXE 하고 OracleXETNSListener을 시작한다. 
 * 
 * 3. java.sql.SQLException: ORA-XXXX
 *   쿼리문을 확인
 *   
 */
import java.util.ArrayList;

public class Java197_jdbc {
	
	public static void main(String[] args){
		DepartmentDAO dao=new DepartmentDAO();
		ArrayList<DepartmentDTO> aList = dao.listMethod();
		for(int i=0;i<aList.size();i++){
			DepartmentDTO dto=aList.get(i);
			//int department_id=dto.getDepartment_id();
		    System.out.printf("%d %s %d %d\n",
		    		dto.getDepartment_id(),
		    		dto.getDepartment_name(),
		    		dto.getManager_id(),
		    		dto.getLocation_id());
		}
		
	}//end main()

}//end class
