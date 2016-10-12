package java0804_jdbc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class BorderUser extends JFrame{
	JButton northBtn, southBtn, eastBtn, westBtn, centerBtn;
	
	public BorderUser() {
		northBtn=new JButton("NORTH");
		southBtn=new JButton("SOUTH");
		eastBtn=new JButton("EAST");
		westBtn=new JButton("WEST");
		centerBtn=new JButton("Center");
		
		add(BorderLayout.NORTH,northBtn);
		add(BorderLayout.SOUTH,southBtn);
		add(BorderLayout.EAST,eastBtn);
		add(BorderLayout.WEST,westBtn);
		add(BorderLayout.CENTER,centerBtn);
		
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//end BorderUser()
}//end BorderUser

public class java206_gui_layout {

	public static void main(String[] args) {
		new BorderUser();
		

	}//end main()

}//end class
