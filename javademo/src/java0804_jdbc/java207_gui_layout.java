package java0804_jdbc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class FlowerUser extends JFrame{
	JButton northBtn, southBtn, eastBtn, westBtn, centerBtn;
	
	public FlowerUser() {
		northBtn=new JButton("one");
		southBtn=new JButton("two");
		eastBtn=new JButton("three");
		westBtn=new JButton("four");
		centerBtn=new JButton("five");
		
		//JFrame의 레이아웃을 FlowLayout으로 변경
		//FlowLayout의 기본은 Center이다.
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		//FlowLayout에 컴포넌트 연결
		add(northBtn); add(southBtn);
		add(eastBtn); add(westBtn);
		add(centerBtn);
		
		setSize(200,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//end FlowerUser()
}//end FlowerUser

public class java207_gui_layout {

	public static void main(String[] args) {
		new FlowerUser();

	}//end main()

}//end class
