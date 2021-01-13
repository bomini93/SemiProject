package dao.face;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import dto.Recipe_Photo;
import dto.Recipe_Table;

public interface RecipeDetailDao {

	Recipe_Table selectByRecipeno(Connection conn, Recipe_Table recipe_table);

	List<Recipe_Photo> selectPhoto(Connection conn, Recipe_Photo recipe_photo);

	List<Map> reviewlist(Connection conn, int recipeno);

}
