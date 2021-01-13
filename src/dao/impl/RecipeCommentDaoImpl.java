package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.RecipeCommentDao;
import dto.Recipe_review_table;

public class RecipeCommentDaoImpl implements RecipeCommentDao {
	
	@Override
	public int selectuserno(Connection conn,String user_id) {
		
		PreparedStatement ps = null; //SQL수행 객체
		ResultSet rs = null; //조회결과 객체
		
		int result = 0;
		
		String sql = "";
		sql += "select * from member";
		sql += " where user_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, user_id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("user_no");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	@Override
	public int insertreview(Connection conn, Recipe_review_table params) {
		
		PreparedStatement ps = null; //SQL수행 객체
		
		int result = 0;
		
		String sql = "";
		sql += "insert into recipe_review_table (recipe_no,user_no,recipe_review_text,recipe_rating)";
		sql += " values(?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			int idx = 1;
			ps.setInt(idx++, params.getRecipe_no() );
			ps.setInt(idx++, params.getUser_no());
			ps.setString(idx++, params.getRecipe_review_text());
			ps.setInt(idx++, params.getRecipe_rating());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		

		return result;
	}

}
