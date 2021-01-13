package service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import dao.face.RecipeLikeDao;
import dao.impl.RecipeLikeDaoImpl;
import dto.Recipe_Table;
import service.face.RecipeLikeService;

public class RecipeLikeServiceImpl implements RecipeLikeService{

	private RecipeLikeDao likeDao = new RecipeLikeDaoImpl();
	
	@Override
	public void like(String userId, Recipe_Table recipe_table) {
		Connection conn = JDBCTemplate.getConnection(); //DB연결 객체
		
	      int result = likeDao.like(conn, userId, recipe_table);
	      
	      if(result > 0) {
	         JDBCTemplate.commit(conn); //커밋
	      } else {
	         JDBCTemplate.rollback(conn); //롤백
	      }
		
	}
	
	@Override
	public void likeCancel(String userId, Recipe_Table recipe_table) {
		Connection conn = JDBCTemplate.getConnection(); //DB연결 객체
		
	      int result = likeDao.likeCancel(conn, userId, recipe_table);
	      
	      if(result > 0) {
	         JDBCTemplate.commit(conn); //커밋
	      } else {
	         JDBCTemplate.rollback(conn); //롤백
	      }
		
	}

}
