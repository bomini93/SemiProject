package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import common.Paging;
import dao.face.RestInfoDao;
import dto.Rest_info;

public class RestInfoDaoImpl implements RestInfoDao{
	
	//전체 조회 별점 순
	@Override
	public List<Rest_info> selectAll(Connection conn, Paging paging) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT * FROM(";
		sql += " SELECT rownum rnum, REST_INFO.* FROM(";
		sql += " SELECT a.rest_no, a.rest_name, a.rest_address, a.rest_condition, COUNT(b.rest_no) cnt, TRUNC(SUM(rest_rating)/count(b.rest_no),1) rating";
		sql += " FROM rest_info a, rest_review_table b";
		sql += " WHERE a.rest_no = b.rest_no(+)";
		sql += " GROUP BY a.rest_no, a.rest_address, a.rest_condition, a.rest_name";
		sql += " ORDER BY rating DESC nulls last, a.rest_no";
		sql += " ) REST_INFO";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Rest_info> restinfolist = new ArrayList<>();
		
		try {

			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();

			while(rs.next()) {
				
				Rest_info restinfo = new Rest_info();
				
				restinfo.setRest_no(rs.getInt("rest_no"));
				restinfo.setRest_name(rs.getString("rest_name"));
				restinfo.setRest_address(rs.getString("rest_address"));
				restinfo.setRest_condition(rs.getString("rest_condition"));
				restinfo.setReview_count(rs.getInt("cnt"));
				restinfo.setRest_rating(rs.getDouble("rating"));				

				restinfolist.add(restinfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return restinfolist;
	}
	
	
	
	// 중식 조회 별점 순
	@Override
	public List<Rest_info> selectChina(Connection conn,Paging paging) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		
		sql += "SELECT * FROM(";
		sql += " SELECT rownum rnum, REST_INFO.* FROM(";
		sql += " SELECT a.rest_no, a.rest_name, a.rest_address, a.rest_condition, COUNT(b.rest_no) cnt, TRUNC(SUM(rest_rating)/count(b.rest_no),1) rating";
		sql += " FROM rest_info a, rest_review_table b";
		sql += " WHERE a.rest_no = b.rest_no(+) AND a.rest_condition = '중국식'";
		sql += " GROUP BY a.rest_no, a.rest_address, a.rest_condition, a.rest_name";
		sql += " ORDER BY rating DESC nulls last, a.rest_no";
		sql += " ) REST_INFO";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		List<Rest_info> restinfolist = new ArrayList<>();
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Rest_info restinfo = new Rest_info();
				
				restinfo.setRest_no(rs.getInt("rest_no"));
				restinfo.setRest_name(rs.getString("rest_name"));
				restinfo.setRest_address(rs.getString("rest_address"));
				restinfo.setRest_condition(rs.getString("rest_condition"));
				restinfo.setReview_count(rs.getInt("cnt"));
				restinfo.setRest_rating(rs.getDouble("rating"));				

				restinfolist.add(restinfo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		return restinfolist;
	}
	
	
	//일식 조회 별점 순
	@Override
	public List<Rest_info> selectJapan(Connection conn,Paging paging) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		
		sql += "SELECT * FROM(";
		sql += " SELECT rownum rnum, REST_INFO.* FROM(";
		sql += " SELECT a.rest_no, a.rest_name, a.rest_address, a.rest_condition, COUNT(b.rest_no) cnt, TRUNC(SUM(rest_rating)/count(b.rest_no),1) rating";
		sql += " FROM rest_info a, rest_review_table b";
		sql += " WHERE a.rest_no = b.rest_no(+) AND a.rest_condition = '일식'";
		sql += " GROUP BY a.rest_no, a.rest_address, a.rest_condition, a.rest_name";
		sql += " ORDER BY rating DESC nulls last, a.rest_no";
		sql += " ) REST_INFO";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Rest_info> restinfolist = new ArrayList<>();
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Rest_info restinfo = new Rest_info();
				
				restinfo.setRest_no(rs.getInt("rest_no"));
				restinfo.setRest_name(rs.getString("rest_name"));
				restinfo.setRest_address(rs.getString("rest_address"));
				restinfo.setRest_condition(rs.getString("rest_condition"));
				restinfo.setReview_count(rs.getInt("cnt"));
				restinfo.setRest_rating(rs.getDouble("rating"));				

				restinfolist.add(restinfo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		return restinfolist;
	}
	
	//한식 조회 별점 순
	@Override 
	public List<Rest_info> selectKorea(Connection conn,Paging paging) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		
		sql += "SELECT * FROM(";
		sql += " SELECT rownum rnum, REST_INFO.* FROM(";
		sql += " SELECT a.rest_no, a.rest_name, a.rest_address, a.rest_condition, COUNT(b.rest_no) cnt, TRUNC(SUM(rest_rating)/count(b.rest_no),1) rating";
		sql += " FROM rest_info a, rest_review_table b";
		sql += " WHERE a.rest_no = b.rest_no(+) AND a.rest_condition = '한식'";
		sql += " GROUP BY a.rest_no, a.rest_address, a.rest_condition, a.rest_name";
		sql += " ORDER BY rating DESC nulls last, a.rest_no";
		sql += " ) REST_INFO";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		List<Rest_info> restinfolist = new ArrayList<>();
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Rest_info restinfo = new Rest_info();
				
				restinfo.setRest_no(rs.getInt("rest_no"));
				restinfo.setRest_name(rs.getString("rest_name"));
				restinfo.setRest_address(rs.getString("rest_address"));
				restinfo.setRest_condition(rs.getString("rest_condition"));
				restinfo.setReview_count(rs.getInt("cnt"));
				restinfo.setRest_rating(rs.getDouble("rating"));				

				restinfolist.add(restinfo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		return restinfolist;
	}
	
	
	
	//분식 조회 별점 순
	@Override
	public List<Rest_info> selectSnack(Connection conn,Paging paging) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		
		sql += "SELECT * FROM(";
		sql += " SELECT rownum rnum, REST_INFO.* FROM(";
		sql += " SELECT a.rest_no, a.rest_name, a.rest_address, a.rest_condition, COUNT(b.rest_no) cnt, TRUNC(SUM(rest_rating)/count(b.rest_no),1) rating";
		sql += " FROM rest_info a, rest_review_table b";
		sql += " WHERE a.rest_no = b.rest_no(+) AND a.rest_condition = '분식'";
		sql += " GROUP BY a.rest_no, a.rest_address, a.rest_condition, a.rest_name";
		sql += " ORDER BY rating DESC nulls last, a.rest_no";
		sql += " ) REST_INFO";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		List<Rest_info> restinfolist = new ArrayList<>();
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Rest_info restinfo = new Rest_info();
				
				restinfo.setRest_no(rs.getInt("rest_no"));
				restinfo.setRest_name(rs.getString("rest_name"));
				restinfo.setRest_address(rs.getString("rest_address"));
				restinfo.setRest_condition(rs.getString("rest_condition"));
				restinfo.setReview_count(rs.getInt("cnt"));
				restinfo.setRest_rating(rs.getDouble("rating"));				

				restinfolist.add(restinfo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		return restinfolist;
	}
	
	
	//양식 조회 별점 순
	@Override
	public List<Rest_info> selectWestern(Connection conn,Paging paging) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		
		sql += "SELECT * FROM(";
		sql += " SELECT rownum rnum, REST_INFO.* FROM(";
		sql += " SELECT a.rest_no, a.rest_name, a.rest_address, a.rest_condition, COUNT(b.rest_no) cnt, TRUNC(SUM(rest_rating)/count(b.rest_no),1) rating";
		sql += " FROM rest_info a, rest_review_table b";
		sql += " WHERE a.rest_no = b.rest_no(+) AND a.rest_condition = '경양식'";
		sql += " GROUP BY a.rest_no, a.rest_address, a.rest_condition, a.rest_name";
		sql += " ORDER BY rating DESC nulls last, a.rest_no";
		sql += " ) REST_INFO";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		List<Rest_info> restinfolist = new ArrayList<>();
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Rest_info restinfo = new Rest_info();
				
				restinfo.setRest_no(rs.getInt("rest_no"));
				restinfo.setRest_name(rs.getString("rest_name")); 
				restinfo.setRest_address(rs.getString("rest_address"));
				restinfo.setRest_condition(rs.getString("rest_condition"));
				restinfo.setReview_count(rs.getInt("cnt"));
				restinfo.setRest_rating(rs.getDouble("rating"));				

				restinfolist.add(restinfo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		return restinfolist;
	}
	
	
	//기타 조회 별점 순
	@Override
	public List<Rest_info> selectEtc(Connection conn,Paging paging) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		
		sql += "SELECT * FROM(";
		sql += " SELECT rownum rnum, REST_INFO.* FROM(";
		sql += " SELECT a.rest_no, a.rest_name, a.rest_address, a.rest_condition, COUNT(b.rest_no) cnt, TRUNC(SUM(rest_rating)/count(b.rest_no),1) rating";
		sql += " FROM rest_info a, rest_review_table b";
		sql += " WHERE a.rest_no = b.rest_no(+) AND a.rest_condition != '한식' AND a.rest_condition != '분식' AND a.rest_condition != '일식' AND a.rest_condition != '중국식' AND a.rest_condition != '경양식'";
		sql += " GROUP BY a.rest_no, a.rest_address, a.rest_condition, a.rest_name";
		sql += " ORDER BY rating DESC nulls last, a.rest_no";
		sql += " ) REST_INFO";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Rest_info> restinfolist = new ArrayList<>();
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Rest_info restinfo = new Rest_info();
				
				restinfo.setRest_no(rs.getInt("rest_no"));
				restinfo.setRest_name(rs.getString("rest_name"));
				restinfo.setRest_address(rs.getString("rest_address"));
				restinfo.setRest_condition(rs.getString("rest_condition"));
				restinfo.setReview_count(rs.getInt("cnt"));
				restinfo.setRest_rating(rs.getDouble("rating"));				

				restinfolist.add(restinfo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		return restinfolist;
	}

	@Override
	public Rest_info selectByRest_no(Connection conn, Rest_info rest_info) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		sql += "SELECT a.rest_no,a.rest_name,a.rest_phone,a.rest_address,a.rest_address_zip, a.rest_new_address,a.rest_new_address_zip, a.rest_condition, ";
		sql += " COUNT(b.rest_no) cnt ,TRUNC(SUM(rest_rating)/count(b.rest_no),1) rating from rest_info a, rest_review_table b";
		sql += " WHERE a.rest_no = b.rest_no(+) and a.rest_no = ?";
		sql += " GROUP BY a.rest_no,a.rest_name,a.rest_phone,a.rest_address,a.rest_address_zip, a.rest_new_address,a.rest_new_address_zip, a.rest_condition";
		
		
		Rest_info res = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rest_info.getRest_no());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				res = new Rest_info();
				
				res.setRest_no(rs.getInt("rest_no"));
				res.setRest_name(rs.getString("rest_name"));
				res.setRest_phone(rs.getString("rest_phone"));
				res.setRest_new_address(rs.getString("rest_new_address"));
				res.setRest_new_address_zip(rs.getInt("rest_new_address_zip"));
				res.setRest_address(rs.getString("rest_address"));
				res.setRest_address_zip(rs.getInt("rest_address_zip"));
				res.setRest_condition(rs.getString("rest_condition"));
				res.setReview_count(rs.getInt("cnt"));
				res.setRest_rating(rs.getDouble("rating"));	
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return res;
	}


}
