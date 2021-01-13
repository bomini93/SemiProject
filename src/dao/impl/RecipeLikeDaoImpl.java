package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.RecipeLikeDao;
import dto.Recipe_Table;

public class RecipeLikeDaoImpl implements RecipeLikeDao{
private int result = 0;
	
	@Override
	public int like(Connection conn, String userId, Recipe_Table Recipe_Table) {
		
		PreparedStatement ps = null;

		String sql = "";

		sql += "INSERT INTO Recipe_Like_Table(recipe_no, user_id, like_yn)";
		sql += " VALUES(?, ?, 'y')";
		
		try {

			ps = conn.prepareStatement(sql);

			ps.setInt(1, Recipe_Table.getRecipe_no());
			ps.setString(2, userId);
			

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);

		}
		
		
		return result;
	}

	@Override
	public int likeCancel(Connection conn, String userId, Recipe_Table recipe_table) {
		PreparedStatement ps = null;

		String sql = "";

		sql += "DELETE FROM recipe_like_table";
		sql += " WHERE recipe_no = ? AND user_id = ?";
		
		try {

			ps = conn.prepareStatement(sql);

			ps.setInt(1, recipe_table.getRecipe_no());
			ps.setString(2, userId);
			

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);

		}
		
		
		return result;
	}

}
