package java0804_jdbc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * JOptionPane을 통해 만들 수 있는 대화상자 메소드
 * 1 showInputDialog : 사용자로 부터 데이터를 입력 받기 위한 대화상자
 * 2 showMessageDialog : 사용자에게 메세지를 보여주는 대화상자
 * 3 showConfirmDialog : 사용자가 Yes, No등을 선택할 수 있는 대화상자
 * 4 showOptionDialog : 위 세가지를 포함한 대화상자
 * 
 * JOptionPane클래스에서 제공하는 전달인자
 * 1 Component ParentComponent : 대화상자를 소유하고 있는 부모컴포넌트
 * 2 Object message : 출력할 메세지
 * 3 String title : 제목줄에 보여줄 문자열
 * 4 int option : 대화상자에 보여줄 출력 옵션 버튼
 * 5 Icon icon : 대화상자 왼쪽에 보여줄 아이콘
 * 
 * Option Type Values(버튼모양)
 * 1 DEFAULT_OPTION
 * 2 YES_NO_OPTION
 * 3 YES_NO_CANCLE_OPTION
 * 4 OK_CANCEL
 * 
 * Icon Type Values(대화상자에 메세지와 함께 뜨는 아이콘)
 * 1 ERROR_MESSAGE
 * 2 INFORMATION_MESSAGE
 * 3 WARNING_MESSAGE
 * 4 QUESTION_MESSAGE
 * 5 PLAIN_MESSAGE
 */

class MessTest extends JFrame implements ActionListener{
	JButton btn;
	
	public MessTest(){
		btn=new JButton("exit");
		add(BorderLayout.CENTER,btn);
		
		btn.addActionListener(this);
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}//end MessTest()

	@Override
	public void actionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(this, "정말로 종료하겠습니까?","종료",1);
		int option=JOptionPane.showConfirmDialog(this, "정말로 종료하겠습니까?","종료",JOptionPane.YES_NO_OPTION);
		//Yes:0, No=1
		if(option==JOptionPane.YES_OPTION)
			System.exit(0);
		
		
	}//end actionPerformed()
	
	
}//end class

public class Java210_gui_Message {

	public static void main(String[] args) {
		new MessTest();

	}//end main()

}//end class
