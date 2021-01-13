package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.JDBCTemplate;
import common.Paging;
import dao.face.RestReviewListDao;
import dto.Member;
import dto.Rest_info;
import dto.Rest_photo_table;
import dto.Rest_review_table;

public class RestReviewListDaoImpl implements RestReviewListDao{

	private int result = 0 ;
	
	@Override
	public int selectCntAll(Connection connection, Rest_info rest_info) {
		PreparedStatement ps = null; // SQL 수행 객체
		ResultSet rs = null; //조회 결과 객체
		
		// SQL 작성
		String sql="";
		sql += "SELECT count(*) FROM REST_REVIEW_TABLE";
		sql += " WHERE rest_no=?";
		sql += " ORDER BY rest_no DESC";

		
		//결과 저장할 변수
		int totalCount=0;
		
		try {
			ps= connection.prepareStatement(sql); //sql 수행 객체
			ps.setInt(1, rest_info.getRest_no());
			rs = ps.executeQuery(); //sql 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				totalCount = rs.getInt(1);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		//최종 결과 반환
		return totalCount;
	}

	@Override
	public List<Map> selectList(Connection connection, Paging paging, Rest_info rest_info) {
		PreparedStatement ps = null; // SQL 수행 객체
		ResultSet rs = null; //조회 결과 객체
		
		// SQL 작성
		String sql = "";
		sql += "SELECT * FROM ( SELECT rownum rnum, B.* FROM (";
		sql += "	SELECT m.user_id, m.user_no,m.spicy_no,m.amount_no,r.rest_no,r.rest_rating, r.rest_review_date";
		sql += "	, r.rest_review_no, r.rest_review_text , p.photo_chan_name";
		sql += "		FROM member m, rest_review_table r, rest_photo_table p";
		sql += "		Where m.user_no = r.user_no";
		sql += "		AND r.rest_review_no = p.rest_review_no (+)";
		sql += "		AND rest_no = ?";		
		sql += "		ORDER BY rest_review_date DESC ) B ) Rest_review_table";
		sql += "	WHERE rnum Between ? AND ?";

		//결과 저장할 List
		List<Map> list = new ArrayList<>();

		try {
			
			ps=connection.prepareStatement(sql);
			
			ps.setInt(1, rest_info.getRest_no());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				
				HashMap<String, Object> map = new HashMap<>();
				Member mem = new Member(); //user_no , user_id
				Rest_review_table rrt = new Rest_review_table();				
				Rest_photo_table rpt = new Rest_photo_table();
				
				//결과값 한 행 처리
				mem.setUser_id(rs.getString("user_id"));
				mem.setUser_no(rs.getInt("user_no"));
				mem.setAmount_no(rs.getString("amount_no"));
				mem.setSpicy_no(rs.getString("spicy_no"));
				
				rrt.setRest_no(rs.getInt("rest_no"));
				rrt.setRest_review_no(rs.getInt("rest_review_no"));
				rrt.setRest_rating(rs.getInt("rest_rating"));
				rrt.setRest_review_date(rs.getDate("rest_review_date"));
				rrt.setRest_review_text(rs.getString("rest_review_text"));
				rrt.setUser_no(rs.getInt("user_no"));
				
				rpt.setPhoto_chan_name(rs.getString("photo_chan_name"));
				
				map.put("mem", mem);
				map.put("rrt", rrt);
				map.put("rpt", rpt);
				
				//리스트에 결과값 저장
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		return list;
	}
	
	@Override
	public List<Map> selectMyReview(Connection connection, int user_no, Rest_info rest_info) {
		PreparedStatement ps = null; // SQL 수행 객체
		ResultSet rs = null; //조회 결과 객체
		
		List<Map> mylist = new ArrayList<>();
		
		// SQL 작성
		String sql = "";
		sql += "SELECT r.rest_review_no, r.rest_no, r.user_no, r.rest_review_text";
		sql += "	, r.rest_review_date, r.rest_rating, p.photo_chan_name";
		sql += " FROM Rest_Review_Table r , rest_photo_table p";
		sql += " WHERE r.rest_review_no = p.rest_review_no(+) AND user_no = ? AND rest_no = ?";
		sql += " ORDER BY rest_no DESC";
	
		//결과 저장할 List
		List<Rest_review_table> rest_myreview = new ArrayList<>();

		try {
			ps=connection.prepareStatement(sql);
			
			ps.setInt(1, user_no);
			ps.setInt(2, rest_info.getRest_no());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				
				HashMap<String, Object> map = new HashMap<>();
				Rest_review_table myReview = new Rest_review_table(); //결과값 저장 객체
				Rest_photo_table rpt = new Rest_photo_table();
				
				//결과값 한 행 처리
				myReview.setRest_review_no(rs.getInt("rest_review_no"));
				myReview.setRest_no(rs.getInt("rest_no"));
				myReview.setUser_no(rs.getInt("user_no"));
				myReview.setRest_review_text(rs.getString("rest_review_text"));
				myReview.setRest_review_date(rs.getDate("rest_review_date"));
				myReview.setRest_rating(rs.getInt("rest_rating"));
				
				rpt.setPhoto_chan_name(rs.getString("photo_chan_name"));
				
				map.put("myReview", myReview);
				map.put("rpt", rpt);
				
				//결과리스트에 결과값 저장
				mylist.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return mylist;
	}
	
	@Override
	public int deleteMyReview(Connection connection, String userno, Rest_review_table rrt) {

		PreparedStatement ps = null; // SQL 수행 객체
		ResultSet rs = null; //조회 결과 객체
		
		String sql="";
		
		sql += "DELETE FROM rest_review_table";
		sql += " Where rest_review_no=?";
		
		try {

			ps = connection.prepareStatement(sql);

//			ps.setInt(1, rrt.getRest_no());
			ps.setInt(1, rrt.getRest_review_no());
//			ps.setInt(2, rrt.getUser_no());			
			

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);

		}
		
		return result;
	}
	
	@Override
	public int update(Connection conn, String userid, Rest_review_table rrt) {

		PreparedStatement ps = null; // SQL 수행 객체
		ResultSet rs = null; //조회 결과 객체

		int result = 0;
		
		String sql ="";
		
		sql += "UPDATE Rest_review_table SET ";
		sql += " ";
		
		try {

			ps = conn.prepareStatement(sql);

//			ps.setString(1, rrt.get);
//			ps.setString(2, rrt.get);
//			ps.setString(3, userId);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);

		}

		return result;
	}
	
	
}
