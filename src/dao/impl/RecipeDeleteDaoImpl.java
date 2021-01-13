package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.RecipeDeleteDao;
import dto.Recipe_Table;

public class RecipeDeleteDaoImpl implements RecipeDeleteDao{

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int delete(Connection conn, Recipe_Table rt) {
		
		String sql = "";
		sql += "DELETE FROM Recipe_Table";
		sql += " WHERE recipe_no = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, rt.getRecipe_no());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				res = 1;
			} else {
				res = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}

}
