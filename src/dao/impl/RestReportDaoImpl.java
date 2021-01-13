package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.face.RestReportDao;
import dto.Report_rest_table;

public class RestReportDaoImpl implements RestReportDao {
	
	@Override
	public int reportRest(Connection conn, Report_rest_table rrt) {
		
		PreparedStatement ps = null;
		
		int result = 0;
		
		String sql = "";
		sql += "INSERT INTO report_rest_table(rest_review_no, user_no)";
		sql += " VALUES(?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, rrt.getRest_review_no());
			ps.setInt(2, rrt.getUser_no());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("result : " + result);
		return result;
	}
		

}
