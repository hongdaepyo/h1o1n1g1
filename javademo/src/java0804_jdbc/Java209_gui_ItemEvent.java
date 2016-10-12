package java0804_jdbc;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

class MultiData extends JFrame implements ItemListener{
	JRadioButton topBtn, midBtn, botBtn;
	JCheckBox javaChk, jspChk, springChk;
	JComboBox<String> locBox;
	JTextArea ta;
	public MultiData(){
		topBtn=new JRadioButton("상",true);
		midBtn=new JRadioButton("중");
		botBtn=new JRadioButton("하");
		
		//라디오버튼은 그룹으로 묶어준다.
		ButtonGroup bg=new ButtonGroup();
		bg.add(topBtn);
		bg.add(midBtn);
		bg.add(botBtn);
		
		JPanel jp1=new JPanel();
		jp1.add(new JLabel("computer:  "));
		jp1.add(topBtn);
		jp1.add(midBtn);
		jp1.add(botBtn);
		
		javaChk = new JCheckBox("java");
		jspChk = new JCheckBox("jsp");
		springChk = new JCheckBox("spring");
		JPanel jp2 = new JPanel();
		jp2.add(new JLabel("subject: "));
		jp2.add(javaChk);
		jp2.add(jspChk);
		jp2.add(springChk);

		/*
		 * locBox=new JComboBox<String>(); locBox.addItem("java");
		 * locBox.addItem("jsp"); locBox.addItem("spring");
		 */

		/*
		 * String[] list=new String[]{"java","jsp","spring"}; locBox=new
		 * JComboBox<String>(list);
		 */

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("java");
		model.addElement("jsp");
		model.addElement("spring");
		locBox = new JComboBox<String>(model);
		JPanel jp3 = new JPanel();
		jp3.add(new JLabel("program: "));
		jp3.add(locBox);

		ta = new JTextArea(10, 10);

		JPanel jp4 = new JPanel(new GridLayout(3, 1));
		jp4.add(jp1);
		jp4.add(jp2);
		jp4.add(jp3);
		//JFrame의 레이아웃을 2행 1열 GridLayout으로 설정
		setLayout(new GridLayout(2, 1));
		add(jp4); add(ta);
		
		// 컴포넌트에 ItemListener 연결
		topBtn.addItemListener(this);
		midBtn.addItemListener(this);
		botBtn.addItemListener(this);
		javaChk.addItemListener(this);
		jspChk.addItemListener(this);
		springChk.addItemListener(this);
		locBox.addItemListener(this);
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//end MultiData()
	@Override
	public void itemStateChanged(ItemEvent e) {
		//이벤트가 발생된 객체를 리턴한다.
		Object obj = e.getSource();
		// ((JRadioButton)obj).isSelected()
		ta.setText("");

		if (topBtn.isSelected())
			ta.append(topBtn.getText() + "\n");
		else if (midBtn.isSelected())
			ta.append(midBtn.getText() + "\n");
		else if (botBtn.isSelected())
			ta.append(botBtn.getText() + "\n");
		
		if (javaChk.isSelected())
			ta.append(javaChk.getText() + "\n");
		if (jspChk.isSelected())
			ta.append(jspChk.getText() + "\n");
		if (springChk.isSelected())
			ta.append(springChk.getText() + "\n");
		
		// 선택된 항목의 인덱스 반환
		int index = locBox.getSelectedIndex();
		// 선택된 항목의 문자열 반환
		String txt = (String) locBox.getSelectedItem();
		ta.append(index + " : " + txt);

	}//end itemStateChanged()
}//end MultiData

public class Java209_gui_ItemEvent {
	public static void main(String[] args) {
		new MultiData();

	}//end main()

}//end class
