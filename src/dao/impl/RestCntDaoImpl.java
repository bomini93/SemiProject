package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.RestCntDao;

public class RestCntDaoImpl implements RestCntDao{
	
	@Override
	public int selectCntAll(Connection conn) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM rest_info";
		
		int totalCount = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return totalCount;
	}

	@Override
	public int selectCntKorean(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM rest_info";
		sql += " WHERE rest_condition = '한식'";
		
		int totalCount = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return totalCount;
	}

	@Override
	public int selectCntSnack(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM rest_info";
		sql += " WHERE rest_condition = '분식'";
		
		int totalCount = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return totalCount;
	}

	@Override
	public int selectCntJapan(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM rest_info";
		sql += " WHERE rest_condition = '일식'";
		
		int totalCount = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return totalCount;
	}

	@Override
	public int selectCntChina(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM rest_info";
		sql += " WHERE rest_condition = '중국식'";
		
		int totalCount = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return totalCount;
	}

	@Override
	public int selectCntWestern(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM rest_info";
		sql += " WHERE rest_condition = '경양식'";
		
		int totalCount = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return totalCount;
	}

	@Override
	public int selectCntEtc(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM rest_info";
		sql += " WHERE rest_condition = '기타'";
		
		int totalCount = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return totalCount;
	}
}
