package java0805_jdbc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

class MenuTest extends JFrame implements ActionListener{
	
	JMenu file, edit;
	JMenuItem fopen, fsave, fexit, ecopy, epaste;
	JToolBar toolBar;
	JMenuBar menuBar;
	JButton openBtn, saveBtn, helpBtn;
	JTextArea multiArea;
	
	public MenuTest(){
		fopen=new JMenuItem("open");
		fsave=new JMenuItem("save");
		fexit=new JMenuItem("exit");
		
		//단축키
		fopen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, ActionEvent.ALT_MASK));
		fsave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		ecopy=new JMenuItem("copy");
		epaste=new JMenuItem("paste");
		
		file=new JMenu("File");
		edit=new JMenu("Edit");
		file.add(fopen); file.add(fsave); file.add(fexit);
		edit.add(ecopy); edit.add(epaste);
		
		menuBar= new JMenuBar();
		menuBar.add(file); menuBar.add(edit);
		
		setJMenuBar(menuBar);
		
		String path="src/java0805_jdbc/images/";
		openBtn=new JButton(new ImageIcon(path+"open.gif"));
		saveBtn=new JButton(new ImageIcon(path+"save.gif"));
		helpBtn=new JButton(new ImageIcon(path+"help.gif"));
		
		//풍선말
		openBtn.setToolTipText("열기");
		saveBtn.setToolTipText("저장");
		helpBtn.setToolTipText("도움말");
		
		//테두리
		//top, left, bottom, right 반시계방향순
		openBtn.setBorder(new EmptyBorder(0, 5, 0, 5));
		saveBtn.setBorder(new EmptyBorder(0, 5, 0, 5));
		helpBtn.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		toolBar=new JToolBar();
		toolBar.add(openBtn); toolBar.add(saveBtn); toolBar.add(helpBtn);
		
		multiArea=new JTextArea();
		
		add(BorderLayout.NORTH, toolBar);
		add(BorderLayout.CENTER, multiArea);
		
		fopen.addActionListener(this);
		fsave.addActionListener(this);
		saveBtn.addActionListener(this);
		openBtn.addActionListener(this);
		
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//end MenuTest()

	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 발생된 객체 리턴
		Object obj=e.getSource();
		if(obj==fopen||obj==openBtn){
			JFileChooser jc=new JFileChooser("c:\\Users\\user1\\Desktop");
			int chk=jc.showOpenDialog(this);
			if(chk==JFileChooser.APPROVE_OPTION){
				File file=jc.getSelectedFile();
				Scanner sc=null;
				try {
					sc=new Scanner(file);
					multiArea.setText("");
					while(sc.hasNextLine()){
						multiArea.append(sc.nextLine()+"\r\n");
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}finally{
					sc.close();
				}
			}
			
		}else if(obj==fsave||obj==saveBtn){
			JFileChooser jc=new JFileChooser("c:\\Users\\user1\\Desktop");
			jc.showSaveDialog(this);
			int chk=jc.showSaveDialog(this);
			if(chk==JFileChooser.APPROVE_OPTION){
				File file=jc.getSelectedFile();
				//fr객체를 finally에서도 사용하기 위해서 밖으로 뺌
				FileWriter fr=null;
				try {
					fr=new FileWriter(file);
					//자바에서 모든 writer는 대상에 직접 쓰는게 아니고 버퍼에 씀
					fr.write(multiArea.getText());
					fr.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}finally{
					try {
						fr.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		}
	}//end actionPerformed()
}//end class

public class Java211_gui {

	public static void main(String[] args) {
		new MenuTest();
		

	}//end main()

}//end class
