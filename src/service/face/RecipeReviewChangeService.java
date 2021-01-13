package service.face;

import dto.Recipe_review_table;

public interface RecipeReviewChangeService {

	void update(String userId, Recipe_review_table review_table);

}
