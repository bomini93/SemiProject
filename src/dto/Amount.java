package dto;

public class Amount {
	private String amount_no;
    private String amount_level;
    
	@Override
	public String toString() {
		return "Amount [amount_no=" + amount_no + ", amount_level=" + amount_level + "]";
	}
	
	public String getAmount_no() {
		return amount_no;
	}
	public void setAmount_no(String amount_no) {
		this.amount_no = amount_no;
	}
	public String getAmount_level() {
		return amount_level;
	}
	public void setAmount_level(String amount_level) {
		this.amount_level = amount_level;
	}

}
