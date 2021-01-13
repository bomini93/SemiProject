package service.face;

import dto.Recipe_Table;

public interface RecipeLikeService {

	void like(String userId, Recipe_Table recipe_table);

	void likeCancel(String userId, Recipe_Table recipe_table);

}
