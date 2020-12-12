package Banking;


public class Transaction {
	private String type;
	private String transferTo;
	private String date;
	private String timer;
	private Double cost;
	private String changedAmount;
	public Transaction(String type,String transto, String localDate, String localTime, Double cost, String changedAmount) {
		super();
		this.type = type;
		this.transferTo=transto;
		this.date = localDate;
		this.timer = localTime;
		this.cost = cost;
		this.changedAmount = changedAmount;
	}
	
	public String getType() {
		return type;
	}
   public String getTRransferto() {
	   return transferTo;
   }
	public String getDate() {
		return date;
	}

	public String getTimer() {
		return timer;
	}

	public Double getCost() {
		return cost;
	}

	public String getChangedAmount() {
		return changedAmount;
	}


	@Override
	public String toString() {
		return "  -Type: "  + type+   "\n" + "  +TransferTo:  "+ transferTo+ "\n"  + "  +Date: " + date +"\n"+ "  +Time: "+ timer + "\n"
	           + "  +Cost: "+ cost + "\n"+ "  +Changed Amount: "+ changedAmount+"\n";
	}
	


}
