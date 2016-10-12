package java0805_jdbc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java0805_jdbc.dao.EmployeesDAO;
import java0805_jdbc.dto.EmployeesDTO;

class DesignTest extends JFrame implements MouseListener, ActionListener{
	JTextField inputTxt;
	JButton searchBtn;
	JTable table;
	DefaultTableModel model;
	
	public DesignTest(){
		inputTxt=new JTextField(20);
		searchBtn=new JButton("검색");
		
		//여러 메소드에서 사용하는 것이 아니기 때문에 멤버변수로 정의하지 않는다.
		JPanel jp=new JPanel();
		jp.add(inputTxt); jp.add(searchBtn);
		
		//테이블 헤드
		//컴포넌트에서 항목으로 제공되는 것들은 model에서 관리
		Object[] obj={"사원번호","사원명","급여","부서번호"};
		model=new DefaultTableModel(obj, 0){
			//셀 편집 불가능하도록 하기
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}
			
		};
		
		table=new JTable(model);
		//컬럼이동 불가능하도록 하기
		table.getTableHeader().setReorderingAllowed(false);
		//라인의 높이 설정
		table.getRowHeight(20);
		
		add(BorderLayout.NORTH, jp);
		add(BorderLayout.CENTER, new JScrollPane(table));
		
		// 이벤트 리스너 연결
		searchBtn.addActionListener(this);
		searchBtn.addMouseListener(this);
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.setRowCount(0);
		Object obj=e.getSource();
		if(obj==searchBtn){
			EmployeesDAO dao=EmployeesDAO.getInstance();
			ArrayList<EmployeesDTO> aList=dao.listMethod(inputTxt.getText());
			for(EmployeesDTO dto : aList){
				Vector<Object> vo = new Vector<Object>();
				vo.addElement(dto.getEmployee_id());
				vo.addElement(dto.getFirst_name());
				vo.addElement(dto.getSalary());
				vo.addElement(dto.getDepartment_id());
				model.addRow(vo);
			}
				
			
		}
		inputTxt.setText("");
		
	}//end actionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == searchBtn) {
			searchBtn.setText("Search");
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == searchBtn) {
			searchBtn.setText(" 검색   ");
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}// end DesignTest
public class java212_gui {

	public static void main(String[] args) {
		new DesignTest();
		

	}//end main()

}//end class
