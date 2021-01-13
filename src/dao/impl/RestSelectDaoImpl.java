package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import common.Paging;
import dao.face.RestSelectDao;
import dto.Rest_info;

public class RestSelectDaoImpl implements RestSelectDao {

	// �쟾泥� 議고쉶
	public List<Rest_info> restSelect(Connection conn, Paging paging) {

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

		List<Rest_info> list = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);

			int idx = 1;

			ps.setInt(idx++, paging.getStartNo());
			ps.setInt(idx++, paging.getEndNo());

			rs = ps.executeQuery();

			while (rs.next()) {

				Rest_info tmp = new Rest_info();

				tmp.setRest_no(rs.getInt("rest_no"));
				tmp.setRest_name(rs.getString("rest_name"));
				tmp.setRest_address(rs.getString("rest_address"));
				tmp.setRest_condition(rs.getString("rest_condition"));
				tmp.setReview_count(rs.getInt("cnt"));
				tmp.setRest_rating(rs.getDouble("rating"));

				list.add(tmp);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return list;
	}

	// 移댄뀒怨좊━ 紐⑸줉 議고쉶
	public List<Rest_info> restCategory(Connection conn, Paging paging, String condition) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "";
		sql += "SELECT * FROM(";
		sql += " SELECT rownum rnum, REST_INFO.* FROM(";
		sql += " SELECT a.rest_no, a.rest_name, a.rest_address, a.rest_condition, COUNT(b.rest_no) cnt, TRUNC(SUM(rest_rating)/count(b.rest_no),1) rating";
		sql += " FROM rest_info a, rest_review_table b";
		sql += " WHERE a.rest_no = b.rest_no(+) AND a.rest_condition = ?";
		sql += " GROUP BY a.rest_no, a.rest_address, a.rest_condition, a.rest_name";
		sql += " ORDER BY rating DESC nulls last, a.rest_no";
		sql += " ) REST_INFO";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";

		List<Rest_info> list = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			// ���엯 媛�
			int idx = 1;
			
			ps.setString(idx++, condition);
			ps.setInt(idx++, paging.getStartNo());
			ps.setInt(idx++, paging.getEndNo());
			
			rs = ps.executeQuery();

			while (rs.next()) {

				Rest_info tmp = new Rest_info();

				tmp.setRest_no(rs.getInt("rest_no"));
				tmp.setRest_name(rs.getString("rest_name"));
				tmp.setRest_address(rs.getString("rest_address"));
				tmp.setRest_condition(rs.getString("rest_condition"));
				tmp.setReview_count(rs.getInt("cnt"));
				tmp.setRest_rating(rs.getDouble("rating"));

				list.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return list;
	}

	// 湲고� 議고쉶 紐⑸줉
	public List<Rest_info> restEtc(Connection conn, Paging paging) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "";
		sql += "SELECT * FROM(";
		sql += " SELECT rownum rnum, REST_INFO.* FROM(";
		sql += " SELECT a.rest_no, a.rest_name, a.rest_address, a.rest_condition, COUNT(b.rest_no) cnt, TRUNC(SUM(rest_rating)/count(b.rest_no),1) rating";
		sql += " FROM rest_info a, rest_review_table b";
		sql += " WHERE a.rest_no = b.rest_no(+)";
		sql += " AND a.rest_condition != '�븳�떇'";
		sql += " AND a.rest_condition != '遺꾩떇'";
		sql += " AND a.rest_condition != '�씪�떇'";
		sql += " AND a.rest_condition != '以묎뎅�떇'";
		sql += " AND a.rest_condition != '寃쎌뼇�떇'";
		sql += " GROUP BY a.rest_no, a.rest_address, a.rest_condition, a.rest_name";
		sql += " ORDER BY rating DESC nulls last, a.rest_no";
		sql += " ) REST_INFO";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";

		List<Rest_info> list = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			// ���엯 媛�
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());

			rs = ps.executeQuery();

			while (rs.next()) {

				Rest_info tmp = new Rest_info();

				tmp.setRest_no(rs.getInt("rest_no"));
				tmp.setRest_name(rs.getString("rest_name"));
				tmp.setRest_address(rs.getString("rest_address"));
				tmp.setRest_condition(rs.getString("rest_condition"));
				tmp.setReview_count(rs.getInt("cnt"));
				tmp.setRest_rating(rs.getDouble("rating"));

				list.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return list;
	}

	// �쟾泥� 議고쉶 媛쒖닔
	public int restSelectCnt(Connection conn) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "";
		sql += "SELECT count(*) FROM rest_info";

		int result = 0;

		try {
			ps = conn.prepareStatement(sql);
			// ���엯媛�
			rs = ps.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return result;
	}

	// 移댄뀒怨좊━ 議고쉶 媛쒖닔
	public int restCategoryCnt(Connection conn, String condition) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "";
		sql += "SELECT count(*) FROM rest_info";
		sql += " WHERE rest_condition = ?";

		int result = 0;

		try {
			ps = conn.prepareStatement(sql);
			// ���엯媛� = 移댄뀒怨좊━
			int idx = 1;
			ps.setString(idx++, condition);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return result;
	}

	// 湲고� 議고쉶 媛쒖닔
	public int restEtcCnt(Connection conn) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "";
		sql += "SELECT count(*) FROM rest_info";
		sql += " WHERE rest_condition != '�븳�떇'";
		sql += " AND rest_condition != '遺꾩떇'";
		sql += " AND rest_condition != '�씪�떇'";
		sql += " AND rest_condition != '以묎뎅�떇'";
		sql += " AND rest_condition != '寃쎌뼇�떇'";

		int result = 0;

		try {
			ps = conn.prepareStatement(sql);
			// ���엯媛� = 移댄뀒怨좊━
			rs = ps.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return result;
	}
}
