package service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import dao.face.RecipeDeleteDao;
import dao.face.RecipeReviewDeleteDao;
import dao.impl.RecipeDeleteDaoImpl;
import dao.impl.RecipeReviewDeleteDaoImpl;
import dto.Recipe_review_table;
import service.face.RecipeDeleteService;
import service.face.RecipeReviewDeleteService;

public class RecipeReviewDeleteServiceImpl implements RecipeReviewDeleteService {

	private RecipeReviewDeleteDao recipereviewDeleteDao = new RecipeReviewDeleteDaoImpl();

	
	@Override
	public void deleteReview(String userno, Recipe_review_table rrt) {
	Connection conn = JDBCTemplate.getConnection();
		
		int result = recipereviewDeleteDao.deleteMyReview(conn, userno, rrt);
		
		if(result>0) {
	         JDBCTemplate.commit(conn); //커밋
	      } else {
	         JDBCTemplate.rollback(conn); //롤백
	      }
	      
	}

}
