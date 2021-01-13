package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Recipe_Photo;
import dto.Recipe_Table;

public interface RecipeChangeDao {

	public int update(Connection connection, Recipe_Table recipe_table);

	public int selects(Connection connection, Recipe_Table recipe_table);

	public int update02(Connection connection, Recipe_Photo recipe_photo, int photo_no);

	public List selectphotono(Connection connection, int recipe_no);




}
