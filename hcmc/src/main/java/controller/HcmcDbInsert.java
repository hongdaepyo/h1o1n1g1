package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HcmcDbInsert {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

		private Connection init() throws ClassNotFoundException, SQLException {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
			String username = "hr";
			String password = "a1234";

			return DriverManager.getConnection(url, username, password);
		}// end init()

		private void stop() {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}// end stop()
		
		public void city_insert(String fileName, int sheetNum){
			try {
				String[][] cellValue=xlsxReader(fileName, sheetNum);//파일 이름과 시트번호를 인자값으로 넘겨줌
				conn=init();
				String sql="insert into f_city values(SEQ_f_city_city_num.nextval,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				for(int i=0;i<cellValue.length;i++){
						pstmt.setString(1, cellValue[i][0]);//city_name
						pstmt.setString(2, cellValue[i][1]);//city_address
						pstmt.setDouble(3, Double.parseDouble(cellValue[i][2]));//city_lati
						pstmt.setDouble(4, Double.parseDouble(cellValue[i][3]));//city_long
						pstmt.execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				stop();
			}
		}//city_insert()
		
		public void map_insert(String fileName,int sheetNum){
			try {
				String[][] cellValue=xlsxReader(fileName, sheetNum);//파일 이름과 시트번호를 인자값으로 넘겨줌
				conn=init();
				String sql="insert into f_map values(SEQ_f_map_map_num.nextval,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				for(int i=0;i<cellValue.length;i++){
						pstmt.setInt(1, (int)Double.parseDouble(cellValue[i][0])); //map_phone
						pstmt.setString(2, cellValue[i][1]); //map_name
						pstmt.setString(3, cellValue[i][2]); //map_category
						pstmt.setInt(4, (int)Double.parseDouble(cellValue[i][3])); //city_num
						pstmt.execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				stop();
			}
		}//map_insert()
		
		public void festival_insert(String fileName,int sheetNum){
			try {
				String[][] cellValue=xlsxReader(fileName, sheetNum);//파일 이름과 시트번호를 인자값으로 넘겨줌
				conn=init();
				String sql="insert into f_festival values(SEQ_f_festival_festival_num.nextval,?,?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				for(int i=0;i<cellValue.length;i++){
						pstmt.setString(1, cellValue[i][0]); //festival_name
						pstmt.setDate(2, java.sql.Date.valueOf(cellValue[i][1])); //festival_start
						pstmt.setDate(3, java.sql.Date.valueOf(cellValue[i][2])); //festival_end
						pstmt.setString(4, cellValue[i][3]); //festival_hpage
						pstmt.setString(5, cellValue[i][4]); //festival_theme
						pstmt.setString(6, cellValue[i][5]); //festival_time
						pstmt.setInt(7, (int)Double.parseDouble(cellValue[i][6])); //festival_count
						pstmt.setString(8, cellValue[i][7]); //festival_content
						pstmt.setInt(9, (int)Double.parseDouble(cellValue[i][8])); //city_num
						pstmt.execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				stop();
			}
		}//festival_insert()
		
		public void member_insert(String fileName,int sheetNum){
			try {
				String[][] cellValue=xlsxReader(fileName, sheetNum);//파일 이름과 시트번호를 인자값으로 넘겨줌
				conn=init();
				String sql="insert into f_member values(SEQ_f_member_mem_num.nextval,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				for(int i=0;i<cellValue.length;i++){
						pstmt.setString(1, cellValue[i][0]); //mem_id
						pstmt.setString(2, cellValue[i][1]); //mem_pass
						pstmt.setString(3, cellValue[i][2]); //mem_nickname
						pstmt.setString(4, cellValue[i][3]); //mem_admin
						pstmt.execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				stop();
			}
		}//member_insert()
		
		public void board_insert(String fileName,int sheetNum){
			try {
				String[][] cellValue=xlsxReader(fileName, sheetNum);//파일 이름과 시트번호를 인자값으로 넘겨줌
				conn=init();
				String sql="insert into f_board values(SEQ_f_board_board_num.nextval,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				for(int i=0;i<cellValue.length;i++){
						pstmt.setString(1, cellValue[i][0]); //board_head
						pstmt.setString(2, cellValue[i][1]); //board_content
						pstmt.setDate(3, java.sql.Date.valueOf(cellValue[i][2])); //board_date
						pstmt.setInt(4, (int)Double.parseDouble(cellValue[i][3])); //mem_num
						pstmt.setInt(5, (int)Double.parseDouble(cellValue[i][4])); //festival_num
						pstmt.execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				stop();
			}
		}//member_insert()
		
		public void rep_insert(String fileName,int sheetNum){
			try {
				String[][] cellValue=xlsxReader(fileName, sheetNum);//파일 이름과 시트번호를 인자값으로 넘겨줌
				conn=init();
				String sql="insert into f_rep values(SEQ_f_rep_rep_num.nextval,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				for(int i=0;i<cellValue.length;i++){
						pstmt.setDate(1, java.sql.Date.valueOf(cellValue[i][0])); //rep_date
						pstmt.setString(2, cellValue[i][1]); //rep_content
						pstmt.setInt(3, (int)Double.parseDouble(cellValue[i][2])); //board_num
						pstmt.setInt(4, (int)Double.parseDouble(cellValue[i][3])); //mem_num
						pstmt.execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				stop();
			}
		}//rep_insert()
		
		private String[][] xlsxReader(String fileName, int sheetNum){
			String[][] cellValue=null;
			int idxrow=0; //반복문에 쓸 행 인덱스
			XSSFWorkbook wb=null; //finally에서 close 해주기 위해 try 밖에서 선언
			try{
				File file=new File(fileName);
				InputStream input=new BufferedInputStream(new FileInputStream(file));
				wb = new XSSFWorkbook(input);
				XSSFSheet sheet =wb.getSheetAt(sheetNum); //시트 선택
				
				int rownum = sheet.getPhysicalNumberOfRows(); //시트의 행 갯수
				cellValue=new String[rownum][]; //시트의 행 갯수로 배열생성
				FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();//셀의 값이 함수형태일 때 사용
				
				Iterator rowIter = sheet.rowIterator(); //행 반복
				while(rowIter.hasNext()){
					int idxcell=0; //반복문에 쓸 열 인덱스
					List list=new ArrayList();
					XSSFRow row=(XSSFRow)rowIter.next(); //다음 행
					System.out.println("\n");
					Iterator cells=row.cellIterator(); //열 반복
					cellValue[idxrow]=new String[row.getLastCellNum()]; //각 행의 셀 갯수로 2차배열 크기 결정
					while(cells.hasNext()){
						String data=null;
						XSSFCell cell= (XSSFCell) cells.next(); //다음 셀
						
						switch(cell.getCellType()){
						case XSSFCell.CELL_TYPE_STRING:
							data=cell.getStringCellValue();
							break;
						case XSSFCell.CELL_TYPE_NUMERIC:
							if(HSSFDateUtil.isCellDateFormatted(cell)){
								//java.sql.Date는 날짜 포맷이 yyyy-MM-dd 일때만 사용 가능
								SimpleDateFormat fmt= new SimpleDateFormat("yyyy-MM-dd");
								data=fmt.format(cell.getDateCellValue());
							}else{
								double ddata = cell.getNumericCellValue();
								data=String.valueOf(ddata);
							}//숫자일 경우 날짜와 숫자를 구분
							break;
						case XSSFCell.CELL_TYPE_BOOLEAN:
							boolean bdata=cell.getBooleanCellValue();
							data=String.valueOf(bdata);
							break;
						case XSSFCell.CELL_TYPE_BLANK:         
						case XSSFCell.CELL_TYPE_ERROR:         
						case HSSFCell.CELL_TYPE_FORMULA:
							if(!(cell.toString()=="") ){
								if(evaluator.evaluateFormulaCell(cell)==0){
									double fddata = cell.getNumericCellValue();         
									data = String.valueOf(fddata);
								}else if(evaluator.evaluateFormulaCell(cell)==1){
									data = cell.getStringCellValue();
								}else if(evaluator.evaluateFormulaCell(cell)==4){
									boolean fbdata = cell.getBooleanCellValue();         
									data = String.valueOf(fbdata);         
								}
								break; 
							}
						default: continue;
						}//end switch
						
						cellValue[idxrow][idxcell]=data; //셀 값을 배열에 저장
						idxcell++;
					}
					idxrow++;
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					wb.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(cellValue);
			return cellValue; //셀 값을 저장해놓은 배열을 리턴
		}//end xlsxReader();

	public static void main(String[] args) {
		File file=new File("src\\main\\java\\config");
		String filepath=file.getAbsoluteFile().getPath();
		String fileName = filepath+"\\hcmc.xlsx";
		System.out.println(fileName);
		HcmcDbInsert i = new HcmcDbInsert();
		
	//  i.city_insert(파일명,시트번호(0부터 시작);
		
		i.city_insert(fileName,0);
		i.festival_insert(fileName,1);
		//i.map_insert(fileName,2);
		//i.member_insert(fileName,3);
		//i.board_insert(fileName,4);
		//i.rep_insert(fileName,5);
		
		System.out.println("입력완료");
	}// end main()

}// end class
