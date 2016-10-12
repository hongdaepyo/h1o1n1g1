package java0804_jdbc;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WinUser extends Frame{
	public WinUser(){
		setSize(300, 400);
		setVisible(true);
		//this.addWindowListener(new UserAdapter());
		this.addWindowListener(new WindowAdapter() {//익명클래스로 사용가능
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}//end WinUser()
	
	class UserAdapter extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
}

public class java202_gui {

	public static void main(String[] args) {
		WinUser user = new WinUser();
		

	}//end main()

}//end class
