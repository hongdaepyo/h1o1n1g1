package java0804_jdbc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * awt에서 제공된 컴포넌트를 swing에서 상속받아 사용할 때 : Button -> JButton
 * swing에서 제공된 컴포넌트들은 자바에서 구현된 클래스이고
 * awt에서 제공된 컴포넌트는 현재 실행중인 운영체제의 컴포넌트를 참조한다.
 */

class SwingComponent extends JFrame implements ActionListener{
	JTextField inputTxt;
	JButton runBtn;
	JTextArea multiArea;
	
	public SwingComponent(){
		runBtn=new JButton("RUN");
		inputTxt=new JTextField(30);
		multiArea=new JTextArea();
		JPanel p=new JPanel(); //FlowLayout(add 시켜준 순서대로 왼쪽 -> 오른쪽)
		p.add(inputTxt);
		p.add(runBtn);
		
		this.add(p, BorderLayout.NORTH);
		this.add(multiArea, BorderLayout.CENTER);
		
		runBtn.addActionListener(this);
		inputTxt.addActionListener(this);
		
		setSize(500,400);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
	}//end InputWin()

	@Override
	public void actionPerformed(ActionEvent event) {
		String mess=inputTxt.getText();
		//JTextField에서 입력한 데이터를 TextArea에 추가
		multiArea.append(mess+"\n");
		//JTextField를 초기화한다.
		inputTxt.setText("");
		//JTextField로 포커스를 이동
		inputTxt.requestFocusInWindow();
		
	}//end actionPerformed
}//end class
public class Java204_gui_swingcomponent {

	public static void main(String[] args) {
		new SwingComponent();
		

	}//end main()

}//end class
