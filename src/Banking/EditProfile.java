package Banking;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class EditProfile extends JFrame {

	private JPanel contentPane;
	private JTextField emailTxt;
	private JTextField addressTxt;
	private JTextField OccpationTxt;
	private JTextField phonetxt;
	
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
	JLabel lblNewLabel_6 = new JLabel("Phone");
	JLabel UserName = new JLabel("");
	
	JButton OKbuttom = new JButton("OK");
	JButton CancelButtom = new JButton("Cancel");
	
	
	public EditProfile(Account acc) {
		Integer year = Integer.parseInt(acc.user.getBirthdate().split("/")[0]);
		Integer month = Integer.parseInt(acc.user.getBirthdate().split("/")[1]);
		Integer day = Integer.parseInt(acc.user.getBirthdate().split("/")[2]);		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dobin\\OneDrive\\Desktop\\OOP\\image\\icons8-edit-file-16.png"));
		generateDate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 772, 621);
		setTitle("Edit Profile");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new LineBorder(new Color(128, 128, 128), 5));
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
		dayBox.setSelectedIndex(day-1);
		
		monthBox.setBounds(384, 197, 45, 21);
		contentPane.add(monthBox);
		monthBox.setSelectedIndex(month-1);
		yearBox.setSelectedIndex(0);
		
		yearBox.setBounds(477, 197, 81, 21);
		contentPane.add(yearBox);
		yearBox.setSelectedIndex(year-1900);
	
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(137, 137, 66, 24);
		contentPane.add(lblNewLabel_4);
		
		
		MaleButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		MaleButton.setBounds(308, 140, 103, 21);
		contentPane.add(MaleButton);
		
		FemaleButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		FemaleButton.setBounds(429, 140, 103, 21);
		contentPane.add(FemaleButton);
		if(acc.user.getSex().equals("Male")) {
			MaleButton.setSelected(true);	
		}
		else 
			FemaleButton.setSelected(true);
		
		emailTxt = new JTextField(acc.user.getEmail());
		emailTxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		emailTxt.setBounds(308, 248, 250, 26);
		contentPane.add(emailTxt);
		emailTxt.setColumns(10);
		
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(137, 312, 66, 24);
		contentPane.add(lblNewLabel_5);
		
		addressTxt = new JTextField(acc.user.getAddress());
		addressTxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		addressTxt.setBounds(308, 312, 250, 23);
		contentPane.add(addressTxt);
		addressTxt.setColumns(10);
		
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(137, 371, 81, 24);
		contentPane.add(lblNewLabel_3);
		
		OccpationTxt = new JTextField(acc.user.getOccupation());
		OccpationTxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		OccpationTxt.setBounds(308, 370, 250, 24);
		contentPane.add(OccpationTxt);
		OccpationTxt.setColumns(10);
		OKbuttom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkfill()) {
					String sex;
					String day;
					day= yearBox.getSelectedItem().toString()+ "/" + monthBox.getSelectedItem().toString()+"/"+dayBox.getSelectedItem().toString();
					if(FemaleButton.isSelected()){
						sex= "Female";
					}
					else{
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
				}}
				
				else
					JOptionPane.showMessageDialog(null, "Fill all","Error",JOptionPane.ERROR_MESSAGE);
			
			}});
		
		
		OKbuttom.setFont(new Font("Tahoma", Font.BOLD, 15));
		OKbuttom.setBounds(589, 509, 85, 30);
		contentPane.add(OKbuttom);
		CancelButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainMenu menu =new MainMenu(acc);
				menu.setVisible(true);
				menu.painUserDetail();
				
			}
		});
		
		CancelButtom.setFont(new Font("Tahoma", Font.BOLD, 15));
		CancelButtom.setBounds(447, 509, 85, 30);
		contentPane.add(CancelButtom);
		
		FemaleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MaleButton.isSelected() && FemaleButton.isSelected()) {
					MaleButton.setSelected(false);
				}
			}
		});
		MaleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(FemaleButton.isSelected() && MaleButton.isSelected()) {
					FemaleButton.setSelected(false);
				}
			}
		});
		
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(137, 436, 81, 30);
		contentPane.add(lblNewLabel_6);
		
		phonetxt = new JTextField(acc.user.getPhoneNo());
		phonetxt.setFont(new Font("Tahoma", Font.BOLD, 13));
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
