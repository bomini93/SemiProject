package service.face;

import dto.Recipe_review_table;

public interface RecipeReviewDeleteService {

	void deleteReview(String userno, Recipe_review_table rrt);

}
