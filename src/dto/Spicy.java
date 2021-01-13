package dto;

public class Spicy {
	private String spicy_no;
    private String spicy_level;
    
	@Override
	public String toString() {
		return "Spicy [spicy_no=" + spicy_no + ", spicy_level=" + spicy_level + "]";
	}
	
	public String getSpicy_no() {
		return spicy_no;
	}
	public void setSpicy_no(String spicy_no) {
		this.spicy_no = spicy_no;
	}
	public String getSpicy_level() {
		return spicy_level;
	}
	public void setSpicy_level(String spicy_level) {
		this.spicy_level = spicy_level;
	}
    
}
