package Banking;

public class SavingAccount extends Account {
	
	
    SavingAccount(int acc,String pin,Double balance,UserInformation u) {
    	super(u);
		super.setAccountNo(acc);
		super.setPIN(pin);
		super.setBalance(balance);
		setMinBalance(10);
		setWithdrawalLimit(10, 1000);
	}
	public void setMinBalance(double a)
	{
		minBalance=a;
	}
	
	public void setWithdrawalLimit(double l, double h)
	{
		minWithdrawal=l;
		maxWithdrawal=h;
	}
	public int getAccountType()
	{
		return Account.SAVINGS_ACCOUNT;
	}
}

