package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.RestFileDao;
import dto.Rest_photo_table;
import dto.Rest_review_table;

public class RestFileDaoImpl implements RestFileDao {
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	

	@Override
	public int insertFile(Connection connection, Rest_photo_table uploadFile, Rest_review_table rest_review) {
		String sql = "";
		sql += "INSERT INTO rest_photo_table(rest_review_no, photo_ori_name, photo_chan_name)";
		sql += " VALUES(?, ?, ?)";
		
		int result = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1, rest_review.getRest_review_no());
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



}
