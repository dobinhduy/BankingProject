package Banking;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;


public class SignUpWindow  implements MatchAble   {

	private JFrame frame;
	private JTextField firstNametxt;
	private JTextField emailtxt;
	private JTextField phoneNotxt;
	private JTextField jobtxt;
	private JTextField addtxt;

	private JRadioButton sexMale;
	private JRadioButton sexFemale;
	
	@SuppressWarnings("rawtypes")
	JComboBox comboBox = new JComboBox();
	JComboBox<Integer> dayBox = new JComboBox<Integer>();
	JComboBox<Integer> monthBox = new JComboBox<Integer>();
	JComboBox<Integer> yearBox = new JComboBox<Integer>();
	
	
	JLabel lblNewLabel = new JLabel("Username");
	JLabel lblNewLabel_1 = new JLabel("Password");
	JLabel lblNewLabel_2 = new JLabel("E-mail");
	JLabel lblNewLabel_3 = new JLabel("Phone No");
	JLabel BirthDay = new JLabel("BirthDay");
	JLabel lblNewLabel_4 = new JLabel("Occupation");
	JLabel lblNewLabel_5 = new JLabel("Confirm Password");
	JLabel lblNewLabel_6 = new JLabel("Address");
	JLabel comfirmLable = new JLabel("");
	JLabel lblNewLabel_7 = new JLabel("Account Type");
	
