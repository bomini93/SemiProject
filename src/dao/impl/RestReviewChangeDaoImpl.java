package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.RestReviewChangeDao;
import dto.Rest_review_table;

public class RestReviewChangeDaoImpl implements RestReviewChangeDao {

	private int result = 0;
	
	@Override
	public int update(Connection conn, int review_no, Rest_review_table review_table) {
		
		
		PreparedStatement ps = null;

		String sql = "";

		sql += "UPDATE rest_review_table SET rest_rating = ?, rest_review_text = ?";
		sql += " WHERE rest_review_no = ?";

		try {

			ps = conn.prepareStatement(sql);

			ps.setInt(1, review_table.getRest_rating());
			ps.setString(2, review_table.getRest_review_text());
			ps.setInt(3, review_no);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);

		}

		return result;
	}
}