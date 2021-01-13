package dto;

public class Recipe_Photo {
	private int recipe_photo_no;
	private int recipe_no;
	private String photo_before;
	private String photo_after;
	@Override
	public String toString() {
		return "Recipe_Photo [recipe_photo_no=" + recipe_photo_no + ", recipe_no=" + recipe_no + ", photo_before="
				+ photo_before + ", photo_after=" + photo_after + "]";
	}
	public int getRecipe_photo_no() {
		return recipe_photo_no;
	}
	public void setRecipe_photo_no(int recipe_photo_no) {
		this.recipe_photo_no = recipe_photo_no;
	}
	public int getRecipe_no() {
		return recipe_no;
	}
	public void setRecipe_no(int recipe_no) {
		this.recipe_no = recipe_no;
	}
	public String getPhoto_before() {
		return photo_before;
	}
	public void setPhoto_before(String photo_before) {
		this.photo_before = photo_before;
	}
	public String getPhoto_after() {
		return photo_after;
	}
	public void setPhoto_after(String photo_after) {
		this.photo_after = photo_after;
	}
	
}
