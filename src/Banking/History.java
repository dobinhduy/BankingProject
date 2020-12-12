package Banking;

import java.util.ArrayList;

public class History {
	ArrayList<Transaction>	trans ;
	public History() {
		trans =new ArrayList<>();
	}
	
	public void addTranlist(Transaction tran) {
		trans.add(tran);
	}
	public String toString() {
		String t="";
		for(Transaction e :trans) {
			t+=e.toString();
		}
		return t;
	}
	public Integer getSize() {
		return trans.size();
	}

	

}
