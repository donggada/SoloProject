import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

public class MainApp extends JFrame {
	private JTextField tf_Id;
	private JTextField tf_Name;
	private JTextField tf_Maker;
	private JTextField tf_Ip;
	private JTextField tf_Username;
	private JTextField tf_color;
	private JFormattedTextField tf_People_Max;
	private JFormattedTextField tf_People_Pos;
	private JFormattedTextField tf_Year;
	private JFormattedTextField tf_need_year;
	private JFormattedTextField tf_license_year;
	private JFormattedTextField tf_cc;
	private JFormattedTextField tf_price_normal;
	private JFormattedTextField tf_price_sale;
	private JFormattedTextField tf_trunk;
	private JComboBox jp_West_is_rent;
	private JComboBox jp_West_Type;
	private JComboBox jp_West_function;
	private JComboBox jp_West_Oil;
	private JComboBox jp_West_is_navi;
	private JComboBox jp_West_is_auto;
	private JComboBox jp_West_license_type;
	private JComboBox jp_West_is_pet;
	private JComboBox jp_West_is_open;
	private JComboBox jp_West_is_smoke;

	private JTable table;
	private JPasswordField tf_Password;
	private JButton btn_Login_Logout;
	private JButton btn_Member_Add;
	private JButton btn_Member_List;
	private JButton btn_Member_Delete;
	private boolean isLogin = false;
	private CarDAO mdao = CarDAO.getInstance();

	public MainApp() {
		showFrame();
	}

	public void showFrame() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setSize(2000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel jp_North = new JPanel();
		jp_North.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.CYAN, Color.GREEN, Color.PINK, Color.MAGENTA));
		getContentPane().add(jp_North, BorderLayout.NORTH);
		jp_North.setLayout(new GridLayout(0, 4, 0, 0));

		JPanel jp_North_IP = new JPanel();
		jp_North.add(jp_North_IP);
		jp_North_IP.setLayout(new FlowLayout(FlowLayout.RIGHT, 7, 25));

		JLabel lb_Ip = new JLabel("IP");
		lb_Ip.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_Ip.setFont(new Font("굴림", Font.BOLD, 16));
		jp_North_IP.add(lb_Ip);

		tf_Ip = new JTextField();
