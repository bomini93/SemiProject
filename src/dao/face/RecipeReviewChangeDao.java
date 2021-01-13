package dao.face;

import java.sql.Connection;

import dto.Recipe_review_table;

public interface RecipeReviewChangeDao {

	int update(Connection conn, String userId, Recipe_review_table review_table);

}
