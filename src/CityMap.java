import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class CityMap extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField address;
	private JTextField email;
	private JComboBox provinceBox;
	private JComboBox cityBox;
	
	public static Map<String,String[]> model = new LinkedHashMap();
	static{
		model.put("Japan", new String[]{"Kyoto","Tokyo","Osaka","Nara","Kyuzyu"});
		model.put("Taiwan", new String[]{"Taipei","Kaohsiung","Tainan","Taichung"});
		model.put("America", new String[]{"New York","Los Angeles","Chicago","Houston"});
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					CityMap frame = new CityMap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CityMap() {
		
		super("CityMap");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 362);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("FormattedTextField.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLabel = new JLabel("Name :\r\n");
		nameLabel.setFont(new Font("華康中特圓體(P)", Font.BOLD, 14));
		nameLabel.setBounds(89, 43, 70, 23);
		contentPane.add(nameLabel);
		
		JLabel sexLabel = new JLabel("Sex :");
		sexLabel.setFont(new Font("華康中特圓體(P)", Font.BOLD, 14));
		sexLabel.setBounds(89, 75, 70, 23);
		contentPane.add(sexLabel);
		
		name = new JTextField();
		name.setBounds(166, 45, 143, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(166, 76, 70, 21);
		contentPane.add(comboBox);
		
		JLabel dwellLabel = new JLabel("Dwelling :\r\n");
		dwellLabel.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 16));
		dwellLabel.setBounds(89, 118, 70, 15);
		contentPane.add(dwellLabel);
		
		JLabel addressLabel = new JLabel("Address :");
		addressLabel.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 14));
		addressLabel.setBounds(78, 222, 70, 25);
		contentPane.add(addressLabel);
		
		JLabel emailLabel = new JLabel("E-mail :");
		emailLabel.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 14));
		emailLabel.setBounds(98, 257, 57, 25);
		contentPane.add(emailLabel);
		
		address = new JTextField();
		address.setBounds(166, 225, 174, 21);
		contentPane.add(address);
		address.setColumns(10);
		
		email = new JTextField();
		email.setBounds(166, 260, 174, 21);
		contentPane.add(email);
		email.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		panel.setBounds(89, 143, 367, 62);
		contentPane.add(panel);
		panel.setLayout(null);
		
		provinceBox = new JComboBox();
		provinceBox.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 14));
		provinceBox.setBounds(10, 20, 91, 22);
		provinceBox.setModel(new DefaultComboBoxModel(getProvince()));
		provinceBox.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						itemChange();
					}					
				}
		);
		panel.add(provinceBox);
		
		JLabel lblNewLabel_5 = new JLabel("Province");
		lblNewLabel_5.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(111, 21, 64, 18);
		panel.add(lblNewLabel_5);
		
		cityBox = new JComboBox();
		cityBox.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 14));
		cityBox.setBounds(202, 21, 99, 21);
		cityBox.setModel(new DefaultComboBoxModel(initCity()));
		panel.add(cityBox);
		
		JLabel lblNewLabel_6 = new JLabel("City");
		lblNewLabel_6.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(311, 20, 46, 21);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("CITY MAP");
		lblNewLabel_7.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(189, 10, 188, 15);
		contentPane.add(lblNewLabel_7);
		
		JButton save = new JButton("SAVE");
		save.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 14));
		save.setBounds(129, 291, 87, 23);
		contentPane.add(save);
		
		JButton reset = new JButton("RESET");
		reset.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 14));
		reset.setBounds(253, 291, 87, 23);
		contentPane.add(reset);
	}
	
	public Object[] getProvince(){
		Map<String,String[]> map = model; //獲得省份資訊儲存於Map中
		Set<String> set =  map.keySet();  //獲得Map集合中的鍵，並已Set集合傳回
		Object[] province = set.toArray();//轉為陣列
		return province;                  //傳回獲得的省份資訊
	}
	
	public Object[] initCity(){
		Map<String , String[]> map = model;//獲得省份資訊儲存於Map中
		Object[] city = map.get("Japan");  //獲得Key為Japan的值
		return city;
	}
	public void itemChange(){
		String selectProvince = (String) provinceBox.getSelectedItem();
		cityBox.removeAllItems();                            //清空市/縣列表
		String[] arrCity = getCity(selectProvince);          //獲得市/縣  
		cityBox.setModel(new DefaultComboBoxModel(arrCity)); //重新增加市/縣列表的值
	}
	
	public String[] getCity(String selectProvince){
		Map<String,String[]> map = model;           //獲得省份資訊儲存於Map中 
		String[] arrCity = map.get(selectProvince); //獲得指定鍵的值
		return arrCity;
	}
}
