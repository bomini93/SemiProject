package service.face;

import java.util.List;
import java.util.Map;

import dto.Recipe_Photo;
import dto.Recipe_Table;

public interface RecipeDetailService {

	Recipe_Table detail(Recipe_Table recipe_table);

	List<Recipe_Photo> detailp(Recipe_Photo recipe_photo);

	List<Map> reviewlist(int recipeno);

}
