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
import dao.face.RecipeDetailDao;
import dto.Member;
import dto.Recipe_Photo;
import dto.Recipe_Table;
import dto.Recipe_review_table;

public class RecipeDetailDaoImpl implements RecipeDetailDao{

	PreparedStatement ps = null; //SQL수행 객체
	ResultSet rs = null; //조회결과 객체
	
	@Override
	public Recipe_Table selectByRecipeno(Connection conn, Recipe_Table recipe_table) {
		
		String sql = "";
		sql += "SELECT * FROM RECIPE_TABLE";
		sql += " WHERE recipe_no = ?";
		
		Recipe_Table res = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, recipe_table.getRecipe_no());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				res = new Recipe_Table();
				
				res.setRecipe_no(rs.getInt("recipe_no"));
				res.setRecipe_name(rs.getString("recipe_name"));
				res.setRecipe_kinds(rs.getString("recipe_kinds"));
				res.setRecipe_ing(rs.getString("recipe_ing"));
				res.setRecipe_date(rs.getDate("recipe_date"));
				res.setRecipe_new_name(rs.getString("recipe_new_name"));
				res.setRecipe_text01(rs.getString("recipe_text01"));
				res.setRecipe_text02(rs.getString("recipe_text02"));
				res.setRecipe_text03(rs.getString("recipe_text03"));
				res.setRecipe_text04(rs.getString("recipe_text04"));
				res.setRecipe_text05(rs.getString("recipe_text05"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}

	@Override
	public List<Recipe_Photo> selectPhoto(Connection conn, Recipe_Photo recipe_photo) {
		
		String sql = "";
		sql += "SELECT r.recipe_no, p.photo_after";
		sql += " FROM recipe_table r, recipe_photo p";
		sql += " WHERE r.recipe_no = p.recipe_no (+) AND r.recipe_no = ?";
		sql += " ORDER BY p.recipe_photo_no";
		
		Recipe_Photo pres = null;
		List<Recipe_Photo> preslist = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, recipe_photo.getRecipe_no());
			
			rs = ps.executeQuery();
			

			while(rs.next()) {
				pres = new Recipe_Photo();
				
				pres.setRecipe_no(rs.getInt("recipe_no"));
				pres.setPhoto_after(rs.getString("photo_after"));
				
				preslist.add(pres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return preslist;
	}

	@Override
	   public List<Map> reviewlist(Connection conn, int recipeno) {
	      
	      
	      String sql = "";
	      sql += "select r.recipe_review_no, r.user_no, r.recipe_review_text, r.recipe_rating, r.recipe_review_date, m.user_id from recipe_review_table r, member m";
	      sql += " where r.user_no = m.user_no AND r.recipe_no = ?";
	      sql += " order by r.recipe_review_no Desc";
	      
	      
	      List<Map> reviewlist = new ArrayList<>();
	      try {
	         ps = conn.prepareStatement(sql);
	         
	         ps.setInt(1, recipeno);
	         
	         rs = ps.executeQuery();
	         
	         while(rs.next()) {
	            Map<String, Object> map = new HashMap<String, Object>();
	            Member mem = new Member();
	            Recipe_review_table rrt = new Recipe_review_table();
	            
	            mem.setUser_id(rs.getString("user_id"));
	            mem.setUser_no(rs.getInt("user_no"));
	            
	            rrt.setRecipe_review_no(rs.getInt("recipe_review_no"));
	            rrt.setRecipe_review_text(rs.getString("recipe_review_text"));
	            rrt.setRecipe_rating(rs.getInt("recipe_rating"));
	            rrt.setRecipe_review_date(rs.getDate("recipe_review_date"));
	            
	            map.put("mem", mem);
	            map.put("rrt", rrt);
	            
	            reviewlist.add(map);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return reviewlist;
	   }

	}

