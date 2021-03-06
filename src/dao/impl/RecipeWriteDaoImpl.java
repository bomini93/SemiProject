package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.RecipeWriteDao;
import dto.Recipe_Photo;
import dto.Recipe_Table;

public class RecipeWriteDaoImpl implements RecipeWriteDao{

	PreparedStatement ps = null; //SQL 수행 객체
	ResultSet rs = null; //조회결과 객체
	
	
	
	@Override
	public int insert(Connection conn, Recipe_Table recipe_table) {
		
		String sql = "";
		sql += "INSERT INTO RECIPE_TABLE(recipe_name, recipe_kinds, recipe_ing, recipe_time, recipe_text01, recipe_text02, recipe_text03, recipe_text04, recipe_text05, recipe_date, recipe_ori_name, recipe_new_name, user_no)";
		sql += " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, default, ?, ?, ?)";
		
		int flags = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, recipe_table.getRecipe_name());
			ps.setString(2, recipe_table.getRecipe_kinds());
			ps.setString(3, recipe_table.getRecipe_ing());
			ps.setString(4, recipe_table.getRecipe_time());
			ps.setString(5, recipe_table.getRecipe_text01());
			ps.setString(6, recipe_table.getRecipe_text02());
			ps.setString(7, recipe_table.getRecipe_text03());
			ps.setString(8, recipe_table.getRecipe_text04());
			ps.setString(9, recipe_table.getRecipe_text05());
			ps.setString(10, recipe_table.getRecipe_ori_name());
			ps.setString(11, recipe_table.getRecipe_new_name());
			ps.setInt(12, recipe_table.getUser_no());
			
			flags = ps.executeUpdate();
			
			JDBCTemplate.commit(conn); //커밋
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		return flags;
	}

	@Override
	public int insert02(Connection conn, Recipe_Photo recipe_photo) {
		String sql = "";
		sql += "INSERT INTO RECIPE_Photo(recipe_no,photo_before, photo_after)";
		sql += " VALUES(?, ?, ?)";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, recipe_photo.getRecipe_no());
			ps.setString(2, recipe_photo.getPhoto_before());
			ps.setString(3, recipe_photo.getPhoto_after());
			
			result = ps.executeUpdate();
				
			JDBCTemplate.commit(conn); //커밋
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
		
	}

	@Override
	public int select(Connection conn, Recipe_Table recipe_table) {
		
		String sql = "";
		sql += "select max(recipe_no) recipe_no from recipe_table";
		sql += " group by user_no";
		
//		Recipe_Table res = null;
		
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
			
				result = rs.getInt("recipe_no");
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return result;
	}
	


	
	
}