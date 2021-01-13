package dao.face;

import java.sql.Connection;

import dto.Recipe_Table;

public interface RecipeLikeDao {

	int like(Connection conn, String userId, Recipe_Table Recipe_Table);

	int likeCancel(Connection conn, String userId, Recipe_Table recipe_table);

}
