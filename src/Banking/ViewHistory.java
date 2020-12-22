package Banking;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public  class ViewHistory extends JFrame {
	

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	Account account;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox = new JComboBox();
    @SuppressWarnings("rawtypes")
	Vector VecA = new Vector();
    @SuppressWarnings("rawtypes")
	Vector VecB =new Vector();
    @SuppressWarnings("rawtypes")
	Vector VecC ;
    @SuppressWarnings("rawtypes")
	Vector VecD =new Vector();
    @SuppressWarnings("rawtypes")
	Vector VecE =new Vector();
    @SuppressWarnings("rawtypes")
	Vector VecF =new Vector();
    @SuppressWarnings("rawtypes")
	Vector VecG =new Vector();
    @SuppressWarnings("rawtypes")
	Vector VecH =new Vector();
    
    
	@SuppressWarnings("unchecked")
	public void VectorA() {
		VecA.add("Order");
    	VecA.add("Type");
    	VecA.add("Date");
    	VecA.add("Time");
    	VecA.add("Fees($)");
    	VecA.add("Changed Amount($)");
    	
    }
    @SuppressWarnings("unchecked")
	public void VectorD() {
    	VecD.add("Order");
    	VecD.add("Type");
    	VecD.add("Receiver");
    	VecD.add("Date");
    	VecD.add("Time");
    	VecD.add("Fees ($)");
    	VecD.add("Changed Amount($)");
    }
    @SuppressWarnings("unchecked")
	public void VectorE() {
    	VecE.add("Order");
    	VecE.add("Type");
    	VecE.add("Sender");
    	VecE.add("Date");
    	VecE.add("Time");
    	VecE.add("Fees($)");
    	VecE.add("Changed Amount($)");
    }
    @SuppressWarnings("unchecked")
	public void VectorG() {
    	VecG.add("Order");
    	VecG.add("Type");
    	VecG.add("Receiver");
    	VecG.add("Sender");
    	VecG.add("Date");
    	VecG.add("Time");
    	VecG.add("Fees($)");
    	VecG.add("Changed Amount($)");
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void painAll() {
    	int count = 1;
    	for(int i=0;i<account.vhis.trans.size();i++) {
	    	    VecC =new Vector();
	    	 
	    	    VecC.add(count);
	      	    VecC.add(account.vhis.trans.get(i).getType());
	    	    VecC.add(account.vhis.trans.get(i).getTRransferto());
	    	    VecC.add(account.vhis.trans.get(i).getTranferFrom());
	    	    VecC.add(account.vhis.trans.get(i).getDate());
	    	    VecC.add(account.vhis.trans.get(i).getTimer());
	    	    VecC.add(account.vhis.trans.get(i).getCost()+"");
	    	    VecC.add(account.vhis.trans.get(i).getChangedAmount());
	    	    VecH.add(VecC);
	    	    count ++;
	    	    }}
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void painWithdraw() {
    	int count = 1;
		for(int i=0;i<account.vhis.trans.size();i++) {
			if(account.vhis.trans.get(i).getType().equals("WithDraw")) {
	    	    VecC =new Vector();
	    	    VecC.add(count);
	    	    VecC.add(account.vhis.trans.get(i).getType());
	    	    VecC.add(account.vhis.trans.get(i).getDate());
	    	    VecC.add(account.vhis.trans.get(i).getTimer());
	    	    VecC.add(account.vhis.trans.get(i).getCost()+"");
	    	    VecC.add(account.vhis.trans.get(i).getChangedAmount());
	    	    VecB.add(VecC);    
	    	    count ++;
	    	    }}}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void painDeposit() {
		int count = 1;
			for(int i=0;i<account.vhis.trans.size();i++) {
			if(account.vhis.trans.get(i).getType().equals("Deposit")) {
	    	    VecC =new Vector();
	    	    VecC.add(count);
	    	    VecC.add(account.vhis.trans.get(i).getType());
	    	    VecC.add(account.vhis.trans.get(i).getDate());
	    	    VecC.add(account.vhis.trans.get(i).getTimer());
	    	    VecC.add(account.vhis.trans.get(i).getCost()+"");
	    	    VecC.add(account.vhis.trans.get(i).getChangedAmount());
	    	    VecB.add(VecC);   
	    	    count ++;
			}
			}}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void paineTranferTo() {
		int count = 1;
	      
		for(int i=0;i<account.vhis.trans.size();i++) {
			if(account.vhis.trans.get(i).getType().equals("Transfer Money")) {		
	    	    VecC =new Vector();
	    	    VecC.add(count);
	    	    VecC.add(account.vhis.trans.get(i).getType());
	    	    VecC.add(account.vhis.trans.get(i).getTRransferto());
	    	    VecC.add(account.vhis.trans.get(i).getDate());
	    	    VecC.add(account.vhis.trans.get(i).getTimer());
	    	    VecC.add(account.vhis.trans.get(i).getCost()+"");
	    	    VecC.add(account.vhis.trans.get(i).getChangedAmount());
	    	    VecB.add(VecC); 
	    	    count++;
		
	}}}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void painReceive() {
		int count = 1;
		for(int i=0;i<account.vhis.trans.size();i++) {
			if(account.vhis.trans.get(i).getType().equals("Receive Money")) {
	    	    VecC =new Vector();
	    	    VecC.add(count);
	    	    VecC.add(account.vhis.trans.get(i).getType());
	    	    VecC.add(account.vhis.trans.get(i).getTranferFrom());
	    	    VecC.add(account.vhis.trans.get(i).getDate());
	    	    VecC.add(account.vhis.trans.get(i).getTimer());
	    	    VecC.add(account.vhis.trans.get(i).getCost()+"");
	    	    VecC.add(account.vhis.trans.get(i).getChangedAmount());
	    	    VecF.add(VecC); 
	    	    count ++;
	}}}


	public ViewHistory(Account ac) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dobin\\OneDrive\\Desktop\\OOP\\image\\eye.png"));
	    pain();
		this.account=ac;
		}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void pain() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 611);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("History of exchange");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(55, 10, 197, 61);
		contentPane.add(lblNewLabel);
		DefaultTableModel dtm = new  DefaultTableModel() ;
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 126, 782, 319);
		contentPane.add(scrollPane);
		
		table = new JTable() {
			  @Override
			  public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
			  }
		      
		      };
		
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{ null, null, null, null, null},
			},
			new String[] {
				"", "", "", "", "", ""
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(114);
		table.getColumnModel().getColumn(4).setPreferredWidth(96);
		table.getColumnModel().getColumn(5).setPreferredWidth(112);
		scrollPane.setViewportView(table);

		
		JButton okButton = new JButton("BACK");
		okButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		okButton.setBounds(756, 512, 85, 21);
		contentPane.add(okButton);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Withdraw", "Deposit", "Transfer Money", "Receive Money"}));
		comboBox.setBounds(517, 83, 168, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Select Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(381, 81, 126, 21);
		contentPane.add(lblNewLabel_1);
		VectorA();
		VectorD();
		VectorE();
		VectorG();
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()==1) {
					VecB.clear();
					painWithdraw();	
					dtm.setDataVector(VecB, VecA);		
					table.setModel(dtm);
					sort();
			
				 }
				if(comboBox.getSelectedIndex()==2) {
					VecB.clear();
					painDeposit();
					dtm.setDataVector(VecB, VecA);
					table.setModel(dtm);
					sort();
				}
				if(comboBox.getSelectedIndex()==3) {
			        VecB.clear();
					paineTranferTo();
					dtm.setDataVector(VecB, VecD);
					table.setModel(dtm);
					sort();
				}
				if(comboBox.getSelectedIndex()==4) {
					VecF.clear();
					painReceive();
					dtm.setDataVector(VecF, VecE);
					table.setModel(dtm);
					sort();
				}
				if(comboBox.getSelectedIndex()==0) {
					if(account.vhis.getSize()==0) {
						JOptionPane.showMessageDialog(null, "You have no transaction",null,JOptionPane.INFORMATION_MESSAGE);
					}
					else {
					VecH.clear();
					painAll();
					dtm.setDataVector(VecH, VecG);
					table.setModel(dtm);
					sort();
				}}
				
			}
		});
		
	
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(719, 83, 85, 21);
		contentPane.add(btnNewButton);
	    okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainMenu menu= new MainMenu(account);
				menu.setVisible(true);
				
			}
		});
	}
	public void sort() {
		TableRowSorter<TableModel> sorter= new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		table.validate();
		table.setAutoCreateRowSorter(true);
	}
	

	
}

