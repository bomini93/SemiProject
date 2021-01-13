package service.impl;

import java.sql.Connection;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.RecipeCommentDao;
import dao.impl.RecipeCommentDaoImpl;
import dto.Recipe_review_table;
import service.face.RecipeCommentService;

public class RecipeCommentServiceImpl implements RecipeCommentService {

	private RecipeCommentDao recipeCommentDao = new RecipeCommentDaoImpl();
	
	@Override
	public Recipe_review_table getParam(HttpServletRequest req,int user_no) {
		Recipe_review_table param = new Recipe_review_table();
		
		param.setRecipe_no(Integer.parseInt(req.getParameter("recipe_no")));
		param.setRecipe_rating(Integer.parseInt(req.getParameter("recipe_rating")));
		param.setRecipe_review_text(req.getParameter("recipe_review_text"));
		param.setUser_no(user_no);
		
		return param;
	}

	@Override
	public void insertreview(Recipe_review_table params) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = recipeCommentDao.insertreview(conn, params);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
	}
	
	@Override
	public int selectuserno(String user_id) {
		Connection conn = JDBCTemplate.getConnection();
		
		return recipeCommentDao.selectuserno(conn,user_id); 
	}

}
