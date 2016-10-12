package sessiondemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MemDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	private static MemDAO dao=new MemDAO();
	
	private MemDAO(){}
	
	public static MemDAO  getInstance(){
		return dao;
	}
	
	private Connection start() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, user, password);
	}//end start()
	
	private void exit() {
		try {			
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if(stmt!=null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end exit()
	
	
	public int memCheck(MemDTO dto){
		int cnt=-1;
		try {
			conn=start();
			String sql = "select count(*) from memtab where id=? and pass=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			rs=pstmt.executeQuery();
			if(rs.next())
				cnt=rs.getInt(1);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			exit();
		}
		
		return cnt;
	}//end memCheck()
	
	

}//end class







