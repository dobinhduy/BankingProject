package Banking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class LoginWindow extends JFrame {

	private JPanel contentPane;
	private JTextField Usernametxt;
	Database bd=Database.getInstance();
	JButton signin = new JButton("Sign in",new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\icons8-add-user-male-16.png"));
	JButton login = new JButton("Login",new ImageIcon("D:\\Code\\BankingOOP\\BankingProject\\src\\icons8-login-16.png"));
	private JPasswordField pass;

	public static void main(String[] args) {
		new LoginWindow();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LoginWindow() {
		this.addWindowListener(new WindowAdapter() {
		});
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 602, 532);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Usernametxt = new JTextField();
		Usernametxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		Usernametxt.setBounds(176, 166, 278, 29);
		panel.add(Usernametxt);
		Usernametxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(72, 165, 97, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(72, 261, 80, 22);
		panel.add(lblNewLabel_1);
		
		
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					contentPane.setVisible(false);		
					new SignUpWindow();
			
					}		
		});
		signin.setFont(new Font("Tahoma", Font.BOLD, 11));
		signin.setBounds(192, 343, 97, 29);
		panel.add(signin);
			login.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
						Account acc;
						if((acc=bd.getAccount(Usernametxt.getText(),pass.getText()) ) !=null) {							
							dispose();
							MainMenu ac=new MainMenu(acc);
							ac.setVisible(true);
							}
						else
						{
							JOptionPane.showMessageDialog(null, "Account is not correct", "Login False",JOptionPane.ERROR_MESSAGE);
						}
					
				
				}});
		
		login.setFont(new Font("Tahoma", Font.BOLD, 11));
		login.setBounds(342, 343, 91, 29);
		panel.add(login);
		
		JLabel lblNewLabel_2 = new JLabel("Login Window");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(176, 61, 278, 36);
		panel.add(lblNewLabel_2);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.BOLD, 13));
		pass.setBounds(176, 258, 278, 29);
		panel.add(pass);
	}
}
