package java0805_jdbc;
/** 회원 정보 관리

 * 스킬업
componet
layout
event
implement
io stream
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Java213_PersonInfo2 extends JFrame implements MouseListener, ActionListener {
	PersonMenu menu;
	PersonMain main;
	PersonToolbar tool;
	private int crow = -1;

	public Java213_PersonInfo2() {
		this.setTitle(" 개인정보관리");

		// menu
		menu = new PersonMenu();
		setJMenuBar(menu);

		// main과 //툴바
		main = new PersonMain();
		tool = new PersonToolbar();

		add("Center", main);
		add("North", tool);

		main.registerB.addMouseListener(this);
		main.modifyB.addMouseListener(this);
		main.deleteB.addMouseListener(this);
		main.clearB.addMouseListener(this);
		main.table.addMouseListener(this);

		main.registerB.addActionListener(this);
		main.modifyB.addActionListener(this);
		main.deleteB.addActionListener(this);
		main.clearB.addActionListener(this);

		// 윈도우창 닫기
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int msg = getConfirmMessage("정말로 종료하겠습니까?");
				if (msg == 0)
					System.exit(0);
				else
					return;
			}
		});

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // DO_NOTHING_ON_CLOSE
																// 닫히지 않도록
		this.setSize(520, 550);
		this.setVisible(true);

	}// constructor ended///////////////////////////////////////////////////////

	// 메세지창-confirm dialog
	public int getConfirmMessage(String msg) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("sanSerif", 0, 12));
		label.setForeground(new Color(255, 0, 0)); // Color.red
		return JOptionPane.showConfirmDialog(this, label, "메세지", JOptionPane.YES_NO_OPTION);
	}// end getConfirmMessage()////////////////////////////////////////////////

	public static void main(String[] args) {
		new Java213_PersonInfo2();
	}// end main()

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == main.table && e.getClickCount() == 2)
			setInputRecord();
	}// end mouseClicked()

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == main.registerB) {
			main.registerB.setText("Register");
		} else if (obj == main.modifyB) {
			main.modifyB.setText("Modify");
		} else if (obj == main.deleteB) {
			main.deleteB.setText("Delete");
		} else if (obj == main.clearB) {
			main.clearB.setText("Clear");
		}
	}// end mouseEntered()

	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == main.registerB) {
			main.registerB.setText("등록");
		} else if (obj == main.modifyB) {
			main.modifyB.setText("수정");
		} else if (obj == main.deleteB) {
			main.deleteB.setText("삭제");
		} else if (obj == main.clearB) {
			main.clearB.setText("초기화");
		}
	}// end mouseExited()

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == main.clearB)
			allClear(); // [초기화]
		else if (obj == main.registerB)
			setRegister(); // [등록]
		else if (obj == main.modifyB)
			setModify(); // [수정]
		else if (obj == main.deleteB)
			delete(); // [삭제]
	}// end actionPerformed()////////////////////////////////

	// [삭제]버튼을 클릭했을때 실행
	public void delete() {
		// 테이블에서 삭제할 행을 선택한 값을 리턴한다.
		int rows[] = main.table.getSelectedRows();

		// getSelectedRows()는 선택된 행이 없을 경우 empty array발생함
		// 선택된 행이 있는지 체크함
		if (rows.length < 1) {
			setMessage("삭제할 레코드를 선택하세요.");
			return;
		}

		String msg = "선택된 항목을 모두 삭제하시겠습니까?";
		if (getConfirmMessage(msg) != 0) { // 0:yes, 1 :no
			return;
		}

		for (int i = rows.length - 1; i >= 0; i--) {
			//빈레드인지 체크함
			if (main.table.getValueAt(i, 0) == null)
				continue;
			main.tableModel.removeRow(rows[i]);
		}
		
		//기본 행수가 작아졌으므로 행 수를 늘려줘야 함
		if(main.table.getRowCount()<50)
			main.tableModel.setNumRows(50);
		
		//테이블의 행번호를 다시 생성한다.
		createNumber();

	}// end delete()////////////////////////////////
	
	public void createNumber(){
		for(int i=0; i<main.table.getRowCount(); i++){
			if(main.table.getValueAt(i,0)==null) break;
			main.table.setValueAt(Integer.toString(i+1), i, 0);
		}
	}//end createNumber()///////////////////////////

	// [수정]버튼을 클릭했을 때 실행
	public void setModify() {
		if (getRow() < 0) {
			setMessage("등록되지 않은 레코드입니다.");
			return;
		}

		String name = main.nameF.getText().trim(); // trim 불필요할 공백제거
		String sex = main.manR.isSelected() ? "남" : "여";
		String tel1 = (String) main.telC.getSelectedItem(); // .toString();
		String tel2 = main.tel1F.getText().trim();
		String tel3 = main.tel2F.getText().trim();
		String email = main.emailF.getText().trim();

		// 모든 항목을 입력하지 않았을때 경고.
		if (name.length() < 1 || tel2.length() < 1 || tel3.length() < 1 || email.length() < 1) {
			setMessage("모든 항목을 입력하십시오");
			return;
		}

		main.table.setValueAt(name, getRow(), 1);
		main.table.setValueAt(sex, getRow(), 2);
		main.table.setValueAt(tel1 + "-" + tel2 + "-" + tel3, getRow(), 3);
		main.table.setValueAt(email, getRow(), 4);

		// 입력된 항목 초기화
		setClear();

		// 현재 상태 정보를 등록이 가능하도록 값을 변경한다.
		setRow(-1);

	}// end setModify()///////////////////////////

	// 더블클릭한 테이블의 레코드의 행값을 얻는다.
	// 선택한 테이블의 행을 값들을 각각 항목에 저장한다.
	public void setInputRecord() {
		int row = main.table.getSelectedRow();
		if (row < 0 || main.table.getValueAt(row, 0) == null)
			return;

		setRow(row);
		main.nameF.setText(main.table.getValueAt(row, 1).toString());
		String sex = main.table.getValueAt(row, 2).toString();
		if (sex.equals("남"))
			main.manR.setSelected(true);
		else
			main.womanR.setSelected(true);
		String tel1 = main.table.getValueAt(row, 3).toString();
		StringTokenizer st = new StringTokenizer(tel1, "-");
		main.telC.setSelectedItem(st.nextToken());
		main.tel1F.setText(st.nextToken());
		main.tel2F.setText(st.nextToken());
		main.emailF.setText(main.table.getValueAt(row, 4).toString());

	}// end setInputRecord()

	// private int crow멤버변수의 setter & getter메소드 정의
	public void setRow(int crow) {
		this.crow = crow;
	}// end setRow();

	public int getRow() {
		return crow;
	}

	// [등록]버튼을 클릭했을때 실행
	public void setRegister() {
		if (getRow() >= 0) {
			setMessage("이미 등록된 레코드입니다");
			return;
		}

		String name = main.nameF.getText().trim(); // trim 불필요할 공백제거
		String sex = main.manR.isSelected() ? "남" : "여";
		String tel1 = (String) main.telC.getSelectedItem(); // .toString();
		String tel2 = main.tel1F.getText().trim();
		String tel3 = main.tel2F.getText().trim();
		String email = main.emailF.getText().trim();

		// 모든 항목을 입력하지 않았을때 경고.
		if (name.length() < 1 || tel2.length() < 1 || tel3.length() < 1 || email.length() < 1) {
			setMessage("모든 항목을 입력하십시오");
			return;
		}

		// 항목 추가
		for (int i = 0; i < main.table.getRowCount(); i++) { // 전체 레코드수 구하고
			if (main.table.getValueAt(i, 0) == null) {
				// if문 비어있는 첫번째 행을 찾음.
				main.table.setValueAt(Integer.toString(i + 1), i, 0);
				main.table.setValueAt(name, i, 1);
				main.table.setValueAt(sex, i, 2);
				main.table.setValueAt(tel1 + "-" + tel2 + "-" + tel3, i, 3);
				main.table.setValueAt(email, i, 4);
				break;
			}
		}

		// 입력된 항목 초기화
		setClear();
	}// end setRegister()////////////////////////

	public void setMessage(String msg) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("sansSerif", 0, 13));
		label.setForeground(Color.blue);
		JOptionPane.showMessageDialog(this, label);
	}// end setMessage

	// [초기화]버튼 클릭했을때 실행
	public void allClear() {
		setClear();
		setTableClear();
	}// end allClear();

	// 테이블을 제외한 컴포넌트 초기화
	public void setClear() {
		main.nameF.setText("");
		main.tel1F.setText("");
		main.tel2F.setText("");
		main.emailF.setText("");
		main.manR.setSelected(true);
		main.nameF.requestFocus(); // 커서위치
	}// end setClear()

	// 테이블 초기화
	public void setTableClear() {
		// 테이블의 모든 행을 지움
		main.tableModel.setNumRows(0);
		// 테이블 행을 50개 생성
		main.tableModel.setNumRows(50);
	}// end setTableClear()

}// end class
