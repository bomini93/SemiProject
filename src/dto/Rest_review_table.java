package dto;

import java.util.Date;

public class Rest_review_table {
	private int rest_review_no;
	private int rest_no;
	private int user_no; 
    private String rest_review_text;
    private Date rest_review_date;
    private int rest_rating;
    
	public int getRest_review_no() {
		return rest_review_no;
	}
	public void setRest_review_no(int rest_review_no) {
		this.rest_review_no = rest_review_no;
	}
	public int getRest_no() {
		return rest_no;
	}
	public void setRest_no(int rest_no) {
		this.rest_no = rest_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getRest_review_text() {
		return rest_review_text;
	}
	public void setRest_review_text(String rest_review_text) {
		this.rest_review_text = rest_review_text;
	}
	public Date getRest_review_date() {
		return rest_review_date;
	}
	public void setRest_review_date(Date rest_review_date) {
		this.rest_review_date = rest_review_date;
	}
	public int getRest_rating() {
		return rest_rating;
	}
	public void setRest_rating(int rest_rating) {
		this.rest_rating = rest_rating;
	}
	
	@Override
	public String toString() {
		return "Rest_review_table [rest_review_no=" + rest_review_no + ", rest_no=" + rest_no + ", user_no=" + user_no
				+ ", rest_review_text=" + rest_review_text + ", rest_review_date=" + rest_review_date + ", rest_rating="
				+ rest_rating + "]";
	}
}
