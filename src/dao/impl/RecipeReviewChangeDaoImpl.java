package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.RecipeReviewChangeDao;
import dto.Recipe_review_table;

public class RecipeReviewChangeDaoImpl implements RecipeReviewChangeDao {

	
	private int result = 0;
	
	
	@Override
	public int update(Connection conn, String userId, Recipe_review_table review_table) {
		PreparedStatement ps = null;
		String sql = "";

		sql += "UPDATE recipe_review_table SET recipe_rating = ?, recipe_review_text = ?";
		sql += " WHERE recipe_review_no = ?";
		
		try {

			ps = conn.prepareStatement(sql);

			ps.setInt(1, review_table.getRecipe_rating());
			ps.setString(2, review_table.getRecipe_review_text());
			ps.setInt(3, review_table.getRecipe_review_no());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);

		}
		
			
		return result;
	}

}
