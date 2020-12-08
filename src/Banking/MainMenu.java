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
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;


@SuppressWarnings("serial")
public class MainMenu extends JFrame implements Matchable {
	Database db = Database.getInstance();
	Account ac;
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
	JButton logOut = new JButton("Log out");
	
	JButton WithDrawButtom = new JButton("WithDraw");
	JButton transferBottom = new JButton("Transfer");
	JButton withdrawalBottom = new JButton("Withdraw");
	JButton depositBottom = new JButton("Deposit");
	JButton payBillBottom = new JButton("Pay");
	JButton PinBotton = new JButton("ChangePIN");
	JButton searchBottom =new JButton("Search");
	JButton editBottom =new JButton("Edit Profile",new ImageIcon("C:\\Users\\dobin\\OneDrive\\Máy tính\\OOP\\image\\icons8-edit-file-16.png"));

	JLabel lblNewLabel_1 = new JLabel("Wellcome");
	JPanel center = new JPanel();

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
		setBounds(100, 100, 924, 592);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel central = new JPanel();
		getContentPane().add(central, BorderLayout.CENTER);
		central.setLayout(new BorderLayout(0, 50));
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		central.add(panel_3, BorderLayout.WEST);
		profile.setBackground(Color.YELLOW);
		profile.setForeground(Color.BLACK);
		
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painUserDetail();
					
			}
		});
		panel_3.setLayout(new GridLayout(11, 1, 7, 10));
		profile.setHorizontalAlignment(SwingConstants.LEFT);
		profile.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(profile);
		
		withDraw.setHorizontalAlignment(SwingConstants.LEFT);
		withDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painWithdraw();
				
			}
		});
		withDraw.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(withDraw);
		deposit.setHorizontalAlignment(SwingConstants.LEFT);
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		tranferMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tranferMoney();
			}
		});
		
			tranferMoney.setFont(new Font("Tahoma", Font.BOLD, 13));
			panel_3.add(tranferMoney);
		    changePin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paineChangePin();
			}
		});
		
		changePin.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(changePin);
		FlowLayout flowLayout = (FlowLayout) center.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(1);
		flowLayout.setHgap(10);
		center.setBackground(Color.ORANGE);
		
		central.add(center, BorderLayout.CENTER);
			
		JPanel panel1 = new JPanel();
		FlowLayout fl_panel1 = (FlowLayout) panel1.getLayout();
		fl_panel1.setVgap(40);
		fl_panel1.setHgap(40);
		getContentPane().add(panel1, BorderLayout.NORTH);
		

		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel1.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
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
	}
	protected void painWithdraw() {
		panelClear();
		center.setBorder(new EmptyBorder(50, 100, 30,200));
		center.setLayout(new GridLayout(4, 3, 20, 70));
	    center.add(new JLabel("User Name: "));
	    center.add(new JLabel(ac.user.getUserName()));
	    center.add(new JLabel());
	    center.add(new JLabel("Available Balance: "));
	    center.add(new JLabel(""+ac.getBalance()+" Dollars"));
	    center.add(new JLabel());
	    center.add(new JLabel("With Draw"));
	    center.add(withDrawtxt);
	    center.add(new JLabel());
	    center.add(new JLabel());
	    center.add(new JLabel());
        center.add(WithDrawButtom);	    
        this.revalidate();

		
	}
	protected void paineChangePin() {
		panelClear();
		center.setBorder(new EmptyBorder(50, 120, 50,50));
		center.setLayout(new GridLayout(4, 2, 50, 70));
		center.add(new JLabel(" Current Password: "));
		center.add(oldP);
		center.add(new JLabel("New Password: "));
		center.add(newP);
		center.add(new JLabel("Comform: "));
		center.add(reNewP);
		center.add(new JLabel());
		center.add(PinBotton);
		this.revalidate();
		
	}
	protected void paineDeposit() {
		panelClear();
		center.setBorder(new EmptyBorder(50, 100, 30,30));
		center.setLayout(new GridLayout(4, 3, 20, 70));
		center.add(new JLabel("User Name: "));
		center.add(new JLabel(ac.user.getUserName()));
		center.add(new JLabel());
		center.add(new JLabel("Available Balance: "));
		center.add(new JLabel(""+ac.getBalance()+" Dollars"));
		center.add(new JLabel());
		center.add(new JLabel("Deposit: "));
		center.add(depositMoney);
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(depositBottom);
		this.revalidate();
		
	}
	protected void painUserDetail() {
		panelClear();
		center.setBorder(new EmptyBorder(50, 150, 50,200));
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
		center.setBorder(new EmptyBorder(80, 120, 70,10));
		center.setLayout(new GridLayout(3, 2, 60, 70));
		center.add(new JLabel("Account Name:",JLabel.LEFT));
		center.add(accounTransfer);
		center.add(new JLabel("Enter Amount:"));
		center.add(amountT);
		center.add(new JLabel());
		center.add(transferBottom);
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
}
