package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.RestLikeDao;
import dto.Rest_info;

public class RestLikeDaoImpl implements RestLikeDao {
	private int result = 0;
	
	@Override
	public int like(Connection conn, String userId, Rest_info rest_info) {
		
		PreparedStatement ps = null;

		String sql = "";

		sql += "INSERT INTO rest_like_table(rest_no, user_id, like_yn)";
		sql += " VALUES(?, ?, 'y')";
		
		try {

			ps = conn.prepareStatement(sql);

			ps.setInt(1, rest_info.getRest_no());
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
	public int likeCancel(Connection conn, String userId, Rest_info rest_info) {
		PreparedStatement ps = null;

		String sql = "";

		sql += "DELETE FROM rest_like_table";
		sql += " WHERE rest_no = ? AND user_id = ?";
		
		try {

			ps = conn.prepareStatement(sql);

			ps.setInt(1, rest_info.getRest_no());
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
