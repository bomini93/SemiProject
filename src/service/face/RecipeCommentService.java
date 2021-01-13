package service.face;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import dto.Recipe_review_table;

public interface RecipeCommentService {

	Recipe_review_table getParam(HttpServletRequest req,int user_no);

	void insertreview(Recipe_review_table params);

	int selectuserno(String user_id);

}
