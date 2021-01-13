package dto;

public class Rest_info {
	private int rest_no;
	private String rest_name;
	private String rest_phone; 
	private String rest_address; 
	private String rest_new_address;
	private int rest_address_zip;
	private int rest_new_address_zip;
	private String rest_condition;
	private int review_count;
	private double rest_rating;
	
	public int getRest_no() {
		return rest_no;
	}
	public void setRest_no(int rest_no) {
		this.rest_no = rest_no;
	}
	public String getRest_name() {
		return rest_name;
	}
	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}
	public String getRest_phone() {
		return rest_phone;
	}
	public void setRest_phone(String rest_phone) {
		this.rest_phone = rest_phone;
	}
	public String getRest_address() {
		return rest_address;
	}
	public void setRest_address(String rest_address) {
		this.rest_address = rest_address;
	}
	public String getRest_new_address() {
		return rest_new_address;
	}
	public void setRest_new_address(String rest_new_address) {
		this.rest_new_address = rest_new_address;
	}
	public int getRest_address_zip() {
		return rest_address_zip;
	}
	public void setRest_address_zip(int rest_address_zip) {
		this.rest_address_zip = rest_address_zip;
	}
	public int getRest_new_address_zip() {
		return rest_new_address_zip;
	}
	public void setRest_new_address_zip(int rest_new_address_zip) {
		this.rest_new_address_zip = rest_new_address_zip;
	}
	public String getRest_condition() {
		return rest_condition;
	}
	public void setRest_condition(String rest_condition) {
		this.rest_condition = rest_condition;
	}
	public int getReview_count() {
		return review_count;
	}
	public void setReview_count(int review_count) {
		this.review_count = review_count;
	}
	public double getRest_rating() {
		return rest_rating;
	}
	public void setRest_rating(double rest_rating) {
		this.rest_rating = rest_rating;
	}
	
	@Override
	public String toString() {
		return "Rest_info [rest_no=" + rest_no + ", rest_name=" + rest_name + ", rest_phone=" + rest_phone
				+ ", rest_address=" + rest_address + ", rest_new_address=" + rest_new_address + ", rest_address_zip="
				+ rest_address_zip + ", rest_new_address_zip=" + rest_new_address_zip + ", rest_condition="
				+ rest_condition + ", review_count=" + review_count + ", rest_rating=" + rest_rating + "]";
	}
	
}
