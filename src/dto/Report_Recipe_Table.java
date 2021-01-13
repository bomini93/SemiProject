package dto;

public class Report_Recipe_Table {
	private int recipe_no;
	private int user_no;
	private int cnt;
	
	
	
	@Override
	public String toString() {
		return "Report_Recipe_Table [recipe_no=" + recipe_no + ", user_no=" + user_no + ", cnt=" + cnt + "]";
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getRecipe_no() {
		return recipe_no;
	}
	public void setRecipe_no(int recipe_no) {
		this.recipe_no = recipe_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	
}