package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.RecipeReportDao;
import dto.Report_Recipe_Table;

public class RecipeReportDaoImpl implements RecipeReportDao{

	PreparedStatement ps = null; //SQL 수행 객체
	ResultSet rs = null; //조회결과 객체
	
	@Override
	public int insert(Connection conn, Report_Recipe_Table report_recipe_table) {
		
		String sql = "";
		sql += "INSERT INTO report_recipe_table";
		sql += " VALUES(?, ?)";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, report_recipe_table.getRecipe_no());
			ps.setInt(2, report_recipe_table.getUser_no());
			
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
	}

}
