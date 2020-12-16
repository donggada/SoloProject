import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MemberLoginGUI extends JFrame {
	JTextField tfId;
	JPasswordField pfPassword;
	
	
	public MemberLoginGUI() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(800, 400, 350, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("회원 로그인");
		getContentPane().setLayout(new GridLayout(3, 1));
		
		// ========================================================================
		// ---------------------------------------------------
		// 1. 아이디 입력을 위한 패널
		JPanel pId = new JPanel();
		pId.setLayout(null);
		getContentPane().add(pId);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(20, 10, 120, 50);
		lblId.setFont(new Font("굴림체", Font.BOLD, 20));
		pId.add(lblId);
		
		tfId = new JTextField();
		tfId.setBounds(150, 10, 150, 50);
		tfId.setFont(new Font("굴림체", Font.BOLD, 20));
		pId.add(tfId);
		
		
		
		// ---------------------------------------------------
		// 2. 패스워드 입력을 위한 패널
		JPanel pPassword = new JPanel();
		pPassword.setLayout(null);
		getContentPane().add(pPassword);
		
		JLabel lblPassword = new JLabel("패스워드");
		lblPassword.setBounds(20, 10, 120, 50);
		lblPassword.setFont(new Font("굴림체", Font.BOLD, 20));
		pPassword.add(lblPassword);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(150, 10, 150, 50);
		pfPassword.setFont(new Font("굴림체", Font.BOLD, 20));
		pPassword.add(pfPassword);
		
		
		// ---------------------------------------------------
		// 3. 버튼을 위한 패널
		JPanel pButton = new JPanel();
		getContentPane().add(pButton);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("굴림체", Font.BOLD, 30));
		
		JButton btnReset = new JButton("초기화");
		btnReset.setFont(new Font("굴림체", Font.BOLD, 30));
		
		pButton.add(btnLogin);
		pButton.add(btnReset);
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그인 기능 수행을 위해 login() 메서드 호출
				login();
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그인 데이터(ID, Password) 입력창 초기화
				tfId.setText("");
				pfPassword.setText("");
			}
		});
		

		// ---------------------------------------------------
		// ========================================================================
		
		setVisible(true);
	}
	
	public void login() {
		// 입력된 아이디, 패스워드를 가져와서 출력
		// 단, 아이디, 패스워드 입력창이 비어있을 경우 "XXX 입력 필수!" 출력하고 커서 요청
		String id = tfId.getText();
		// JPasswordField 의 텍스트는 getText() 를 사용할 수 있으나 deprecated 되어있으므로
		// getPassword() 메서드 사용을 권장함. 단, char[] 타입으로 리턴되므로
		// 문자열로 변환하기 위해서는 String 객체 생성 시 생성자에 배열 전달해야함
		String password = new String(pfPassword.getPassword());
//		System.out.println(id + ", " + password);
		
		if(id.length() == 0) { // 또는 id.equals("") 사용하여 아이디 미입력 판별
//			System.out.println("아이디 입력 필수!");
			JOptionPane.showMessageDialog(this, "아이디 입력 필수!");
			tfId.requestFocus();
			return;
		} else if(password.length() == 0) {
			JOptionPane.showMessageDialog(this, "패스워드 입력 필수!");
			pfPassword.requestFocus();
			return;
		}
		
		
		// 싱글톤 패턴으로 생성된 MemberDAO 인스턴스 가져오기
		MemberDAO dao = MemberDAO.getInstance();
		
		// MemberDAO 객체의 login() 메서드를 호출하여 로그인 기능 수행
		// => 파라미터 : 아이디, 패스워드
		// => 리턴타입 : boolean 타입(로그인 성공/실패)
//		boolean result = dao.login(id, password);
//		
//		// 로그인 결과 확인
//		if(result) {
//			JOptionPane.showMessageDialog(this, "로그인 성공!");
//		} else {
//			JOptionPane.showMessageDialog(this, "로그인 실패!");
//		}
		
		// ---------------------------------------------------
		// LoginFailException 예외를 활용한 로그인 결과 처리
		try {
			boolean result = dao.login2(id, password);
			
			if(result) { // 로그인 성공 시
				JOptionPane.showMessageDialog(this, "로그인 성공!");
			}
		} catch (LoginFailException e) {
			// 로그인 실패 시, LoginFailException 발생에 의해 catch 문 실행됨
			// => 로그인 실패 원인 메세지 출력
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
		
	}

	public static void main(String[] args) {
		new MemberLoginGUI();
	}

}

class LoginFailException extends Exception {

	public LoginFailException(String message) {
		super(message);
	}
	
}















