package service.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import common.JDBCTemplate;
import dao.face.RecipeDetailDao;
import dao.impl.RecipeDetailDaoImpl;
import dto.Recipe_Photo;
import dto.Recipe_Table;
import service.face.RecipeDetailService;

public class RecipeDetailServiceImpl implements RecipeDetailService{

	//Dao 객체 생성
		private RecipeDetailDao recipedetailDao = new RecipeDetailDaoImpl();
	
	@Override
	public Recipe_Table detail(Recipe_Table recipe_table) {
		
		//Conneciton 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		//DB조회 결과 얻어오기 - Dao 이용
		Recipe_Table res = recipedetailDao.selectByRecipeno(conn, recipe_table);
		
		
		return res;
	}

	@Override
	public List<Recipe_Photo> detailp(Recipe_Photo recipe_photo) {
		
		//Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		//DB조회 결과 얻어오기 - Dao 이용
		List<Recipe_Photo> pres = recipedetailDao.selectPhoto(conn, recipe_photo);
		
		return pres;
	}

	 @Override
	   public List<Map> reviewlist(int recipeno) {
	      
	      Connection conn = JDBCTemplate.getConnection();
	      List<Map> reviewlist = recipedetailDao.reviewlist(conn,recipeno);
	      
	      return reviewlist;
	   }

}