	JButton btnNewButton_1 = new JButton("Create new account",new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\icons8-ok-16.png"));
	JButton backBt = new JButton("Back",new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\back.png"));
	
	Database db =Database.getInstance();
	
	
	private JPasswordField passwordtxt;
	private JPasswordField conformtxt;
	History his ;
	public SignUpWindow() {
		initialize();
		this.frame.setVisible(true);
		
	
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 196));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 40, 952, 771);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(92, 116, 85, 34);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(92, 239, 85, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(92, 344, 85, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		sexMale = new JRadioButton("Male");
		sexMale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(sexFemale.isSelected() && sexMale.isSelected()) {
					sexFemale.setSelected(false);
				}
			}
		});

		sexMale.setFont(new Font("Tahoma", Font.BOLD, 13));
		sexMale.setBounds(603, 179, 103, 21);
		frame.getContentPane().add(sexMale);
		
		sexFemale = new JRadioButton("Female");
		sexFemale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(sexMale.isSelected() && sexFemale.isSelected()) {
					sexMale.setSelected(false);
				}
			}
		});
		sexFemale.setFont(new Font("Tahoma", Font.BOLD, 13));
		sexFemale.setBounds(716, 179, 103, 21);
		frame.getContentPane().add(sexFemale);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Savings Account", "Current  Account"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(251, 529, 314, 29);
		frame.getContentPane().add(comboBox);
		
		firstNametxt = new JTextField();
		firstNametxt.setBounds(251, 121, 314, 28);
		frame.getContentPane().add(firstNametxt);
		firstNametxt.setColumns(10);
		
		emailtxt = new JTextField();
		emailtxt.setBounds(251, 342, 314, 29);
		frame.getContentPane().add(emailtxt);
		emailtxt.setColumns(10);
		
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(92, 436, 85, 29);
		frame.getContentPane().add(lblNewLabel_3);
		
		phoneNotxt = new JTextField();
		phoneNotxt.setBounds(251, 437, 314, 29);
		frame.getContentPane().add(phoneNotxt);
		phoneNotxt.setColumns(10);
		
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(92, 479, 85, 34);
		frame.getContentPane().add(lblNewLabel_4);
		
		jobtxt = new JTextField();
		jobtxt.setBounds(251, 483, 314, 29);
		frame.getContentPane().add(jobtxt);
		jobtxt.setColumns(10);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(373, 614, 196, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(92, 289, 122, 22);
		frame.getContentPane().add(lblNewLabel_5);
		
	
		dayBox.setBounds(251, 180, 41, 21);
		frame.getContentPane().add(dayBox);
		
		
		monthBox.setBounds(325, 180, 51, 20);
		frame.getContentPane().add(monthBox);
		
		yearBox.setBounds(422, 180, 73, 20);
		frame.getContentPane().add(yearBox);
		
		
		BirthDay.setFont(new Font("Tahoma", Font.BOLD, 13));
		BirthDay.setBounds(92, 172, 73, 34);
		frame.getContentPane().add(BirthDay);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setToolTipText("Password must be contains:"+"\n"+ "more than 8 characters\r\n+ at least one UPPER character  \r\n+ at least one LOWER character\r\n+ at least one digit\r\nEX: Duy12345\r\n");
		passwordtxt.setBounds(251, 232, 314, 29);
		frame.getContentPane().add(passwordtxt);
		
		conformtxt = new JPasswordField();
		conformtxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String password =String.valueOf(passwordtxt.getPassword());
				String comfirm =String.valueOf(conformtxt.getPassword());
				if(password.equals(comfirm)) {
					comfirmLable.setText("Correct password");
					comfirmLable.setForeground(Color.green);
				}
				else {
					comfirmLable.setText("Incorrect password");
				    comfirmLable.setForeground(Color.red);
			}}
		});
		conformtxt.setBounds(251, 289, 314, 29);
		frame.getContentPane().add(conformtxt);
		

		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(92, 388, 85, 32);
		frame.getContentPane().add(lblNewLabel_6);
		
		addtxt = new JTextField();
		addtxt.setBounds(251, 388, 314, 27);
		frame.getContentPane().add(addtxt);
		addtxt.setColumns(10);
		generateDate();
		
		backBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				LoginWindow frame =new LoginWindow();
				new LoginWindow();
				frame.setVisible(true);
				}	
		});
		backBt.setFont(new Font("Tahoma", Font.BOLD, 13));
		backBt.setBounds(251, 614, 103, 21);
		frame.getContentPane().add(backBt);
		
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(92, 538, 122, 20);
		frame.getContentPane().add(lblNewLabel_7);
		comfirmLable.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		
		
		comfirmLable.setBounds(626, 290, 170, 23);
		frame.getContentPane().add(comfirmLable);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkfill()) {	
					if(isPasswordValid()) {
					    if(isPasswordMatch()) {
						   if(!db.isAccExist(firstNametxt.getText())) {
							createAccount();
							JOptionPane.showMessageDialog(null, "Created Success","",JOptionPane.INFORMATION_MESSAGE);
			    		   	frame.dispose();			    
			    		   	LoginWindow lg=new LoginWindow();
			    		   	lg.setVisible(true);
					                                           }
						   else 
				    	   	JOptionPane.showMessageDialog(null, "Account is exist !!","Error",JOptionPane.CANCEL_OPTION);
				       	}
					     else 
						JOptionPane.showMessageDialog(null,"Password is not match!!","Error",JOptionPane.ERROR_MESSAGE);
					
				}
					else {
			    		JOptionPane.showMessageDialog(null, "Your password is not safe."+"\n"
			    				+ "Your password should contains: "+ "\n"
			    				+"    +More than 8 digits"+"\n"
			    				+"    +One or more uppercase characters"+"\n"
			    				+"    +One or more lowercase characters"+"\n"
			    				+"    +One or more digits","Warning",JOptionPane.WARNING_MESSAGE);
			    	}
			    	
				}
				else 
						JOptionPane.showMessageDialog(null, "Fill all","Error",JOptionPane.ERROR_MESSAGE);}				
			}
		
		);

	} 
	boolean checkfill() {
		String password =String.valueOf(passwordtxt.getPassword());
		if(firstNametxt.getText().isEmpty()|| password.isEmpty() || password.isEmpty()
				|| emailtxt.getText().isEmpty()	|| phoneNotxt.getText().isEmpty() 
				  || jobtxt.getText().isEmpty()) 
		{
			return false;
		}
		if((!sexMale.isSelected()) && (!sexFemale.isSelected())) {
			return false;
		}
		return true;
	}
	void createAccount() {
		String password =String.valueOf(passwordtxt.getPassword());
		his=new History();
		String sex;
		String day = yearBox.getSelectedItem().toString() +'/'+ monthBox.getSelectedItem().toString() + '/' + dayBox.getSelectedItem().toString();
		Account acc;
		LocalDate now =LocalDate.now();
		
		if(sexMale.isSelected()) {
			sex= "Male";		
		}	
		else 
			sex= "Female";
		
		UserInformation user =new UserInformation(firstNametxt.getText(), emailtxt.getText(), phoneNotxt.getText(), 
				                                  addtxt.getText(), jobtxt.getText(), sex, day,""+now,"0",0.0,0.0);
		    	   if(comboBox.getSelectedIndex()==0) {
		    		   acc=new SavingAccount(db.listofacc.size(),password, 50.0, user,his);
		    		   	db.addAccount(acc);	                
		    		   	db.saveData();
		    	   			}
		    	   else {
		    		   acc= new CurrentAccount(db.listofacc.size(), password, 50.0, user,his);
		    		   db.addAccount(acc);	    		
		    		   db.saveData();
		    	   }}
	
	void generateDate()
	{
		for(int i=1;i<=31;i++)
		{
			dayBox.addItem(i);
		}
		for(int i=1;i<=12;i++)
		{	
			monthBox.addItem(i);
		}
		for(int i=1900;i<=2020;i++)
		{
			yearBox.addItem(i);
		}
	}
	@Override
    public boolean isPasswordValid() {
//    	int countUp=0;
//    	int countLow=0;
//    	int digit=0;
//    	String a= new String(passwordtxt.getPassword());
//    	if(a.length()>8) {
//    		for(int i=0 ; i<a.length();i++) {
//    			char c= a.charAt(i);
//    			if(Character.isUpperCase(c))
//    			countUp++;
//    			if(Character.isLowerCase(c))
//    			countLow++;
//    			if(Character.isDigit(c))
//    				digit++;
//    		}
//    		if(countLow>=1 && countUp>=1 && digit>=1 ) {
//    			countLow=0;
//    			countUp=0;
//    			digit=0;
//    			return true;
//    		}}
    	return true;
    }
	@Override
	public boolean isPasswordMatch() {
		String a = new String(passwordtxt.getPassword());
		String b = new String(conformtxt.getPassword());	
		if(a.equals(b))
			return true;
		
		return false;
	}
	}

