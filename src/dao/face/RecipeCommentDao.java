package dao.face;

import java.sql.Connection;

import dto.Recipe_review_table;

public interface RecipeCommentDao {

	int selectuserno(Connection conn, String user_id);

	int insertreview(Connection conn, Recipe_review_table params);

}
