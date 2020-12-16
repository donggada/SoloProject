import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class Ex2 extends JFrame {
	private JTextField textField;
	
	public Ex2() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(800, 400, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * AbsoluteLayout
		 * - 컴포넌트들을 원하는 위치에 원하는 크기로 자유롭게 배치 가능한 레이아웃
		 * - 컴포넌트 생성 후 setSize(), setLocation(),setBounds() 로 위치, 크기 지정 필수!
		 */
		
		getContentPane().setLayout(null);
		
		JButton btn1 = new JButton("Button1");
		btn1.setBounds(261, 211, 97, 23);
		getContentPane().add(btn1);
		
		JButton btn2 = new JButton("New button");
		btn2.setBounds(54, 263, 137, 88);
		getContentPane().add(btn2);
		
		textField = new JTextField();
		textField.setBounds(49, 52, 293, 51);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(44, 131, 121, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(221, 131, 121, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(49, 193, 115, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex2();
	}
}