//		tf_Ip.setEditable(false);
		tf_Ip.setText("localhost");
		tf_Ip.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_Ip.setColumns(10);
		jp_North_IP.add(tf_Ip);

		JPanel jp_North_Username = new JPanel();
		jp_North.add(jp_North_Username);
		jp_North_Username.setLayout(new FlowLayout(FlowLayout.RIGHT, 7, 25));

		JLabel lb_Usertname = new JLabel("Username");
		lb_Usertname.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_Usertname.setFont(new Font("굴림", Font.BOLD, 14));
		jp_North_Username.add(lb_Usertname);

		tf_Username = new JTextField();
		tf_Username.setText("admin");
		tf_Username.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_Username.setColumns(10);
		jp_North_Username.add(tf_Username);

		JPanel jp_North_Password = new JPanel();
		jp_North.add(jp_North_Password);
		jp_North_Password.setLayout(new FlowLayout(FlowLayout.RIGHT, 7, 25));

		JLabel lb_Password = new JLabel("Password");
		lb_Password.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_Password.setFont(new Font("굴림", Font.BOLD, 14));
		jp_North_Password.add(lb_Password);

		tf_Password = new JPasswordField();
		tf_Password.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_Password.setColumns(10);
		jp_North_Password.add(tf_Password);

		JPanel jp_North_Login = new JPanel();
		jp_North.add(jp_North_Login);
		jp_North_Login.setLayout(new BorderLayout(0, 20));

		btn_Login_Logout = new JButton("Login");
		btn_Login_Logout.setFont(new Font("굴림", Font.BOLD, 20));
		btn_Login_Logout.setAlignmentX(0.5f);
		jp_North_Login.add(btn_Login_Logout, BorderLayout.CENTER);

		JPanel jp_West = new JPanel();
		getContentPane().add(jp_West, BorderLayout.WEST);
		jp_West.setLayout(new GridLayout(23, 1, 0, 0));

		JPanel jp_West_Id = new JPanel();
		jp_West.add(jp_West_Id);
		jp_West_Id.setLayout(new BoxLayout(jp_West_Id, BoxLayout.X_AXIS));

		JLabel lb_Id = new JLabel("차량 ID");
		lb_Id.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_Id.setFont(new Font("굴림", Font.BOLD, 20));
		jp_West_Id.add(lb_Id);

		tf_Id = new JTextField();
		tf_Id.setEditable(false);
		tf_Id.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_Id.setColumns(10);
		jp_West_Id.add(tf_Id);

		JPanel jp_West_Name = new JPanel();
		jp_West.add(jp_West_Name);
		jp_West_Name.setLayout(new BoxLayout(jp_West_Name, BoxLayout.X_AXIS));

		JLabel lb_Name = new JLabel("차량 이름");
		lb_Name.setHorizontalAlignment(SwingConstants.LEFT);
		lb_Name.setFont(new Font("굴림", Font.BOLD, 20));
		jp_West_Name.add(lb_Name);

		tf_Name = new JTextField();
		tf_Name.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_Name.setColumns(10);
		jp_West_Name.add(tf_Name);

		jp_West_is_rent = new JComboBox();
		jp_West_is_rent.setFont(new Font("굴림", Font.BOLD, 16));
		jp_West_is_rent.setModel(new DefaultComboBoxModel(new String[] { "불가능", "가능" }));
		jp_West_is_rent.setToolTipText("렌트 가능 여부");
		jp_West.add(jp_West_is_rent);

		JPanel jp_West_Maker = new JPanel();
		jp_West.add(jp_West_Maker);

		JLabel lb_Maker = new JLabel("제조사");
		lb_Maker.setHorizontalAlignment(SwingConstants.LEFT);
		lb_Maker.setFont(new Font("굴림", Font.BOLD, 20));

		tf_Maker = new JTextField();
		tf_Maker.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_Maker.setColumns(10);
		jp_West_Maker.setLayout(new BoxLayout(jp_West_Maker, BoxLayout.X_AXIS));
		jp_West_Maker.add(lb_Maker);
		jp_West_Maker.add(tf_Maker);

		jp_West_Type = new JComboBox();
		jp_West_Type.setModel(new DefaultComboBoxModel(new String[] { "소형", "준중형", "중형", "SUV", "대형", "승합", "승합 대형" }));
		jp_West_Type.setToolTipText("렌트 가능 여부");
		jp_West_Type.setFont(new Font("굴림", Font.BOLD, 16));
		jp_West.add(jp_West_Type);

		JPanel jp_West_People_Max = new JPanel();
		jp_West.add(jp_West_People_Max);
		jp_West_People_Max.setLayout(new BoxLayout(jp_West_People_Max, BoxLayout.X_AXIS));

		JLabel lb_People_Max = new JLabel("정원");
		lb_People_Max.setHorizontalAlignment(SwingConstants.LEFT);
		lb_People_Max.setFont(new Font("굴림", Font.BOLD, 20));
		jp_West_People_Max.add(lb_People_Max);

		tf_People_Max = new JFormattedTextField(new NumberFormatter());
		tf_People_Max.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_People_Max.setColumns(10);
		jp_West_People_Max.add(tf_People_Max);

		JPanel jp_West_People_Pos = new JPanel();
		jp_West.add(jp_West_People_Pos);
		jp_West_People_Pos.setLayout(new BoxLayout(jp_West_People_Pos, BoxLayout.X_AXIS));

		JLabel lb_People_Pos = new JLabel("이용가능");
		lb_People_Pos.setHorizontalAlignment(SwingConstants.LEFT);
		lb_People_Pos.setFont(new Font("굴림", Font.BOLD, 20));
		jp_West_People_Pos.add(lb_People_Pos);

		tf_People_Pos = new JFormattedTextField(new NumberFormatter());
		tf_People_Pos.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_People_Pos.setColumns(10);
		jp_West_People_Pos.add(tf_People_Pos);

		JPanel jp_West_Year = new JPanel();
		jp_West.add(jp_West_Year);
		jp_West_Year.setLayout(new BoxLayout(jp_West_Year, BoxLayout.X_AXIS));

		JLabel lb_Year = new JLabel("연식");
		lb_Year.setHorizontalAlignment(SwingConstants.LEFT);
		lb_Year.setFont(new Font("굴림", Font.BOLD, 20));
		jp_West_Year.add(lb_Year);

		tf_Year = new JFormattedTextField(new NumberFormatter());
		tf_Year.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_Year.setColumns(10);
		jp_West_Year.add(tf_Year);

		jp_West_Oil = new JComboBox();
		jp_West_Oil.setFont(new Font("굴림", Font.BOLD, 16));
		jp_West_Oil.setModel(new DefaultComboBoxModel(new String[] { "가솔린", "경유", "LPG", "CNG", "전기", "하이브리드" }));
		jp_West.add(jp_West_Oil);

		jp_West_is_auto = new JComboBox();
		jp_West_is_auto.setModel(new DefaultComboBoxModel(new String[] { "오토", "수동" }));
		jp_West_is_auto.setFont(new Font("굴림", Font.BOLD, 16));
		jp_West.add(jp_West_is_auto);

		jp_West_license_type = new JComboBox();
		jp_West_license_type.setModel(new DefaultComboBoxModel(
				new String[] { "제1종대형", "제1종보통", "제1종소형", "제1종특수", "제2종보통", "제2종소형", "제2종원동기" }));
		jp_West_license_type.setFont(new Font("굴림", Font.BOLD, 16));
		jp_West.add(jp_West_license_type);

		JPanel jp_West_license_year = new JPanel();
		jp_West.add(jp_West_license_year);
		jp_West_license_year.setLayout(new BoxLayout(jp_West_license_year, BoxLayout.X_AXIS));

		JLabel lb_license_year = new JLabel("면허 년수");
		lb_license_year.setHorizontalAlignment(SwingConstants.LEFT);
		lb_license_year.setFont(new Font("굴림", Font.BOLD, 20));
		jp_West_license_year.add(lb_license_year);

		tf_license_year = new JFormattedTextField(new NumberFormatter());
		tf_license_year.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_license_year.setColumns(10);
		jp_West_license_year.add(tf_license_year);

		JPanel jp_West_need_year = new JPanel();
		jp_West.add(jp_West_need_year);
		jp_West_need_year.setLayout(new BoxLayout(jp_West_need_year, BoxLayout.X_AXIS));

		JLabel lb_need_year = new JLabel("나이 조건");
		lb_need_year.setHorizontalAlignment(SwingConstants.LEFT);
		lb_need_year.setFont(new Font("굴림", Font.BOLD, 20));
		jp_West_need_year.add(lb_need_year);

		tf_need_year = new JFormattedTextField(new NumberFormatter());
		tf_need_year.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_need_year.setColumns(10);
		jp_West_need_year.add(tf_need_year);

		JPanel jp_West_cc = new JPanel();
		jp_West.add(jp_West_cc);
		jp_West_cc.setLayout(new BoxLayout(jp_West_cc, BoxLayout.X_AXIS));

		JLabel lb_cc = new JLabel("배기량");
		lb_cc.setHorizontalAlignment(SwingConstants.LEFT);
		lb_cc.setFont(new Font("굴림", Font.BOLD, 20));
		jp_West_cc.add(lb_cc);

		tf_cc = new JFormattedTextField(new NumberFormatter());
		tf_cc.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_cc.setColumns(10);
		jp_West_cc.add(tf_cc);

		JPanel jp_West_price_normal = new JPanel();
		jp_West.add(jp_West_price_normal);
		jp_West_price_normal.setLayout(new BoxLayout(jp_West_price_normal, BoxLayout.X_AXIS));

		JLabel lb_price_normal = new JLabel("정상가");
		lb_price_normal.setHorizontalAlignment(SwingConstants.LEFT);
		lb_price_normal.setFont(new Font("굴림", Font.BOLD, 20));
		jp_West_price_normal.add(lb_price_normal);

		tf_price_normal = new JFormattedTextField(new NumberFormatter());
		tf_price_normal.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_price_normal.setColumns(10);
		jp_West_price_normal.add(tf_price_normal);

		JPanel jp_West_price_sale = new JPanel();
		jp_West.add(jp_West_price_sale);
		jp_West_price_sale.setLayout(new BoxLayout(jp_West_price_sale, BoxLayout.X_AXIS));

		JLabel lb_price_sale = new JLabel("할인율");
		lb_price_sale.setHorizontalAlignment(SwingConstants.LEFT);
		lb_price_sale.setFont(new Font("굴림", Font.BOLD, 20));
		jp_West_price_sale.add(lb_price_sale);

		tf_price_sale = new JFormattedTextField(new NumberFormatter());
		tf_price_sale.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_price_sale.setColumns(10);
		jp_West_price_sale.add(tf_price_sale);

		jp_West_function = new JComboBox();
		jp_West_function.setModel(new DefaultComboBoxModel(new String[] { "전륜", "후륜", "4륜구동" }));
		jp_West_function.setFont(new Font("굴림", Font.BOLD, 16));
		jp_West.add(jp_West_function);

		JPanel jp_West_trunk = new JPanel();
		jp_West.add(jp_West_trunk);
		jp_West_trunk.setLayout(new BoxLayout(jp_West_trunk, BoxLayout.X_AXIS));

		JLabel lb_trunk = new JLabel("트렁크갯수");
		lb_trunk.setHorizontalAlignment(SwingConstants.LEFT);
		lb_trunk.setFont(new Font("굴림", Font.BOLD, 20));
		jp_West_trunk.add(lb_trunk);

		tf_trunk = new JFormattedTextField(new NumberFormatter());
		tf_trunk.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_trunk.setColumns(10);
		jp_West_trunk.add(tf_trunk);

		JPanel jp_West_color = new JPanel();
		jp_West.add(jp_West_color);
		jp_West_color.setLayout(new BoxLayout(jp_West_color, BoxLayout.X_AXIS));

		JLabel lb_color = new JLabel("색상");
		lb_color.setHorizontalAlignment(SwingConstants.LEFT);
		lb_color.setFont(new Font("굴림", Font.BOLD, 20));
		jp_West_color.add(lb_color);

		tf_color = new JTextField();
		tf_color.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_color.setColumns(10);
		jp_West_color.add(tf_color);

		jp_West_is_navi = new JComboBox();
		jp_West_is_navi.setModel(new DefaultComboBoxModel(new String[] { "네비 없음", "네비 있음" }));
		jp_West_is_navi.setFont(new Font("굴림", Font.BOLD, 16));
		jp_West.add(jp_West_is_navi);

		jp_West_is_pet = new JComboBox();
		jp_West_is_pet.setModel(new DefaultComboBoxModel(new String[] {"애완동물 X", "애완동물 O"}));
		jp_West_is_pet.setFont(new Font("굴림", Font.BOLD, 16));
		jp_West.add(jp_West_is_pet);

		jp_West_is_open = new JComboBox();
		jp_West_is_open.setModel(new DefaultComboBoxModel(new String[] {"오픈 X", "오픈 O"}));
		jp_West_is_open.setFont(new Font("굴림", Font.BOLD, 16));
		jp_West.add(jp_West_is_open);

		jp_West_is_smoke = new JComboBox();
		jp_West_is_smoke.setModel(new DefaultComboBoxModel(new String[] {"흡연 X", "흡연 O"}));
		jp_West_is_smoke.setFont(new Font("굴림", Font.BOLD, 16));
		jp_West.add(jp_West_is_smoke);
		////////////////// 이름 관련한 설정 ////////////////
		tf_Name.setName("차량 이름");
		tf_Maker.setName("제조사");
		tf_color.setName("색상");
		tf_People_Max.setName("정원");
		tf_People_Pos.setName("이용가능");
		tf_Year.setName("연식");
		tf_need_year.setName("나이조건");
		tf_license_year.setName("면허 년수");
		tf_cc.setName("배기량");
		tf_price_normal.setName("정상가");
		tf_price_sale.setName("할인율");
		tf_trunk.setName("트렁크갯수");
		/////////////////////////////////////////////////////
		JPanel jp_South = new JPanel();
		jp_South.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, null, Color.ORANGE, null));
		getContentPane().add(jp_South, BorderLayout.SOUTH);
		jp_South.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_Member_Add = new JButton("차량추가");
		btn_Member_Add.setFont(new Font("궁서체", Font.BOLD, 18));
		jp_South.add(btn_Member_Add);

		btn_Member_List = new JButton("차량목록");
		btn_Member_List.setFont(new Font("궁서체", Font.BOLD, 18));
		jp_South.add(btn_Member_List);

		btn_Member_Delete = new JButton("차량삭제");
		btn_Member_Delete.setFont(new Font("궁서체", Font.BOLD, 18));
		jp_South.add(btn_Member_Delete);

		JScrollPane sp_Center = new JScrollPane();
		getContentPane().add(sp_Center, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "차명", "렌트 가능", "제조사", "분류", "정원", "이용가능", "연식", "연료", "변속기", "면허 조건", "면허 년수",
						"나이 조건", "배기량", "정상가", "할인율", "구동 방식", "트렁크갯수", "색상", "네비 유무", "애완동물", "오픈카", "흡연 가능" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false); // 셀 고정

		table.setAlignmentX(CENTER_ALIGNMENT);
		sp_Center.setViewportView(table);

		DBConnection.getInstance().setIp(tf_Ip.getText());

		btn_Member_Add.addActionListener(listner);

		btn_Member_Delete.addActionListener(listner);

		btn_Member_List.addActionListener(listner);

		btn_Login_Logout.addActionListener(listner);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				showCarInfo();
			}
		});

		setVisible(true);

	}

	ActionListener listner = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == btn_Login_Logout) {
				member_Login();
			} else if (e.getSource() == btn_Member_Add) {
				member_Add();
			} else if (e.getSource() == btn_Member_Delete) {
				member_Del();
			} else if (e.getSource() == btn_Member_List) {
				member_List();
			}

		}
	};

	public void showCarInfo() {

		tf_Id.setText("" + table.getValueAt(table.getSelectedRow(), 0));
		tf_Name.setText((String) table.getValueAt(table.getSelectedRow(), 1));
		jp_West_is_rent.setSelectedIndex((boolean)table.getValueAt(table.getSelectedRow(), 2) == false ? 0 : 1);
		tf_Maker.setText(table.getValueAt(table.getSelectedRow(), 3) + "");
		jp_West_Type.setSelectedIndex((int)table.getValueAt(table.getSelectedRow(), 4));
		tf_People_Max.setText("" + table.getValueAt(table.getSelectedRow(), 5));
		tf_People_Pos.setText("" + table.getValueAt(table.getSelectedRow(), 6));
		tf_Year.setText("" + table.getValueAt(table.getSelectedRow(), 7));
		jp_West_Oil.setSelectedIndex((int)table.getValueAt(table.getSelectedRow(), 8));
		jp_West_is_auto.setSelectedIndex((boolean)table.getValueAt(table.getSelectedRow(), 9) == false ? 0 : 1);
		jp_West_license_type.setSelectedIndex((int)table.getValueAt(table.getSelectedRow(), 10));
		tf_license_year.setText("" + table.getValueAt(table.getSelectedRow(), 11));
		tf_need_year.setText("" + table.getValueAt(table.getSelectedRow(), 12));
		tf_cc.setText("" + table.getValueAt(table.getSelectedRow(), 13));
		tf_price_normal.setText("" + table.getValueAt(table.getSelectedRow(), 14));
		tf_price_sale.setText("" + table.getValueAt(table.getSelectedRow(), 15));
		jp_West_function.setSelectedIndex((int)table.getValueAt(table.getSelectedRow(), 16));
		tf_trunk.setText("" + table.getValueAt(table.getSelectedRow(), 17));
		tf_color.setText((String) table.getValueAt(table.getSelectedRow(), 18));
		jp_West_is_navi.setSelectedIndex((boolean)table.getValueAt(table.getSelectedRow(), 19) == false ? 0 : 1);
		jp_West_is_pet.setSelectedIndex((boolean)table.getValueAt(table.getSelectedRow(), 20) == false ? 0 : 1);
		jp_West_is_open.setSelectedIndex((boolean)table.getValueAt(table.getSelectedRow(), 21) == false ? 0 : 1);
		jp_West_is_smoke.setSelectedIndex((boolean)table.getValueAt(table.getSelectedRow(), 22) == false ? 0 : 1);
	}

	public void member_Login() {
		if (isLogin) {
			// 로그아웃
			JOptionPane.showMessageDialog(this, "로그아웃 성공!");
			tf_Username.setText("");
			tf_Password.setText("");
			btn_Login_Logout.setText("Login");
			tf_Username.setEditable(true);
			isLogin = false;

		} else {
			// 로그인
			String id = tf_Username.getText();
			String password = new String(tf_Password.getPassword());
			CarDAO mdao = CarDAO.getInstance();
			int count = 0;
			try {
				count = mdao.userCheck2(id, password);
			} catch (LoginFailException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "로그인 실패 : " + e.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
			}

			if (count == 1) {
				// 로그인 성공
				JOptionPane.showMessageDialog(this, "로그인 성공");
				tf_Username.setEditable(false);
				btn_Login_Logout.setText("Logout");
				isLogin = true;
				member_List();
			}
		}

	}

	private void member_Add() {
		if(!LoginCheck()) {
			return;
		}
		
		String car_name = tf_Name.getText();
//		String car_id = tf_Id.getText();
		String car_maker = tf_Maker.getText();
		String car_color = tf_color.getText();

		String str_car_people_pos = tf_People_Pos.getText();
		String str_car_people_max = tf_People_Max.getText();
		String str_car_year = tf_Year.getText();
		String str_car_need_year = tf_need_year.getText();
		String str_car_license_year = tf_license_year.getText();
		String str_car_cc = tf_cc.getText();
		String str_car_price_normal = tf_price_normal.getText();
		String str_car_price_sale = tf_price_sale.getText();
		String str_car_trunk = tf_trunk.getText();

		int car_is_rent = jp_West_is_rent.getSelectedIndex();
		int car_type = jp_West_Type.getSelectedIndex();
		int car_function = jp_West_function.getSelectedIndex();
		int car_oil = jp_West_Oil.getSelectedIndex();
		int car_is_navi = jp_West_is_navi.getSelectedIndex();
		int car_is_auto = jp_West_is_auto.getSelectedIndex();
		int car_license_type = jp_West_license_type.getSelectedIndex();
		int car_is_pet = jp_West_is_pet.getSelectedIndex();
		int car_is_open = jp_West_is_open.getSelectedIndex();
		int car_is_smoke = jp_West_is_smoke.getSelectedIndex();

		MemberBean mb = new MemberBean();
		String str_temp = null;
		int int_temp = -1;

		str_temp = check_Tf_Null(tf_Name, mb);
		if (str_temp == null) {
			return;
		}
		mb.setCar_name(str_temp);

		str_temp = check_Tf_Null(tf_Maker, mb);
		if (str_temp == null) {
			return;
		}
		mb.setCar_maker(str_temp);

		str_temp = check_Tf_Null(tf_color, mb);
		if (str_temp == null) {
			return;
		}
		mb.setCar_color(str_temp);

		int_temp = check_Tf_Null_And_Number(tf_cc, mb);
		if (int_temp == -1) {
			return;
		}
		mb.setCar_cc(int_temp);

		int_temp = check_Tf_Null_And_Number(tf_People_Max, mb);
		if (int_temp == -1) {
			return;
		}
		mb.setCar_people_max(int_temp);

		int_temp = check_Tf_Null_And_Number(tf_People_Pos, mb);
		if (int_temp == -1) {
			return;
		}
		mb.setCar_people_possible(int_temp);

		int_temp = check_Tf_Null_And_Number(tf_Year, mb);
		if (int_temp == -1) {
			return;
		}
		mb.setCar_year(int_temp);

		int_temp = check_Tf_Null_And_Number(tf_need_year, mb);
		if (int_temp == -1) {
			return;
		}
		mb.setCar_need_year(int_temp);

		int_temp = check_Tf_Null_And_Number(tf_license_year, mb);
		if (int_temp == -1) {
			return;
		}
		mb.setCar_license_year(int_temp);

		int_temp = check_Tf_Null_And_Number(tf_price_normal, mb);
		if (int_temp == -1) {
			return;
		}
		mb.setCar_price_normal(int_temp);

		int_temp = check_Tf_Null_And_Number(tf_price_sale, mb);
		if (int_temp == -1) {
			return;
		}
		mb.setCar_price_sale(int_temp);

		int_temp = check_Tf_Null_And_Number(tf_trunk, mb);
		if (int_temp == -1) {
			return;
		}
		mb.setCar_trunk(int_temp);

		if (car_is_auto == -1) {
			JOptionPane.showMessageDialog(this, "변속기 을(를) 입력해주세요!");
			jp_West_is_auto.requestFocus();
			return;
		}

		if (car_is_navi == -1) {
			JOptionPane.showMessageDialog(this, "네비 여부을(를) 입력해주세요!");
			jp_West_is_navi.requestFocus();
			return;
		}

		if (car_is_open == -1) {
			JOptionPane.showMessageDialog(this, "오픈카 을(를) 입력해주세요!");
			jp_West_is_open.requestFocus();
			return;
		}

		if (car_is_pet == -1) {
			JOptionPane.showMessageDialog(this, "애완동물 을(를) 입력해주세요!");
			jp_West_is_pet.requestFocus();
			return;
		}

		if (car_is_rent == -1) {
			JOptionPane.showMessageDialog(this, "렌트 여부을(를) 입력해주세요!");
			jp_West_is_rent.requestFocus();
			return;
		}

		if (car_is_smoke == -1) {
			JOptionPane.showMessageDialog(this, "흡연 가능을(를) 입력해주세요!");
			jp_West_is_smoke.requestFocus();
			return;
		}

		if (car_type == -1) {
			JOptionPane.showMessageDialog(this, "분류 을(를) 입력해주세요!");
			jp_West_Type.requestFocus();
			return;
		}

		if (car_function == -1) {
			JOptionPane.showMessageDialog(this, "변속기 을(를) 입력해주세요!");
			jp_West_function.requestFocus();
			return;
		}

		if (car_oil == -1) {
			JOptionPane.showMessageDialog(this, "연료 을(를) 입력해주세요!");
			jp_West_Oil.requestFocus();
			return;
		}

		mb.setCar_is_auto(car_is_auto == 0 ? false : true);
		mb.setCar_is_navi(car_is_navi == 0 ? false : true);
		mb.setCar_is_open(car_is_open == 0 ? false : true);
		mb.setCar_is_pet(car_is_pet == 0 ? false : true);
		mb.setCar_is_rent(car_is_rent == 0 ? false : true);
		mb.setCar_is_smoke(car_is_smoke == 0 ? false : true);

		mb.setCar_type(car_type);
		mb.setCar_function(car_function);
		mb.setCar_oil(car_oil);

		if (mdao.insertMember(mb)) {
			JOptionPane.showMessageDialog(this, "추가 성공");
			tf_Maker.setText("");
			tf_People_Max.setText("");
			tf_People_Pos.setText("");
			tf_Name.setText("");
			tf_Id.setText("");
			tf_color.setText("");
			tf_People_Max.setText("");
			tf_People_Pos.setText("");
			tf_Year.setText("");
			tf_need_year.setText("");
			tf_license_year.setText("");
			tf_cc.setText("");
			tf_price_normal.setText("");
			tf_price_sale.setText("");
			tf_trunk.setText("");
//			jp_West_is_rent.setSelectedIndex(-1);
            // 콤보박스의 경우에는 유지하게 하는 편이 편할 수도 있다고 생각함.
			// 아닐 경우 위의 코드를 일괄적으로 적용

		} else {
			JOptionPane.showMessageDialog(this, "추가 실패(입력값 잘못됨)");
		}

	}

	public String check_Tf_Null(JTextField tf, MemberBean mb) {
		String str = tf.getText();
		if (str.length() == 0) {
			JOptionPane.showMessageDialog(this, tf.getName() + "을(를) 입력해주세요!");
			tf.requestFocus();
			return null;
		}

		return str;
	}

	public int check_Tf_Null_And_Number(JTextField tf, MemberBean mb) {
		String str = tf.getText();
		String numPattern = "^[0-9,]*$";
		if (str.length() == 0) {
			JOptionPane.showMessageDialog(this, tf.getName() + "을(를) 입력해주세요!");
			tf.requestFocus();
			return -1;
		}

		if (!Pattern.matches(numPattern, str)) {
			JOptionPane.showMessageDialog(this, tf.getName() + "은(는) 숫자만 가능합니다!");
			tf.requestFocus();
			return -1;
		}
		
		str = str.replace(",", "");

		int result = Integer.parseInt(str);

		return result;
	}

	public void member_Del() {
		if (!tf_Username.getText().equals("admin")) {
			JOptionPane.showMessageDialog(this, "어드민만 가능합니다.");
			return;
		}

		int DeleteValue = 0;
		String pattern = "^[0-9]*$";

		if (table.getSelectedRow() == -1) {
			String inputData = JOptionPane.showInputDialog(this, "삭제할 회원 번호를 입력하세요");
			System.out.println(Pattern.matches(pattern, inputData));
			while (inputData == null || inputData.length() == 0 || !Pattern.matches(pattern, inputData)) {
				JOptionPane.showMessageDialog(this, "삭제할 번호를 입력하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
				inputData = JOptionPane.showInputDialog(this, "삭제할 회원 번호를 입력하세요");
			}
			System.out.println(inputData);

			DeleteValue = Integer.parseInt(inputData);

		} else {
			System.out.println(table.getSelectedRow());
			System.out.println(table.getValueAt(table.getSelectedRow(), 0));

			DeleteValue = Integer.parseInt("" + table.getValueAt(table.getSelectedRow(), 0));
		}
		CarDAO mdao = CarDAO.getInstance();
		if (mdao.deleteMember(DeleteValue)) {
			JOptionPane.showMessageDialog(this, "삭제 성공");
		} else {
			JOptionPane.showMessageDialog(this, "삭제 실패");
		}

		member_List();
	}

	public void member_List() {
		if (!LoginCheck()) {
			return;
		}

		ArrayList<Vector> memberList = null;
		try {
			memberList = mdao.getMemberList();
		} catch (LoginFailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (Vector o : memberList) {
			model.addRow(o);
		}

	}
	
	public boolean LoginCheck() {
		if (!isLogin) {
			JOptionPane.showMessageDialog(this, "로그인 후 이용가능합니다.");
			tf_Username.requestFocus();
			return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		new MainApp();
	}
}
