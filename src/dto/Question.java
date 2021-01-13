package dto;

public class Question {
	private String pw_questionno;
    private String pw_question;
    
	public String getPw_questionno() {
		return pw_questionno;
	}
	public void setPw_questionno(String pw_questionno) {
		this.pw_questionno = pw_questionno;
	}
	public String getPw_question() {
		return pw_question;
	}
	public void setPw_question(String pw_question) {
		this.pw_question = pw_question;
	}
	
	@Override
	public String toString() {
		return "Question [pw_questionno=" + pw_questionno + ", pw_question=" + pw_question + "]";
	}

}
