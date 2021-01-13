package dao.face;

import java.sql.Connection;

import dto.Recipe_review_table;

public interface RecipeReviewDeleteDao {

	int deleteMyReview(Connection conn, String userno, Recipe_review_table rrt);

	

}
