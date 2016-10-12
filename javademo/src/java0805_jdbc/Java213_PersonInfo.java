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

public class Java213_PersonInfo extends JFrame implements MouseListener, ActionListener {
	PersonMenu menu;
	PersonMain main;
	PersonToolbar tool;
	private int crow = -1;

	public Java213_PersonInfo() {
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
		new Java213_PersonInfo();
	}// end main()
////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		
		
	}
////////////////////////////////////////////////////////////////////////////////
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==main.registerB){
			main.registerB.setText("register");
		}else if(obj==main.modifyB){
			main.modifyB.setText("modify");
		}else if(obj==main.deleteB){
			main.deleteB.setText("delete");
		}else if(obj==main.clearB){
			main.clearB.setText("clear");
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==main.registerB){
			main.registerB.setText("등록");
		}else if(obj==main.modifyB){
			main.modifyB.setText("수정");
		}else if(obj==main.deleteB){
			main.deleteB.setText("삭제");
		}else if(obj==main.clearB){
			main.clearB.setText("초기화");
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

}// end class
