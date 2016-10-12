package picturePreview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;

	private TestDAO() {
	}

	private static TestDAO dao = new TestDAO();

	public static TestDAO getInstance() {
		return dao;
	}

	private Connection start() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, user, password);
	}// end start()

	private void exit() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end exit()
	
	public void insertMethod(String filepath){
		try {
			conn=start();
			String sql="insert into preview values(preview_num_seq.nextval,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, filepath);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			exit();
		}
	}//end insertMethod()
	
	public ArrayList<TestDTO> selectMethod(){
		ArrayList<TestDTO> aList=new ArrayList<TestDTO>();
		
		try {
			conn=start();
			String sql="select * from preview order by num desc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				TestDTO dto=new TestDTO();
				dto.setNum(rs.getInt("num"));
				dto.setFilepath(rs.getString("filepath"));
				aList.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			exit();
		}
		
		return aList;
	}//end selectMethod()
	
	public String imgMethod(int num){
		String filename="";
		try {
			conn=start();
			String sql="select filepath from preview where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next())
				filename=rs.getString("filepath");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			exit();
		}
		return filename;
	}//end imgMethod
	
	public void deleteMethod(String chk[]){
		try {
			conn=start();
			String sql="delete from preview where num=?";
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<chk.length; i++){
				pstmt.setInt(1, Integer.parseInt(chk[i]));
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			exit();
		}
	}//end deleteMethod()

	
}// end class













