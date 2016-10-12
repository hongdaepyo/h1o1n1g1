package java0804_jdbc;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class InputWin extends Frame implements ActionListener{
	TextField inputTxt;
	Button runBtn;
	TextArea multiArea;
	
	public InputWin(){
		runBtn=new Button("RUN");
		inputTxt=new TextField(30);
		multiArea=new TextArea();
		Panel p=new Panel(); //FlowLayout(add 시켜준 순서대로 왼쪽 -> 오른쪽)
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
		//TextField에서 입력한 데이터를 TextArea에 추가
		multiArea.append(mess+"\n");
		//TextField를 초기화한다.
		inputTxt.setText("");
		//TextField로 포커스를 이동
		inputTxt.requestFocusInWindow();
		
	}//end actionPerformed
}//end class

public class Java203_gui {

	public static void main(String[] args) {
		InputWin input = new InputWin();
		

	}//end main()

}//end class
