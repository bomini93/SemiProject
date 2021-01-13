package dto;

public class Recipe_like_table {
	private int recipe_no;
	private String user_id;
	private char like_yn;
	@Override
	public String toString() {
		return "Recipe_like_table [recipe_no=" + recipe_no + ", user_id=" + user_id + ", like_yn=" + like_yn + "]";
	}
	public int getRecipe_no() {
		return recipe_no;
	}
	public void setRecipe_no(int recipe_no) {
		this.recipe_no = recipe_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public char getLike_yn() {
		return like_yn;
	}
	public void setLike_yn(char like_yn) {
		this.like_yn = like_yn;
	}
	
}
