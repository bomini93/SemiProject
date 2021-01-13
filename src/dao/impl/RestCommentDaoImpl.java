package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.RestCommentDao;
import dto.Rest_photo_table;
import dto.Rest_review_table;

public class RestCommentDaoImpl implements RestCommentDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int insertFile(Connection connection, Rest_photo_table uploadFile) {

		String sql = "";
		sql += "INSERT INTO Rest_photo_table(rest_review_no ,photo_ori_name, photo_chan_name)";
		sql += " VALUES(? ,?, ?)";

		int result = 0;

		try {
			ps = connection.prepareStatement(sql);

			ps.setInt(1, uploadFile.getRest_review_no());
			ps.setString(2, uploadFile.getPhoto_ori_name());
			ps.setString(3, uploadFile.getPhoto_chan_name());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}

		return result;
	}

	@Override
	public int insertreview(Connection conn, Rest_review_table params) {
		String sql = "";
		sql += "INSERT INTO rest_review_table(rest_no, rest_review_text, rest_rating, user_no)";
		sql += " VALUES(?,?,?,?)";

		int result = 0;
//		System.out.println("test");
//		System.out.println(params.getUser_no());

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, params.getRest_no());
			ps.setString(2, params.getRest_review_text());
			ps.setInt(3, params.getRest_rating());
			ps.setInt(4, params.getUser_no());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return result;
	}

	@Override
	public int searchreviewno(Connection conn, Rest_review_table params) {
		String sql = "";
		sql += "SElect max(rest_review_no) rest_review_no from rest_review_table";
		sql += " where rest_no = ? and user_no = ?";
		sql += " GROUP by user_no";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, params.getRest_no());
			ps.setInt(2, params.getUser_no());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("rest_review_no");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
