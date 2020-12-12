package Banking;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public  class ViewHistory extends JFrame {
	

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	Account account;
	DefaultTableModel dtm = new  DefaultTableModel();
    @SuppressWarnings("rawtypes")
	Vector VecA = new Vector();
    @SuppressWarnings("rawtypes")
	Vector VecB =new Vector();
    @SuppressWarnings("rawtypes")
	Vector VecC ;
    @SuppressWarnings("unchecked")
	public void VectorX() {
    	VecA.add("Type");
    	VecA.add("Transfer Money To");
    	VecA.add("Date");
    	VecA.add("Time");
    	VecA.add("Cost");
    	VecA.add("Change Amount");
    	
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void putDeposit() {
    	
    	for(int i=0;i<account.vhis.trans.size();i++) {
    	    if(account.vhis.trans.get(i).getType().equals("WithDraw")) { 		
    	    VecC =new Vector();
    	    VecC.add(account.vhis.trans.get(i).getType());
    	    VecC.add(account.vhis.trans.get(i).getTRransferto());
    	    VecC.add(account.vhis.trans.get(i).getDate());
    	    VecC.add(account.vhis.trans.get(i).getTimer());
    	    VecC.add(account.vhis.trans.get(i).getCost()+"");
    	    VecC.add(account.vhis.trans.get(i).getChangedAmount());
    	    VecB.add(VecC);
    	    
    }
    	}
    }
    
	@SuppressWarnings("unchecked")
	public ViewHistory(Account ac) {
		this.account=ac;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		putDeposit();
		VectorX();
		JLabel lblNewLabel = new JLabel("History of exchange");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(44, 26, 197, 61);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 126, 782, 319);
		contentPane.add(scrollPane);
		
		dtm.setDataVector(VecB, VecA);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"     Type", "   TranferMoneyTo", "      Date", "     Time", "Changed Budget", "Available Budget"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(114);
		table.getColumnModel().getColumn(4).setPreferredWidth(96);
		table.getColumnModel().getColumn(5).setPreferredWidth(112);
		scrollPane.setViewportView(table);
		table.setModel(dtm);
	}
}
