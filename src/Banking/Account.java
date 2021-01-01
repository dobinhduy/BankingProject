package Banking;


public abstract class Account
{
	public static final int SAVINGS_ACCOUNT=1;
	public static final int CURRENT_ACCOUNT=2;
	
	public static final int INSUFFICIENT_BALANCE=1;
	public static final int WITHDRAWAL_LIMIT_UNDER=2;
	public static final int WITHDRAWAL_LIMIT_OVER=3;
	
	private int accountNo;
	private String password;
	protected UserInformation user;	
	protected History vhis;
	protected double balance;
	protected double minBalance;
	protected double minWithdrawal;
	protected double maxWithdrawal;
	
	boolean isActivated;

	public abstract void setMinBalance(double a);
	public abstract void setWithdrawalLimit(double l, double h);
	public abstract int getAccountType();
	Account(int accNo,String password,UserInformation u, History his){
		this.accountNo=accNo;
		this.password=password;
		vhis=his;
		user=u;
	}
	public Account(UserInformation u,History his) {
		user=u;
		vhis=his;
		
	}
	
	double getBalance()
	{
		return balance;
	}
	void setBalance(double b)
	{
		balance=b;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	String getPIN()
	{
		return password;
	}
	void setPIN(String s)
	{
		password=s;
	}
	void depositMoney(double amount)
	{
		this.balance+=amount;
	}
	
	boolean transferMoney(Account ac, double amount)
	{
		if(balance-amount<minBalance)
			return false;
		this.balance-=amount;
		ac.balance+=amount;
		return true;	
	}
	int withdrawMoney(double amount)
	{
		if(amount<minWithdrawal)
			return WITHDRAWAL_LIMIT_UNDER;
		if(amount>maxWithdrawal)
			return WITHDRAWAL_LIMIT_OVER;
		if(balance-amount<minBalance)
			return INSUFFICIENT_BALANCE;
		return 4;
	}
	
		public String toString()
		{   if(this.getAccountType()==1) {
			return "Saving Account " + "\n"+ "Account No: " + accountNo + "\n" +"Password: " + password + "\n" +
					     user + "\n"+"Balance: " + balance + "\n" + "History: "+vhis.getSize()+"\n"+ vhis.toString()+"\n"+"---------------------"+"\n";
		}
			return "Current Account " + "\n"+ "Account No: " + accountNo + "\n" +"Password: " + password + "\n"+
		                user + "\n" +"Balance: " + balance + "\n"+  "History: "+vhis.getSize()+"\n"+ vhis.toString()+"\n"+"---------------------"+"\n";
		}
	}
