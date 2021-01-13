package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.RecipeCntDao;

public class RecipeCntDaoImpl implements RecipeCntDao {
	
	

	@Override
	public int selectCntAll(Connection conn) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM recipe_table";
		sql += " ORDER BY recipe_date DESC";
		
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
	public int selectCntpork(Connection conn) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM recipe_table";
		sql += " WHERE recipe_ing='돼지고기'";
		sql += " ORDER BY recipe_date DESC";
		
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
	public int selectCntbeef(Connection conn) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM recipe_table";
		sql += " WHERE recipe_ing='소고기'";
		sql += " ORDER BY recipe_date DESC";
		
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
	public int selectCntchicken(Connection conn) {
			
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM recipe_table";
		sql += " WHERE recipe_ing='닭고기'";
		sql += " ORDER BY recipe_date DESC";
		
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
	public int selectCntduck(Connection conn) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM recipe_table";
		sql += " WHERE recipe_ing='오리고기'";
		sql += " ORDER BY recipe_date DESC";
		
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
	public int selectCntseafood(Connection conn) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM recipe_table";
		sql += " WHERE recipe_ing='해물류'";
		sql += " ORDER BY recipe_date DESC";
		
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
	public int selectCntgreen(Connection conn) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM recipe_table";
		sql += " WHERE recipe_ing='채소류'";
		sql += " ORDER BY recipe_date DESC";
		
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
	public int selectCntothers(Connection conn) {
			
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM recipe_table";
		sql += " WHERE recipe_ing='기타'";
		sql += " ORDER BY recipe_date DESC";
		
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
