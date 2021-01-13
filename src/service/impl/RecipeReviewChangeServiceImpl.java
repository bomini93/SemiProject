package service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import dao.face.RecipeReviewChangeDao;
import dao.impl.RecipeReviewChangeDaoImpl;
import dto.Recipe_review_table;
import service.face.RecipeReviewChangeService;

public class RecipeReviewChangeServiceImpl implements RecipeReviewChangeService {
	
	private RecipeReviewChangeDao changeDao = new RecipeReviewChangeDaoImpl();
	
	@Override
	public void update(String userId, Recipe_review_table review_table) {
		Connection conn = JDBCTemplate.getConnection(); //db연결객체
	
		int result = changeDao.update(conn, userId, review_table);
		
		if(result > 0) {
			JDBCTemplate.commit(conn); //커밋
		} else {
			JDBCTemplate.rollback(conn); //롤백
		}
	
	}

}
