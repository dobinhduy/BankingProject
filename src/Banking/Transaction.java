package Banking;


public class Transaction {
	private String type;
	private String date;
	private String timer;
	private Double cost;
	private String changedAmount;
	private Integer count=0;
	public Transaction(String type, String localDate, String localTime, Double cost, String changedAmount) {
		super();
		this.type = type;
		this.date = localDate;
		this.timer = localTime;
		this.cost = cost;
		this.changedAmount = changedAmount;
		count++;
	}
	
	public String getType() {
		return type;
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

	public Integer getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "  -Type: "  + type+   "\n" +"  +Date: " + date +"\n"+ "  +Time: "+ timer + "\n"+ "  +Cost: "+ cost +
	           "\n"+ "  +Changed Amount: "+ changedAmount+"\n";
	}
	


}
