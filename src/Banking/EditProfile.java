package Banking;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EditProfile extends JFrame {

	private JPanel contentPane;
	private JTextField emailTxt;
	private JTextField addressTxt;
	private JTextField OccpationTxt;
	
	JComboBox<Integer> dayBox = new JComboBox<Integer>();
	JComboBox<Integer> monthBox = new JComboBox<Integer>();
	JComboBox<Integer> yearBox = new JComboBox<Integer>();
	
	JRadioButton FemaleButton = new JRadioButton("Female");
	JRadioButton MaleButton = new JRadioButton("Male");
	JLabel lblNewLabel = new JLabel("UserName");
	JLabel lblNewLabel_1 = new JLabel("Birthday");
	JLabel lblNewLabel_4 = new JLabel("Sex");
	JLabel lblNewLabel_5 = new JLabel("Address");
	JLabel lblNewLabel_3 = new JLabel("Occupation");
	JLabel lblNewLabel_2 = new JLabel("Email");
	JButton btnNewButton_1 = new JButton("Cancel");
	JLabel UserName = new JLabel("");
	
	JButton btnNewButton = new JButton("OK");
	private JTextField phonetxt;
	public EditProfile(Account acc) {
		generateDate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(137, 84, 81, 24);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(137, 194, 81, 24);
		contentPane.add(lblNewLabel_1);
		

		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(137, 248, 81, 30);
		contentPane.add(lblNewLabel_2);
		
		UserName.setFont(new Font("Tahoma", Font.BOLD, 13));
		UserName.setBounds(308, 84, 173, 20);
		UserName.setText(acc.user.getUserName());
		contentPane.add(UserName);
		
		dayBox.setBounds(308, 197, 39, 21);
		contentPane.add(dayBox);
		
		monthBox.setBounds(384, 197, 45, 21);
		contentPane.add(monthBox);
		
		yearBox.setBounds(477, 197, 81, 21);
		contentPane.add(yearBox);
	
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(137, 137, 66, 24);
		contentPane.add(lblNewLabel_4);
		
		
		MaleButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		MaleButton.setBounds(308, 140, 103, 21);
		contentPane.add(MaleButton);
	    
		
		FemaleButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		FemaleButton.setBounds(429, 140, 103, 21);
		contentPane.add(FemaleButton);
		
		emailTxt = new JTextField();
		emailTxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		emailTxt.setBounds(308, 248, 250, 26);
		contentPane.add(emailTxt);
		emailTxt.setColumns(10);
		
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(137, 312, 66, 24);
		contentPane.add(lblNewLabel_5);
		
		addressTxt = new JTextField();
		addressTxt.setBounds(308, 312, 250, 23);
		contentPane.add(addressTxt);
		addressTxt.setColumns(10);
		
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(137, 371, 81, 24);
		contentPane.add(lblNewLabel_3);
		
		OccpationTxt = new JTextField();
		OccpationTxt.setBounds(308, 370, 250, 24);
		contentPane.add(OccpationTxt);
		OccpationTxt.setColumns(10);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkfill()) {
					String sex;
					String day;
					day= yearBox.getSelectedItem().toString()+ "/" + monthBox.getSelectedItem().toString()+"/"+dayBox.getSelectedItem().toString();
					if(FemaleButton.isSelected()){
						sex= "Female";
					}
					else
						sex="Male";
					acc.user.setSex(sex);
					acc.user.setBirthdate(day);
					acc.user.setEmail(emailTxt.getText());
					acc.user.setAddress(addressTxt.getText());
					acc.user.setOccupation(OccpationTxt.getText());
					acc.user.setPhoneNo(phonetxt.getText());
					JOptionPane.showMessageDialog(null, "Edit Successful");
					dispose();
					MainMenu a=  new MainMenu(acc);
					a.painUserDetail();
					a.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Fill all","Error",JOptionPane.ERROR_MESSAGE);
			}
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(589, 509, 85, 30);
		contentPane.add(btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainMenu menu =new MainMenu(acc);
				menu.setVisible(true);
				menu.painUserDetail();
				
			}
		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(447, 509, 85, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Phone");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(137, 436, 81, 30);
		contentPane.add(lblNewLabel_6);
		
		phonetxt = new JTextField();
		phonetxt.setBounds(308, 436, 250, 26);
		contentPane.add(phonetxt);
		phonetxt.setColumns(10);
	}
	boolean checkfill() {
		if(emailTxt.getText().isEmpty() || addressTxt.getText().isEmpty()
					|| OccpationTxt.getText().isEmpty()) 
		{
			return false;
		}
		if( (!MaleButton.isSelected()) && (!FemaleButton.isSelected())) {
			return false;
		}
		return true;
	}
	
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
}
