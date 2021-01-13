package dto;

import java.util.Date;

public class Member {
	private int user_no;
    private String user_id;
    private String user_pw;
    private Date user_birth;
    private String user_gender;
    private String pw_questionno;
    private String pw_answer;
    private String spicy_no;
    private String amount_no;
    
	@Override
	public String toString() {
		return "Member [user_no=" + user_no + ", user_id=" + user_id + ", user_pw=" + user_pw + ", user_birth="
				+ user_birth + ", user_gender=" + user_gender + ", pw_questionno=" + pw_questionno + ", pw_answer="
				+ pw_answer + ", spicy_no=" + spicy_no + ", amount_no=" + amount_no + "]";
	}
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public Date getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(Date user_birth) {
		this.user_birth = user_birth;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getPw_questionno() {
		return pw_questionno;
	}
	public void setPw_questionno(String pw_questionno) {
		this.pw_questionno = pw_questionno;
	}
	public String getPw_answer() {
		return pw_answer;
	}
	public void setPw_answer(String pw_answer) {
		this.pw_answer = pw_answer;
	}
	public String getSpicy_no() {
		return spicy_no;
	}
	public void setSpicy_no(String spicy_no) {
		this.spicy_no = spicy_no;
	}
	public String getAmount_no() {
		return amount_no;
	}
	public void setAmount_no(String amount_no) {
		this.amount_no = amount_no;
	}

}
