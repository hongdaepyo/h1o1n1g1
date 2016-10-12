package java0805_jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import java0805_jdbc.dto.EmployeesDTO;

public class EmployeesDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static EmployeesDAO dao=new EmployeesDAO();
	
	private EmployeesDAO() {
		
	}
	
	public static EmployeesDAO getInstance(){
		return dao;
	}
	
	private Connection init() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url="jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username="hr";
		String password="a1234";
		return DriverManager.getConnection(url, username, password);
		
	}//end init()
	
	private void stop(){
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(pstmt!=null)
			try {
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}//end stop()
	
	public ArrayList<EmployeesDTO> listMethod(String search){
		ArrayList<EmployeesDTO> aList = new ArrayList<EmployeesDTO>();
		try {
			conn=init();
			String sql="select employee_id, first_name, salary, department_id from employees where lower(first_name) like ? order by employee_id";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search.toLowerCase()+"%");
			rs=pstmt.executeQuery();
			while(rs.next()){
				EmployeesDTO dto=new EmployeesDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setSalary(rs.getInt("salary"));
				dto.setDepartment_id(rs.getInt("department_id"));
				aList.add(dto);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			stop();
		}
		
		return aList;
	}//end listMethod()


}//end class
