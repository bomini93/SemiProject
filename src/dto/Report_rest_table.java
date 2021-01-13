package dto;

public class Report_rest_table {
	
	private int rest_review_no;
	private int user_no;
	private int cnt;
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	@Override
	public String toString() {
		return "Report_rest_table [rest_review_no=" + rest_review_no + ", user_no=" + user_no + ", cnt=" + cnt + "]";
	}

	public int getRest_review_no() {
		return rest_review_no;
	}
	public void setRest_review_no(int rest_review_no) {
		this.rest_review_no = rest_review_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	
	

}
