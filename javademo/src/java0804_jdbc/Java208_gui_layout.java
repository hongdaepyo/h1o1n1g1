package java0804_jdbc;


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class SetLayout extends JFrame{
	JButton oneBtn, twoBtn;
	public SetLayout(){
		oneBtn = new JButton("one");
		twoBtn = new JButton("two");
		//JFrame의 레이아웃을 초기화한다.
		setLayout(null);
		
		//oneBtn.setSize(100,100);//가로크기, 세로크기
		//twoBtn.setSize(150,200);
		
		oneBtn.setBounds(0, 0, 100, 100);//x시작점, y시작점, x크기, y크기
		twoBtn.setBounds(0, 100, 150, 200);
		
		add(oneBtn);
		add(twoBtn);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}//end SetLayout

public class Java208_gui_layout {

	public static void main(String[] args) {
		new SetLayout();

	}//end main()

}//end class
