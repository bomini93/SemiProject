package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.RecipeReviewDeleteDao;
import dto.Recipe_review_table;

public class RecipeReviewDeleteDaoImpl implements RecipeReviewDeleteDao{

	private int result = 0 ;
		
	@Override
	public int deleteMyReview(Connection conn, String userid, Recipe_review_table rrt) {
		
		PreparedStatement ps = null; // SQL 수행 객체
		ResultSet rs = null; //조회 결과 객체
		
		String sql="";
		
		sql += "DELETE FROM recipe_review_table";
		sql += " Where recipe_review_no=?";
		
		try {

			ps = conn.prepareStatement(sql);


			ps.setInt(1, rrt.getRecipe_review_no());
			
			

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);

		}
		
		return result;
		
	}

	

	
	}


