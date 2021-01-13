package service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import dao.face.RecipeDeleteDao;
import dao.impl.RecipeDeleteDaoImpl;
import dto.Recipe_Table;
import service.face.RecipeDeleteService;

public class RecipeDeleteServiceImpl implements RecipeDeleteService{

	private RecipeDeleteDao recipedeleteDao = new RecipeDeleteDaoImpl();
	@Override
	public void deleteRecipe(Recipe_Table rt) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int res = recipedeleteDao.delete(conn, rt);
		
		if(res > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		
	}

}
