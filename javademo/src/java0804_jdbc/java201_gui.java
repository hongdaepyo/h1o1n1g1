package java0804_jdbc;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class WinView extends Frame{
	public WinView(){
		
		setSize(300,400); // 300 가로크기, 400 세로크기
		setVisible(true);
		//이벤트가 발생된 컴포넌트.addWindowListener
		this.addWindowListener(new CloseWin());
		
	}//end WinView()
	
	/* 
	 * Window컴포넌트에서 이벤트 발생
	 * WindowEvent -> WindowListener -> addWindowListener()
	 * 
	 * Button컴포넌트에서 이벤트 발생
	 * ActionEvent -> ActionListener -> addActionListener()
	 *  	
	 */
	class CloseWin implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0); //시스템종료
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}//end WinView

public class java201_gui {

	public static void main(String[] args) {
		WinView wn=new WinView();
		

	}//end main()

}//end class
