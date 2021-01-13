package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.MypageDao;
import dto.Member;
import dto.Recipe_Table;
import dto.Rest_info;

public class MypageDaoImpl implements MypageDao {

	@Override
	public List<Member> selectAll(Connection conn, String userId) {
		PreparedStatement ps = null; // SQL수행 객체
		ResultSet rs = null; // 조회결과 객체
//	      Member member = new Member();

		// SQL작성
		String sql = "";
		sql += "SELECT * FROM MEMBER";
		sql += " WHERE user_id=?";

		// 조회결과를 저장할 리스트 객체
		List<Member> memberList = new ArrayList<>();

		Member res = null;

		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체 생성

//	         ps.setString(1, member.getUser_id());
			ps.setString(1, userId);

			rs = ps.executeQuery(); // SQL 수행 및 결과 반환

			while (rs.next()) {
				// 새로운 비어있는 Emp 객체 생성
				res = new Member();

				res.setUser_no(rs.getInt("user_no"));
				res.setUser_id(rs.getString("user_id"));
				res.setUser_gender(rs.getString("user_gender"));
				res.setSpicy_no(rs.getString("spicy_no"));
				res.setAmount_no(rs.getString("amount_no"));

				// 조회 결과를 담고있는 DTO를 리스트에 저장
				memberList.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 해제
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

//	      System.out.println(memberList);
		// 조회 결과 반환
		return memberList;
	}

	@Override
	public List<Rest_info> restlike(Connection conn, String userId) {
		
		PreparedStatement ps = null; // SQL수행 객체
		ResultSet rs = null; // 조회결과 객체
		
		String sql = "";
		sql += "select l.rest_no,l.user_id, r.rest_name from rest_like_table l, rest_info r";
		sql += " where l.rest_no = r.rest_no AND l.user_id = ?";

		List<Rest_info> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Rest_info info = new Rest_info();

				info.setRest_no(rs.getInt("rest_no"));
				info.setRest_name(rs.getString("rest_name"));
				
				list.add(info);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

//		System.out.println(list);
		return list;
	}

	@Override
	public List<Recipe_Table> recipelike(Connection conn, String userId) {

		PreparedStatement ps = null; // SQL수행 객체
		ResultSet rs = null; // 조회결과 객체
		
		String sql = "";
		sql += "select rl.recipe_no,rl.user_id, rr.recipe_name from recipe_like_table rl, recipe_table rr";
		sql += " where rl.recipe_no = rr.recipe_no AND rl.user_id = ?";
		
		List<Recipe_Table> rlist = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Recipe_Table rinfo = new Recipe_Table();

				rinfo.setRecipe_no(rs.getInt("recipe_no"));
				rinfo.setRecipe_name(rs.getString("recipe_name"));
				
				rlist.add(rinfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

//		System.out.println(list);
		
		return rlist;
	}

}
