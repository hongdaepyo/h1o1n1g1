package java0804_jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java0804_jdbc.dto.EmpDTO;

public class EmpDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static EmpDAO dao=new EmpDAO();
	
	private EmpDAO(){
		
	}
	
	public static EmpDAO getInstance(){
		return dao;
	}
	
	public ArrayList<EmpDTO> searchMethod(String str){
		ArrayList<EmpDTO> aList=new ArrayList<EmpDTO>();
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin://@127.0.0.1:1521:xe";
			String username="hr";
			String password="a1234";
			conn=DriverManager.getConnection(url, username, password);
			String sql="select employee_id, first_name, salary, hire_date from employees where lower(first_name) like ? order by employee_id";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+str.toLowerCase()+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				EmpDTO dto=new EmpDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setSalary(rs.getInt("salary"));
				dto.setHire_date(rs.getDate("hire_date"));
				aList.add(dto);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		
		return aList;
	}//end listMethod()
	

}//end class
