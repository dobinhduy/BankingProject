package Banking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

	
public class Database {
	private static Database instance;
	ArrayList<Account> listofacc=new ArrayList<>();
   
	public static Database getInstance() {
		if(instance==null) {
		instance=new Database();
		}
		return instance;   
}
	private Database() {
		this.loadData();
	}
	public boolean isAccountNumberUnique(String accountNum) {
		for(int i=0;i<listofacc.size();i++) {
			if(listofacc.get(i).user.getUserName().equals(accountNum)) {
				return false;
			}
		}
		
		return true;
	}
	
	Account getAccount(String acc) {
		for(int i=0;i<listofacc.size();i++) {
			if(listofacc.get(i).user.getUserName().equals(acc))
				return listofacc.get(i);
		}
		return null;
		
	}
	Account getAccount(String acc,String pin) {
		for(int i=0;i<listofacc.size();i++) {
			if(listofacc.get(i).user.getUserName().equals(acc)&&listofacc.get(i).getPIN().equals(pin))
				return listofacc.get(i);
		}
		return null;
	}

	boolean isAccExist(String name) {
		for(int i=0;i<listofacc.size();i++) {
			if(listofacc.get(i).user.getUserName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	void addAccount(Account acc) {
		listofacc.add(acc);
	}
	void saveData() {
		System.out.println("Saved");
		try (BufferedWriter bfw=new BufferedWriter(new FileWriter(new File("D:\\Code\\BankingOOP\\BankingProject\\src\\AccountList1.txt"),false))){
			
			for(int i=0;i<listofacc.size();i++) {
				bfw.write(listofacc.get(i).toString());
			}
			
			bfw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unlikely-arg-type")
	private void loadData() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(new  File("D:\\Code\\BankingOOP\\BankingProject\\src\\AccountList1.txt")));
			String type;
			
			while((type=bf.readLine()) != null) {
				History his=new History();
				Account acc;
				String accNo = bf.readLine().split(": ")[1];
				String pin = bf.readLine().split(": ")[1];
				String userName = bf.readLine().split(": ")[1];
				String email = bf.readLine().split(": ")[1];
				String phoneNumber = bf.readLine().split(": ")[1];
				String address = bf.readLine().split(": ")[1];
				String occ = bf.readLine().split(": ")[1];
				String sex = bf.readLine().split(": ")[1];
				String dOb = bf.readLine().split(": ")[1];
				String balance = bf.readLine().split(": ")[1];
				String numTrans=   bf.readLine().split(": ")[1];
				for(int i=0; i< Integer.parseInt(numTrans);i++) {
					String typeH= bf.readLine().split(": ")[1];
					String dateH =bf.readLine().split(": ")[1];
					String time = bf.readLine().split(": ")[1];
					String cost = bf.readLine().split(": ")[1];
					String change= bf.readLine().split(": ")[1];
					his.addTranlist(new Transaction(typeH, dateH, time, Double.parseDouble(cost), change));
				}
			
				if(type.equals(Account.SAVINGS_ACCOUNT)){				
					acc = new SavingAccount(Integer.parseInt(accNo), pin,Double.parseDouble(balance), new UserInformation(userName,email,phoneNumber
									,address, occ, sex, dOb),his);
					
				}
				else {
					acc = new CurrentAccount(Integer.parseInt(accNo), pin,Double.parseDouble(balance), new UserInformation(userName,email,phoneNumber
							,address, occ, sex, dOb),his);
					
				}
				addAccount(acc);
			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
	}
	}
