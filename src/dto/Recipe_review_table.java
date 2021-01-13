package dto;

import java.util.Date;

public class Recipe_review_table {
	
	private int recipe_review_no;
	private int recipe_no;
	private int user_no; 
    private String recipe_review_text;
    private Date recipe_review_date;
    private int recipe_rating;
	@Override
	public String toString() {
		return "Recipe_review_table [recipe_review_no=" + recipe_review_no + ", recipe_no=" + recipe_no + ", user_no="
				+ user_no + ", recipe_review_text=" + recipe_review_text + ", recipe_review_date=" + recipe_review_date
				+ ", recipe_rating=" + recipe_rating + "]";
	}
	public int getRecipe_review_no() {
		return recipe_review_no;
	}
	public void setRecipe_review_no(int recipe_review_no) {
		this.recipe_review_no = recipe_review_no;
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
	public String getRecipe_review_text() {
		return recipe_review_text;
	}
	public void setRecipe_review_text(String recipe_review_text) {
		this.recipe_review_text = recipe_review_text;
	}
	public Date getRecipe_review_date() {
		return recipe_review_date;
	}
	public void setRecipe_review_date(Date recipe_review_date) {
		this.recipe_review_date = recipe_review_date;
	}
	public int getRecipe_rating() {
		return recipe_rating;
	}
	public void setRecipe_rating(int recipe_rating) {
		this.recipe_rating = recipe_rating;
	}
    
    
	
}
	
	
	
