package Banking;


public class CurrentAccount extends Account{
	        
			public CurrentAccount(int accNum, String pin,double balance, UserInformation u,History his)
			{
				super(u,his);
				super.setAccountNo(accNum);
				super.setPIN(pin);
				super.setBalance(balance);
				setMinBalance(10);
				setWithdrawalLimit(10, 1000);
			}
			public void setMinBalance(double a)
			{
				minBalance=a;
			}
			public void setWithdrawalLimit(double l,double h)
			{
				minWithdrawal=l;
				maxWithdrawal=h;
			}
			public int getAccountType()
			{
				return Account.CURRENT_ACCOUNT;
			}
		}