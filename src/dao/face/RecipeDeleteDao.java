package dao.face;

import java.sql.Connection;

import dto.Recipe_Table;

public interface RecipeDeleteDao {

	public int delete(Connection conn, Recipe_Table rt);

}
