package Banking;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class MainMenu extends JFrame implements MatchAble {
	Database db = Database.getInstance();
	Account ac;
	History his;
	JTextField accountNoT = new JTextField("",25);
	JTextField amountT = new JTextField("",20);
	JTextField depositMoney =new JTextField("", 15);
	JTextField withDrawtxt =new JTextField("", 15);
	JTextField accounTransfer =new JTextField("", 15);
	
	JPasswordField oldP= new JPasswordField("",20);
	JPasswordField newP= new JPasswordField("",20);
	JPasswordField reNewP= new JPasswordField("",20);
	
	JButton profile = new JButton("Profile");
	JButton withDraw = new JButton("WithDrawl");
	JButton deposit = new JButton("Deposit");
	JButton tranferMoney = new JButton("Tranfer Money");
	JButton changePin = new JButton("Change Pin");
	JButton logOut = new JButton("Log out",new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\logout.png"));
	
	JButton WithDrawButtom = new JButton("WithDraw");
	JButton transferBottom = new JButton("Transfer");
	JButton withdrawalBottom = new JButton("Withdraw");
	JButton depositBottom = new JButton("Deposit");
	JButton PinBotton = new JButton("ChangePIN");
	JButton searchBottom =new JButton("Search");
	JButton editBottom =new JButton("Edit Profile",new ImageIcon("C:\\Users\\dobin\\OneDrive\\Máy tính\\OOP\\image\\icons8-edit-file-16.png"));
	JButton viewWithdrawHis =new JButton("View History");
	JButton viewDeposit =new JButton("View History");
	JButton viewTranHis =new JButton("View History");
	
	JScrollPane scrollPane = new JScrollPane();

	JLabel hello = new JLabel(new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\button_plant_green_butterfly_hellow_animation_clipart.gif"));
	JPanel center = new JPanel();
	private final JLabel name = new JLabel("");
	private final JLabel lblNewLabel = new JLabel("            ");

	public MainMenu(Account acc) {
		this.ac=acc;
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				db.saveData();
				System.exit(0);
			}
		});
		editBottom.setSize(10, 10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1096, 712);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel central = new JPanel();
		getContentPane().add(central, BorderLayout.CENTER);
		central.setLayout(new BorderLayout(0, 50));
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.WHITE);
		panel_3.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_3.setBackground(Color.GREEN);
		central.add(panel_3, BorderLayout.WEST);
		profile.setBackground(Color.YELLOW);
		profile.setForeground(Color.BLACK);
		
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColor();
				profile.setBackground(Color.ORANGE);
				painUserDetail();
					
			}
		});
		panel_3.setLayout(new GridLayout(7, 1, 20, 25));
		profile.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(profile);
		withDraw.setBackground(Color.YELLOW);
		withDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColor();
				withDraw.setBackground(Color.ORANGE);
				painWithdraw();
				
			}
		});
		withDraw.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(withDraw);
		deposit.setBackground(Color.YELLOW);
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColor();
				deposit.setBackground(Color.orange);
				paineDeposit();
			}
		});
		editBottom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EditProfile edit =new EditProfile(acc);
				edit.setVisible(true);
				dispose();
				
				
			}
		});
		deposit.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(deposit);
		tranferMoney.setBackground(Color.YELLOW);
		tranferMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColor();
				tranferMoney.setBackground(Color.ORANGE);
				tranferMoney();
			}
		});
		
			tranferMoney.setFont(new Font("Tahoma", Font.BOLD, 13));
			panel_3.add(tranferMoney);
		    changePin.setBackground(Color.YELLOW);
		    changePin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColor();
				changePin.setBackground(Color.ORANGE);
				paineChangePin();
			}
		});
		
		changePin.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(changePin);
		center.setBackground(Color.LIGHT_GRAY);
		
		central.add(center, BorderLayout.CENTER);
		center.setLayout(null);
		
		
			
		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(210, 105, 30), 3));
		panel1.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel1, BorderLayout.NORTH);
		name.setFont(new Font("Tahoma", Font.BOLD, 37));
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setText(""+ ac.user.getUserName());
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 30));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel1.add(lblNewLabel);
		hello.setText(" ");
		hello.setHorizontalAlignment(SwingConstants.RIGHT);

		hello.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel1.add(hello);
		
		panel1.add(name);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(new EmptyBorder(4, 5, 6, 0));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		logOut.setBackground(Color.YELLOW);
		logOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(logOut);
		logOut.setHorizontalAlignment(SwingConstants.RIGHT);
		logOut.setVerticalAlignment(SwingConstants.BOTTOM);
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult= JOptionPane.showConfirmDialog(null, "Are you sure to log out", "Log out??",JOptionPane.YES_NO_OPTION);
				if(dialogResult==JOptionPane.YES_OPTION) {
					dispose();
					LoginWindow lg=new LoginWindow();
					lg.setVisible(true);
				}
			   
			}
		});
		PinBotton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String oldPin=new String(oldP.getPassword());
				String newPin=new String(newP.getPassword());
				String rNewPin=new String(reNewP.getPassword());	
				if(oldPin.equals(ac.getPIN())) {
					if(newPin.equals(rNewPin)) {
						if(isPasswordMatch()) {
						    if(isPasswordValid()) {
						    	ac.setPIN(newPin);
						    	JOptionPane.showMessageDialog(null, "Change Pin successfull.Log in again!!");
						    	dispose();
						        LoginWindow lg =new LoginWindow();
						        lg.setVisible(true);
						    	
						    }
						    else
						    	JOptionPane.showMessageDialog(null, "Your password is not safe."+"\n"
					    				+ "Your password should contains: "+ "\n"
					    				+"    +More than 8 digits"+"\n"
					    				+"    +One or more uppercase characters"+"\n"
					    				+"    +One or more lowercase characters"+"\n"
					    				+"    +One or more digits","Warning",JOptionPane.WARNING_MESSAGE);
					    	
						}
						else
							JOptionPane.showMessageDialog(null, "Password is not match.Try again!!","Error",JOptionPane.ERROR_MESSAGE);
						
					}
					else 
						JOptionPane.showMessageDialog(null, "New password is not match","Error",JOptionPane.WARNING_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Password is not correct ","Error",JOptionPane.ERROR_MESSAGE);
				
			}
		});
		depositBottom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isNumeric(depositMoney.getText())) {
					if(Double.parseDouble(depositMoney.getText())>= 10) {
						ac.depositMoney(Double.parseDouble(depositMoney.getText()));
			            JOptionPane.showMessageDialog(null, "Deposit Success");
						paineDeposit();
					}
					else
						JOptionPane.showInternalConfirmDialog(null,	"The number of money must be greater then 10 Dollars");
				}
				else
					JOptionPane.showMessageDialog(null, "Not contain characters");
				
			}
		});
		WithDrawButtom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!withDrawtxt.getText().isEmpty()) {								
				 if(isNumeric(withDrawtxt.getText())){
				     if(ac.withdrawMoney(Double.parseDouble(withDrawtxt.getText()))== 1) 
				    	 JOptionPane.showMessageDialog(null, "Not enought balance");
				     if(ac.withdrawMoney(Double.parseDouble(withDrawtxt.getText()))==2) 
				    	 JOptionPane.showMessageDialog(null, "Withdraw limit under 10 dollars");				     
				     if(ac.withdrawMoney(Double.parseDouble(withDrawtxt.getText()))==3) 
				    	 JOptionPane.showMessageDialog(null, "Withdraw limit over 1000 dollars");				
				     if(ac.withdrawMoney(Double.parseDouble(withDrawtxt.getText()))==4) {			    	
				    	 ac.setBalance(ac.getBalance()-Double.parseDouble(withDrawtxt.getText()));
				    	 String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH-mm-ss").format(Calendar.getInstance().getTime());
				    	 String a= timeStamp.split("_")[0];
				    	 String b = timeStamp.split("_")[1];	    	
				    	 acc.vhis.addTranlist(new Transaction("WithDraw",  a, b, 5.0, "-" + withDrawtxt.getText()));
				    	 JOptionPane.showMessageDialog(null, "Withdraw Successful");
				    	 painWithdraw();
				     }
				}
				else 
					JOptionPane.showMessageDialog(null, "Amount should NOT contains characters");
				
				}
				else
					JOptionPane.showMessageDialog(null,"Please, input the amount");
				}
			
			});
		transferBottom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       if(db.isAccExist(accounTransfer.getText())) {
			    	  if(isNumeric(amountT.getText())) {
			    	     if(ac.transferMoney(db.getAccount(accounTransfer.getText()), Double.parseDouble(amountT.getText()))) 
			    		    JOptionPane.showMessageDialog(null, "Transfer successful");
			    		  
			    	  
			    	      else
			    		    JOptionPane.showMessageDialog(null, "You do not have enought balance ");	    		   			    	   
			             }
			    	  else 
			    		  JOptionPane.showMessageDialog(null, "Amount must be a number");
			    	  }
			       else 
			    	   JOptionPane.showMessageDialog(null, "Account is not exist");
				
			}
		});
		viewWithdrawHis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		    dispose();
		    ViewHistory view =new ViewHistory(ac);
		    view.setVisible(true);
				
			}
		});
	}
	protected void painWithdraw() {
		panelClear();
		center.setBorder(new EmptyBorder(50, 100, 30,100));
		center.setLayout(new GridLayout(4, 4, 50, 70));
	    center.add(new JLabel("User Name: "));
	    center.add(new JLabel(ac.user.getUserName()));
	    center.add(new JLabel());
	    center.add(new JLabel());
	    center.add(new JLabel("Available Balance: "));
	    center.add(new JLabel(""+ac.getBalance()+" Dollars"));
	    center.add(new JLabel());
	    center.add(new JLabel());
	    center.add(new JLabel("Enter the amount: "));
	    center.add(withDrawtxt);
	    center.add(WithDrawButtom);	
	    center.add(new JLabel());   
	    center.add(new JLabel());
	    center.add(new JLabel());
	    center.add(viewWithdrawHis); 
	    center.add(new JLabel());
	       
        this.revalidate();

	
	}
	protected void paineChangePin() {
		panelClear();
		center.setBorder(new EmptyBorder(100, 200, 30,250));
		center.setLayout(new GridLayout(4, 3, 20, 70));
		center.add(new JLabel(" Current Password: "));
		center.add(oldP);
		center.add(new JLabel());
		center.add(new JLabel("New Password: "));
		center.add(newP);
		center.add(new JLabel());
		center.add(new JLabel("Comform: "));
		center.add(reNewP);
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(PinBotton);
		this.revalidate();
		
	}
	protected void paineDeposit() {
		panelClear();
		center.setBorder(new EmptyBorder(50, 100, 30,100));
		center.setLayout(new GridLayout(4, 4, 50, 70));
		center.add(new JLabel("User Name: "));
		center.add(new JLabel(ac.user.getUserName()));
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(new JLabel("Available Balance: "));
		center.add(new JLabel(""+ac.getBalance()+" Dollars"));
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(new JLabel("Deposit: "));
		center.add(depositMoney);
		center.add(depositBottom);
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(viewDeposit);
		center.add(new JLabel());
		
		this.revalidate();
		
	}
	protected void painUserDetail() {
		panelClear();
	
		center.setBorder(new EmptyBorder(50, 200, 50,350));
		center.setLayout(new GridLayout(0, 2, 150, 0));
		center.add(new JLabel("Full Name:"));
		center.add(new JLabel(ac.user.userName+""));
		center.add(new JLabel("Sex:"));
		center.add(new JLabel(ac.user.sex));
		center.add(new JLabel("Date of Birth:"));
		center.add(new JLabel(ac.user.birthdate));
		center.add(new JLabel("Email:"));
		center.add(new JLabel(ac.user.email));
		center.add(new JLabel("Phone No.:"));
		center.add(new JLabel(ac.user.phoneNo));
		center.add(new JLabel("Address:"));
		center.add(new JLabel(ac.user.address));
		center.add(new JLabel("Occupation:"));
		center.add(new JLabel(ac.user.occupation));
		center.add(new JLabel());
		center.add(editBottom);	
		this.revalidate();
		
	}
	private void tranferMoney() {
		panelClear();
		center.setBorder(new EmptyBorder(20, 120, 70,300));
		center.setLayout(new GridLayout(4, 3, 50, 70));
		center.add(new JLabel());	
		center.add(new JLabel());	
		center.add(new JLabel());	
		center.add(new JLabel("Account Name:",JLabel.LEFT));
		center.add(accounTransfer);
		center.add(searchBottom);
		center.add(new JLabel("Enter Amount:"));
		center.add(amountT);
		center.add(transferBottom);
		center.add(new JLabel());	
		center.add(new JLabel());
		center.add(viewTranHis);
		this.revalidate();
		
	}
	void panelClear()
	{
		center.removeAll();
		accountNoT.setText("");
		amountT.setText("");
		oldP.setText("");
		newP.setText("");
		reNewP.setText("");
		depositMoney.setText("");
		withDrawtxt.setText("");
		
	}
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	@Override
	public boolean isPasswordMatch() {
		String a = new String(newP.getPassword());
		String b = new String(reNewP.getPassword());	
		if(a.equals(b))
			return true;
		
		return false;
	}
	@Override
    public boolean isPasswordValid() {
    	int countUp=0;
    	int countLow=0;
    	int digit=0;
    	String a= new String(newP.getPassword());
    	if(a.length()>8) {
    		for(int i=0 ; i<a.length();i++) {
    			char c= a.charAt(i);
    			if(Character.isUpperCase(c))
    			countUp++;
    			if(Character.isLowerCase(c))
    			countLow++;
    			if(Character.isDigit(c))
    				digit++;
    		}
    		if(countLow>=1 && countUp>=1 && digit>=1 ) {
    			countLow=0;
    			countUp=0;
    			digit=0;
    			return true;
    		}}
    	return false;
    }
	public void setColor() {
		profile.setBackground(Color.YELLOW);
		tranferMoney.setBackground(Color.YELLOW);
		deposit.setBackground(Color.YELLOW);
		withDraw.setBackground(Color.YELLOW);
		changePin.setBackground(Color.YELLOW);
		
	}
}
