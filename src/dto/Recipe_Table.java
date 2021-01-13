package dto;

import java.util.Date;

public class Recipe_Table {
	private int recipe_no;
	private String recipe_name;
	private String recipe_kinds;
	private String recipe_ing;
	private String recipe_time;
	private String recipe_text01;
	private String recipe_text02;
	private String recipe_text03;
	private String recipe_text04;
	private String recipe_text05;
	private Date recipe_date;
	private String recipe_ori_name;
	private String recipe_new_name;
	private int user_no;
	
	public Date getRecipe_date() {
		return recipe_date;
	}
	public void setRecipe_date(Date recipe_date) {
		this.recipe_date = recipe_date;
	}
	@Override
	public String toString() {
		return "Recipe_Table [recipe_no=" + recipe_no + ", recipe_name=" + recipe_name + ", recipe_kinds="
				+ recipe_kinds + ", recipe_ing=" + recipe_ing + ", recipe_time=" + recipe_time + ", recipe_text01="
				+ recipe_text01 + ", recipe_text02=" + recipe_text02 + ", recipe_text03=" + recipe_text03
				+ ", recipe_text04=" + recipe_text04 + ", recipe_text05=" + recipe_text05 + ", recipe_date="
				+ recipe_date + ", recipe_ori_name=" + recipe_ori_name + ", recipe_new_name=" + recipe_new_name
				+ ", user_no=" + user_no + "]";
	}
	public int getRecipe_no() {
		return recipe_no;
	}
	public void setRecipe_no(int recipe_no) {
		this.recipe_no = recipe_no;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public String getRecipe_kinds() {
		return recipe_kinds;
	}
	public void setRecipe_kinds(String recipe_kinds) {
		this.recipe_kinds = recipe_kinds;
	}
	public String getRecipe_ing() {
		return recipe_ing;
	}
	public void setRecipe_ing(String recipe_ing) {
		this.recipe_ing = recipe_ing;
	}
	public String getRecipe_time() {
		return recipe_time;
	}
	public void setRecipe_time(String recipe_time) {
		this.recipe_time = recipe_time;
	}
	public String getRecipe_text01() {
		return recipe_text01;
	}
	public void setRecipe_text01(String recipe_text01) {
		this.recipe_text01 = recipe_text01;
	}
	public String getRecipe_text02() {
		return recipe_text02;
	}
	public void setRecipe_text02(String recipe_text02) {
		this.recipe_text02 = recipe_text02;
	}
	public String getRecipe_text03() {
		return recipe_text03;
	}
	public void setRecipe_text03(String recipe_text03) {
		this.recipe_text03 = recipe_text03;
	}
	public String getRecipe_text04() {
		return recipe_text04;
	}
	public void setRecipe_text04(String recipe_text04) {
		this.recipe_text04 = recipe_text04;
	}
	public String getRecipe_text05() {
		return recipe_text05;
	}
	public void setRecipe_text05(String recipe_text05) {
		this.recipe_text05 = recipe_text05;
	}
	
	public String getRecipe_ori_name() {
		return recipe_ori_name;
	}
	public void setRecipe_ori_name(String recipe_ori_name) {
		this.recipe_ori_name = recipe_ori_name;
	}
	public String getRecipe_new_name() {
		return recipe_new_name;
	}
	public void setRecipe_new_name(String recipe_new_name) {
		this.recipe_new_name = recipe_new_name;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	
}
