package dao.face;

import java.sql.Connection;

import dto.Recipe_Photo;
import dto.Recipe_Table;

public interface RecipeWriteDao {


	public int insert(Connection conn, Recipe_Table recipe_table);

	public int insert02(Connection connection, Recipe_Photo recipe_photo);

	public int select(Connection connection, Recipe_Table recipe_table);


}
