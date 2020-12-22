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
import java.awt.Toolkit;


@SuppressWarnings("serial")
public class MainMenu extends JFrame implements MatchAble {
	Database db = Database.getInstance();
	Account ac;
	History his;
	String currentTime = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
	JTextField accountNoT = new JTextField("",25);
	JTextField amountT = new JTextField("",20);
	JTextField depositMoney =new JTextField("", 15);
	JTextField withDrawtxt =new JTextField("", 15);
	JTextField accounTransfer =new JTextField("", 15);

	JPasswordField oldP= new JPasswordField("",20);
	JPasswordField newP= new JPasswordField("",20);
	JPasswordField reNewP= new JPasswordField("",20);
	
	JButton profile = new JButton("Profile  ",new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\man-user.png"));
	JButton withDraw = new JButton("WithDrawl",new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\withdraw (1).png"));
	JButton deposit = new JButton("Deposit",new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\deposit.png"));
	JButton tranferMoney = new JButton("Tranfer Money",new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\transfer-money.png"));
	JButton changePin = new JButton("Change Pin", new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\changePin.png"));
	JButton logOut = new JButton("Log out",new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\logout.png"));
	
	JButton WithDrawButton = new JButton("WithDraw",new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\withdrawal.png"));
	JButton transferBotton = new JButton("Transfer", new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\transfer-money.png"));
	JButton withdrawalBotton = new JButton("Withdraw", new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\withdrawal.png"));
	JButton depositBotton = new JButton("Deposit", new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\donation.png"));
	JButton PinBotton = new JButton("ChangePIN", new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\password.png"));
	JButton searchBotton =new JButton("Search",new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\loupe.png"));
	JButton editBotton =new JButton("Edit Profile",new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\editpro.png"));
	JButton viewHistory =new JButton("View History",new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\eye.png") );
	
	JLabel time = new JLabel(" ");
	JScrollPane scrollPane = new JScrollPane();
	JPanel center = new JPanel();
	private final JLabel lblNewLabel = new JLabel("            ");
	private final JButton currentBalance = new JButton("Current Balance");
	public MainMenu(Account acc) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dobin\\OneDrive\\Desktop\\OOP\\image\\banking.png"));
		this.ac=acc;
		statTime();
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				db.saveData();
				System.exit(0);
			}
		});
		editBotton.setSize(10, 10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 50, 1074, 712);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel central = new JPanel();
		getContentPane().add(central, BorderLayout.CENTER);
		central.setLayout(new BorderLayout(0, 50));
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.WHITE);
		panel_3.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_3.setBackground(Color.DARK_GRAY);
		central.add(panel_3, BorderLayout.WEST);
		profile.setHorizontalAlignment(SwingConstants.LEFT);
		profile.setBackground(new Color(60, 179, 113));
		profile.setForeground(Color.BLACK);
		
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColor();
				profile.setBackground(Color.ORANGE);
				painUserDetail();
					
			}
		});
		panel_3.setLayout(new GridLayout(6, 1, 30, 23));
		profile.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(profile);
		withDraw.setHorizontalAlignment(SwingConstants.LEFT);
		withDraw.setBackground(new Color(60, 179, 113));
		withDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColor();
				withDraw.setBackground(Color.ORANGE);
				painWithdraw();
				
			}
		});
		withDraw.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(withDraw);
		deposit.setHorizontalAlignment(SwingConstants.LEFT);
		deposit.setBackground(new Color(60, 179, 113));
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColor();
				deposit.setBackground(Color.orange);
				paineDeposit();
			}
		});
		editBotton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EditProfile edit =new EditProfile(acc);
				edit.setVisible(true);
				dispose();
				
				
			}
		});
		deposit.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(deposit);
		tranferMoney.setHorizontalAlignment(SwingConstants.LEFT);
		tranferMoney.setBackground(new Color(60, 179, 113));
		tranferMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColor();
				tranferMoney.setBackground(Color.ORANGE);
				tranferMoney();
			}
		});
		
		tranferMoney.setFont(new Font("Tahoma", Font.BOLD, 13));
			panel_3.add(tranferMoney);
		    changePin.setHorizontalAlignment(SwingConstants.LEFT);
		    changePin.setBackground(new Color(60, 179, 113));
		    changePin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColor();
				changePin.setBackground(Color.ORANGE);
				paineChangePin();
			}
		});
		currentBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColor();
				currentBalance.setBackground(Color.ORANGE);
				painBalance();
			}
		});
		currentBalance.setBackground(new Color(60, 179, 113));
		currentBalance.setIcon(new ImageIcon("C:\\Users\\dobin\\OneDrive\\Desktop\\OOP\\image\\money (1).png"));
		currentBalance.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		panel_3.add(currentBalance);
		
		changePin.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(changePin);
		center.setBackground(new Color(127, 255, 212));
		
		central.add(center, BorderLayout.CENTER);
		center.setLayout(null);
		
		
			
		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(210, 105, 30), 3));
		panel1.setBackground(new Color(30, 144, 255));
		getContentPane().add(panel1, BorderLayout.NORTH);
		panel1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 40));
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\schedule.png"));
		panel1.add(lblNewLabel_1);
		
		
		time.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel1.add(time);
		
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel1.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(219, 112, 147));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(255, 0, 0), 4));
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
					db.saveData();
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
		depositBotton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!depositMoney.getText().isEmpty()) {
				if(isNumeric(depositMoney.getText())) {
					if(Double.parseDouble(depositMoney.getText())>= 10) {
						ac.depositMoney(Double.parseDouble(depositMoney.getText()));
			            JOptionPane.showMessageDialog(null, "Deposit Successues");
			            String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
			            String a= timeStamp.split("_")[0];
				    	 String b = timeStamp.split("_")[1];	
			            ac.vhis.addTranlist(new Transaction("Deposit","","", a, b, 0.0, "+" + depositMoney.getText()));
						paineDeposit();
					}
					else
						JOptionPane.showInternalConfirmDialog(null,	"The number of money must be greater then 10 Dollars");
				}
				else
					JOptionPane.showMessageDialog(null, "Not contain characters");
				
			}
			else
				JOptionPane.showMessageDialog(null,"Please, input the amount");
			}
		});
		WithDrawButton.addActionListener(new ActionListener() {
			
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
				    	 ac.setBalance(ac.getBalance()-Double.parseDouble(withDrawtxt.getText())-5.0);
				    	 String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
				    	 String a= timeStamp.split("_")[0];
				    	 String b = timeStamp.split("_")[1];	    	
				    	 acc.vhis.addTranlist(new Transaction("WithDraw","","",  a, b, 5.0, "-" + withDrawtxt.getText()));
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
		transferBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			       if(db.isAccExist(accounTransfer.getText())) {
			    	  if(isNumeric(amountT.getText())) {
			    	     if(ac.transferMoney(db.getAccount(accounTransfer.getText()), Double.parseDouble(amountT.getText()))) {
			    	    	 String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
				    	     String a= timeStamp.split("_")[0];
				    	     String b = timeStamp.split("_")[1];	
				    	     ac.vhis.addTranlist(new Transaction("Transfer Money", accounTransfer.getText(), "",a, b, 2.0, "-"+amountT.getText()));
				    	     ac.setBalance(ac.getBalance()-2.0);
				    	     JOptionPane.showMessageDialog(null, "Transfer successful");	
				    	     db.getAccount(accounTransfer.getText()).vhis.addTranlist(new Transaction("Receive Money", "", ac.user.getUserName(),
				    	    		 a, b, 0.0	, "+"+amountT.getText()));
				    	 }
			    		    	    		  
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
		viewHistory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		    dispose();
		    ViewHistory view =new ViewHistory(ac);
		    view.setVisible(true);
				
			}
		});
		searchBotton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			if(!accounTransfer.getText().isEmpty()) {
		        if(db.isAccExist(accounTransfer.getText())) {
		        	JOptionPane.showMessageDialog(null, "Found","",JOptionPane.INFORMATION_MESSAGE);
		        }
		        else
		        	JOptionPane.showMessageDialog(null, "Account is not exist","",JOptionPane.ERROR_MESSAGE);
			}
			else
			        JOptionPane.showMessageDialog(null, "Please input the account name","Note",JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
	
	protected void painBalance() {
		panelClear();
		center.setBorder(new EmptyBorder(160, 180, 160, 250));
		center.setLayout(new GridLayout(0,2,150,0));
		center.add(new JLabel("Available Amount"));
		center.add(new JLabel(""+ac.getBalance()+" dollars"));
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(viewHistory);
		
		this.revalidate();
		
	}

	protected void painWithdraw() {
		panelClear();
		center.setBorder(new EmptyBorder(100, 180, 100,0));
		center.setLayout(new GridLayout(3, 4, 30, 70));
	    center.add(new JLabel("User Name: "));
	    center.add(new JLabel(ac.user.getUserName()));
	    center.add(new JLabel());
	    center.add(new JLabel());
	    center.add(new JLabel("Enter the amount: "));
	    center.add(withDrawtxt);
	    center.add(WithDrawButton);	
	    center.add(new JLabel());   
	    center.add(new JLabel());
	    center.add(new JLabel());
	    center.add(new JLabel()); 
	    center.add(new JLabel());
	       
        this.revalidate();

	
	}
	protected void paineChangePin() {
		panelClear();
		center.setBorder(new EmptyBorder(70, 180, 20,200));
		center.setLayout(new GridLayout(4, 3, 20, 70));
		center.add(new JLabel("Current Password: "));
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
		center.setBorder(new EmptyBorder(100, 180, 100,0));
		center.setLayout(new GridLayout(3, 4, 30, 70));
		center.add(new JLabel("User Name: "));
		center.add(new JLabel(ac.user.getUserName()));
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(new JLabel("Deposit: "));
		center.add(depositMoney);
		center.add(depositBotton);
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(new JLabel());
		
		this.revalidate();
		
	}
	protected void painUserDetail() {
		panelClear();
	
		center.setBorder(new EmptyBorder(50, 200, 50,250));
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
		center.add(editBotton);	
		this.revalidate();
		
	}
	private void tranferMoney() {
		panelClear();
		center.setBorder(new EmptyBorder(20, 120, 70,250));
		center.setLayout(new GridLayout(4, 3, 50, 70));
		center.add(new JLabel());	
		center.add(new JLabel());	
		center.add(new JLabel());	
		center.add(new JLabel("Account Name:",JLabel.LEFT));
		center.add(accounTransfer);
		center.add(searchBotton);
		center.add(new JLabel("Enter Amount:"));
		center.add(amountT);
		center.add(transferBotton);
		center.add(new JLabel());	
		center.add(new JLabel());
		center.add(new JLabel());
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
		profile.setBackground(new Color(60, 179, 113));
		tranferMoney.setBackground(new Color(60, 179, 113));
		deposit.setBackground(new Color(60, 179, 113));
		withDraw.setBackground(new Color(60, 179, 113));
		changePin.setBackground(new Color(60, 179, 113));
		currentBalance.setBackground(new Color(60, 179, 113));
		
	}
	public void statTime(){
	    new Thread(new Runnable() {

	        @Override
	        public void run() {
	            try {
	                while (true) {                            
	                    java.util.Date d = new java.util.Date();
	                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  hh:mm:ss a");
	                    time.setText(sdf.format(d));
	                    Thread.sleep(1000);

	                }

	            } catch (Exception e) {
	            }
	        }
	    }).start();
	}
}
