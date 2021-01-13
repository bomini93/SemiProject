package dto;

public class Rest_like_table {
	private int rest_no; 
	private char like_yn;
	private String user_id;
	@Override
	public String toString() {
		return "Rest_like_table [rest_no=" + rest_no + ", like_yn=" + like_yn + ", user_id=" + user_id + "]";
	}
	public int getRest_no() {
		return rest_no;
	}
	public void setRest_no(int rest_no) {
		this.rest_no = rest_no;
	}
	public char getLike_yn() {
		return like_yn;
	}
	public void setLike_yn(char like_yn) {
		this.like_yn = like_yn;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
}
