package java0804_jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java0804_jdbc.dto.DepartmentsDTO;
import java0804_jdbc.dto.EmployeesDTO;
import java0804_jdbc.dto.LocationsDTO;

public class JoinDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static JoinDAO dao=new JoinDAO();
	private JoinDAO(){
		
	}
	public static JoinDAO getInstance(){
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
	
	public ArrayList<EmployeesDTO> listMethod(){
		ArrayList<EmployeesDTO> aList=new ArrayList<EmployeesDTO>();
		try {
			conn=init();
			stmt=conn.createStatement();
			String sql="select e.employee_id, e.first_name, e.salary,"+
					"d.department_id, d.department_name,"+
					"l.location_id, l.city"+
					" from employees e, departments d, locations l"+
					" where e.department_id=d.department_id"+
					" and d.location_id=l.location_id";
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				EmployeesDTO edto=new EmployeesDTO();
				edto.setEmployee_id(rs.getInt("employee_id"));
				edto.setFirst_name(rs.getString("first_name"));
				edto.setSalary(rs.getInt("salary"));
				DepartmentsDTO mdto=new DepartmentsDTO();
				mdto.setDepartment_id(rs.getInt("department_id"));
				mdto.setDepartment_name(rs.getString("department_name"));
				edto.setMdto(mdto);
				LocationsDTO ldto=new LocationsDTO();
				ldto.setLocation_id(rs.getInt("location_id"));
				ldto.setCity(rs.getString("city"));
				edto.setLdto(ldto);
				aList.add(edto);
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
