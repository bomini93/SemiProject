package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import common.Paging;
import dao.face.RecipeInfoDao;
import dto.Recipe_Table;
import dto.Rest_info;

public class RecipeInfoDaoImpl implements RecipeInfoDao {
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<Recipe_Table> selectList(Connection conn) {
		String sql="";
		sql += "SELECT * FROM recipe";
		sql += " ORDER BY recipe_no DESC";
		
		// 조회 결과 저장 LIST(recipe dto)
		List<Recipe_Table> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		
			while(rs.next()) {
			Recipe_Table recipe = new Recipe_Table();
			
			
			//결과값 한 행 처리
			recipe.setRecipe_name( rs.getString("recipe_name") );
			recipe.setRecipe_kinds( rs.getString("recipe_kinds") );
			recipe.setRecipe_ing( rs.getString("recipe_ing") );
			recipe.setRecipe_time( rs.getString("recipe_time") );
			recipe.setRecipe_date( rs.getDate("recipe_date") );
			
			
			list.add(recipe);
			
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
		
	}

	
	
	
	
//	@Override
//	public int selectCntAll(Connection connection) {
//		
//		//SQL 작성
//		String sql = "";
//		sql += "SELECT count(*) FROM recipe";
//		
//		//결과 저장할 변수
//		int totalCount = 0;
//		
//		try {
//			ps = connection.prepareStatement(sql); //SQL수행 객체
//			
//			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
//			
//			//조회 결과 처리
//			while(rs.next()) {
//				totalCount = rs.getInt(1);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			//DB객체 닫기
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		//최종 결과 반환
//		return totalCount;
//		
//	}
	
//	@Override
//	public int selectCntAll(Connection connection, String[] kinds, String[] ing) {
//		
//		//SQL 작성
//		String sql = "";
//		sql += "SELECT count(*) FROM recipe";
//		sql += " WHERE 1=1";
//		if(kinds != null) {
//			sql += " OR recipe_kinds IN (";
//			for(int i=0; i<kinds.length; i++) {
//				if(i != 0) {
//					sql += ",";
//				}
//
//				sql+= kinds[i];
//			}
//			sql += ")";
//		}
//		if(ing!=null) {
//			sql += " OR recipe_ing IN (";
//			for(int i=0; i<ing.length; i++) {
//				if(i != 0) {
//					sql += ",";
//				}
//
//				sql+= ing[i];
//			}
//			sql += ")";
//		}
////		System.out.println(sql);
//		
//		//결과 저장할 변수
//		int totalCount = 0;
//		
//		try {
//			ps = connection.prepareStatement(sql); //SQL수행 객체
//			
//			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
//			
//			//조회 결과 처리
//			while(rs.next()) {
//				totalCount = rs.getInt(1);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			//DB객체 닫기
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		//최종 결과 반환
//		return totalCount;
//		
//	}

//	@Override
//	public int selectCntAll(Connection connection, String keyword) {
//		//SQL 작성
//		String sql = "";
//		sql += "SELECT count(*) FROM recipe";
//		sql += " WHERE 1=1";
//		sql += " AND recipe_name LIKE ?";
//
////		System.out.println(sql);
//		
//		//결과 저장할 변수
//		int totalCount = 0;
//		
//		try {
//			ps = connection.prepareStatement(sql); //SQL수행 객체
//			
//			ps.setString(1, "%" + keyword + "%");
//			
//			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
//			
//			//조회 결과 처리
//			while(rs.next()) {
//				totalCount = rs.getInt(1);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			//DB객체 닫기
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		//최종 결과 반환
//		return totalCount;
//	}

//	@Override
//	public List<Recipe> selectList(Connection connection, Paging paging) {
//		
//		//SQL 작성
//		String sql = "";
//		sql += "SELECT * FROM (";
//		sql += "	SELECT rownum rnum, R.* FROM (";
//		sql += "		SELECT";
//		sql += "			 recipe_name, recipe_time";
//		sql += "		FROM recipe";
//		sql += "		ORDER BY recipe_no DESC";
//		sql += "	) R";
//		sql += " ) RECIPE";
//		sql += " WHERE rnum BETWEEN ? AND ?";
//		
//		//결과 저장할 List
//		List<Recipe> recipeList = new ArrayList<>();
//		
//		try {
//			ps = connection.prepareStatement(sql); //SQL수행 객체
//			
//			ps.setInt(1, paging.getStartNo());
//			ps.setInt(2, paging.getEndNo());
//			
//			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
//			
//			//조회 결과 처리
//			while(rs.next()) {
//				Recipe r = new Recipe(); //결과값 저장 객체
//				
//				//결과값 한 행 처리
//				r.setRecipe_name( rs.getString("recipe_name") );
//				r.setRecipe_time( rs.getString("recipe_time") );
//				
//				
//				//리스트에 결과값 저장
//				recipeList.add(r);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			//DB객체 닫기
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		//최종 결과 반환
//		return recipeList;
//	}


//	@Override
//	public List<Recipe> selectList(Connection connection, Paging paging, String[] kinds, String[] ing) {
//		//SQL 작성
//		String sql = "";
//		sql += "SELECT * FROM (";
//		sql += "	SELECT rownum rnum, R.* FROM (";
//		sql += "		SELECT";
//		sql += "			 recipe_name, recipe_time";
//		sql += "		FROM recipe";
//		sql += "		WHERE 1=1";
//		if(kinds != null) {
//			sql += " OR recipe_kinds IN (";
//			for(int i=0; i<kinds.length; i++) {
//				if(i != 0) {
//					sql += ",";
//				}
//
//				sql+= kinds[i];
//			}
//			sql += ")";
//		}
//		if(ing!=null) {
//			sql += " OR recipe_ing IN (";
//			for(int i=0; i<ing.length; i++) {
//				if(i != 0) {
//					sql += ",";
//				}
//
//				sql+= ing[i];
//			}
//			sql += ")";
//		}
//		sql += "		ORDER BY recipe_no DESC";
//		sql += "	) R";
//		sql += " ) RECIPE";
//		sql += " WHERE rnum BETWEEN ? AND ?";
//		
//		//결과 저장할 List
//		List<Recipe> recipeList = new ArrayList<>();
//		
//		try {
//			ps = connection.prepareStatement(sql); //SQL수행 객체
//			
//			ps.setInt(1, paging.getStartNo());
//			ps.setInt(2, paging.getEndNo());
//			
//			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
//			
//			//조회 결과 처리
//			while(rs.next()) {
//				Recipe r = new Recipe(); //결과값 저장 객체
//				
//				//결과값 한 행 처리
//				r.setRecipe_name( rs.getString("recipe_name") );
//				r.setRecipe_time( rs.getString("recipe_time") );
//				
//				
//				//리스트에 결과값 저장
//				recipeList.add(r);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			//DB객체 닫기
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		//최종 결과 반환
//		return recipeList;
//	}
	
//	@Override
//	public List<Recipe> selectList(Connection connection, Paging paging, String keyword) {
//		//SQL 작성
//		String sql = "";
//		sql += "SELECT * FROM (";
//		sql += "	SELECT rownum rnum, R.* FROM (";
//		sql += "		SELECT";
//		sql += "			 recipe_name, recipe_time";
//		sql += "		FROM recipe";
//		sql += " 		AND recipe_name LIKE ?";
//		sql += "		ORDER BY recipe_no DESC";
//		sql += "	) R";
//		sql += " ) RECIPE";
//		sql += " WHERE rnum BETWEEN ? AND ?";
//		
//		//결과 저장할 List
//		List<Recipe> recipeList = new ArrayList<>();
//		
//		try {
//			ps = connection.prepareStatement(sql); //SQL수행 객체
//
//			ps.setString(1, "%" + keyword + "%");
//
//			ps.setInt(2, paging.getStartNo());
//			ps.setInt(3, paging.getEndNo());
//			
//			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
//			
//			//조회 결과 처리
//			while(rs.next()) {
//				Recipe r = new Recipe(); //결과값 저장 객체
//				
//				//결과값 한 행 처리
//				r.setRecipe_name( rs.getString("recipe_name") );
//				r.setRecipe_time( rs.getString("recipe_time") );
//				
//				
//				//리스트에 결과값 저장
//				recipeList.add(r);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			//DB객체 닫기
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		//최종 결과 반환
//		return recipeList;
//	}
	
	
	
	
	
	
	
	@Override
//	public int selectCntAll(Connection connection, String[] kinds, String[] ing, String content) {
	public int selectCntAll(Connection connection, String content) {

		
//		String sql_kinds = "";
//		sql_kinds += " SELECT * FROM recipe";
//		if(kinds != null) {
//			sql_kinds += " 	WHERE recipe_kinds IN (";
//			for(int i=0; i<kinds.length; i++) {
//				if(i != 0)	sql_kinds += ",";
//				sql_kinds+= "'" + kinds[i] + "'";
//			}
//			sql_kinds += ")";
//		}
//		
//		String sql_ing = "";		
//		sql_ing += " SELECT * FROM recipe";
//		if(ing != null) {
//			sql_ing += " 	WHERE recipe_ing IN (";
//			for(int i=0; i<ing.length; i++) {
//				if(i != 0)	sql_ing += ",";
//				sql_ing+= "'" + ing[i] + "'";
//			}
//			sql_ing += ")";
//		}
		
		String sql_content = "";
		sql_content += " SELECT * FROM recipe";
		if(content!=null && !"".equals(content)) {
			sql_content += " 	WHERE recipe_name LIKE ?";
		}
		
		
		
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM (";
		sql += "		SELECT";
		sql += "			*";
		sql += " 		FROM recipe RC";
		if(content!=null && !"".equals(content)) {
		sql += "		WHERE recipe_name LIKE ?";
		}
//		sql += "		WHERE 1=0";
//		if(kinds != null) {
//			sql += " UNION";
//			sql += sql_kinds;
//		}
//		if(ing!=null) {
//			sql += " UNION";
//			sql += sql_ing;
//		}
//		if(content!=null && !"".equals(content)) {
//			sql += " UNION";
//			sql += sql_content;
//		}
		sql += " )";

		System.out.println(sql);
		
		//결과 저장할 변수
		int totalCount = 0;
		
		try {
			ps = connection.prepareStatement(sql); //SQL수행 객체
			
			if(content!=null && !"".equals(content)) {
				ps.setString(1, "%" + content + "%");
			}
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return totalCount;
		
	}
	
	

	@Override
//	public List<Recipe> selectList_new(Connection connection, Paging paging, String[] kinds, String[] ing,
//			String content) {
	public List<Recipe_Table> selectList(Connection connection, Paging paging, String content) {	
		

//		String sql_kinds = "";
//		sql_kinds += " SELECT * FROM recipe";
//		if(kinds != null) {
//			sql_kinds += " 	WHERE recipe_kinds IN (";
//			for(int i=0; i<kinds.length; i++) {
//				if(i != 0)	sql_kinds += ",";
//				sql_kinds+= "'" + kinds[i] + "'";
//			}
//			sql_kinds += ")";
//		}
		
//		String sql_ing = "";		
//		sql_ing += " SELECT * FROM recipe";
//		if(ing != null) {
//			sql_ing += " 	WHERE recipe_ing IN (";
//			for(int i=0; i<ing.length; i++) {
//				if(i != 0)	sql_ing += ",";
//				sql_ing+= "'" + ing[i] + "'";
//			}
//			sql_ing += ")";
//		}
		
		String sql_content = "";
		sql_content += " SELECT * FROM recipe";
		if(content!=null && !"".equals(content)) {
			sql_content += " 	WHERE recipe_name LIKE ?";
		}
		
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, R.* FROM (";
		sql += "		SELECT";
		sql += "			*";
		sql += " 		FROM recipe RC";
		if(content!=null && !"".equals(content)) {
			sql += " 	WHERE recipe_name LIKE ?";
		}
//		sql += "			WHERE 1=1";
//		if(kinds != null) {
//			sql += " UNION";
//			sql += sql_kinds;
//		}
//		if(ing!=null) {
//			sql += " UNION";
//			sql += sql_ing;
//		}
//		if(content!=null && !"".equals(content)) {
//			sql += " UNION";
//			sql += sql_content;
//		}
		sql += "		ORDER BY recipe_no DESC";
		sql += "	) R";
		sql += " ) RECIPE";
		sql += " WHERE rnum BETWEEN ? AND ?";
		System.out.println(sql);

		//결과 저장할 List
		List<Recipe_Table> recipeList = new ArrayList<>();

		try {
			ps = connection.prepareStatement(sql); //SQL수행 객체

			int idx = 1;
			if(content!=null && !"".equals(content)) {
				ps.setString(idx++, "%" + content + "%");
			}
			ps.setInt(idx++, paging.getStartNo());
			ps.setInt(idx++, paging.getEndNo());

			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장

			//조회 결과 처리
			while(rs.next()) {
				Recipe_Table r = new Recipe_Table(); //결과값 저장 객체

				//결과값 한 행 처리
				r.setRecipe_name( rs.getString("recipe_name") );
				r.setRecipe_kinds( rs.getString("recipe_kinds") );
				r.setRecipe_ing( rs.getString("recipe_ing") );
				r.setRecipe_time( rs.getString("recipe_time") );
				r.setRecipe_date( rs.getDate("recipe_date") );

				//리스트에 결과값 저장
				recipeList.add(r);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		//최종 결과 반환
		return recipeList;
	}




	// 메인재료엥커 선택
	@Override
	public List<Recipe_Table> selectList(Connection connection, Paging paging) {

		//SQL 작성
				String sql = "";
//				sql += "SELECT * FROM (";
//				sql += "	SELECT rownum rnum, R.* FROM (";
//				sql += "		SELECT";
//				sql += "			recipe_name, recipe_kinds, recipe_ing";
//				sql += "			, recipe_time, recipe_date";
//				sql += "		FROM recipe";
//				sql += "		ORDER BY recipe_no DESC";
//				sql += "	) R";
//				sql += " ) Recipe";
//				sql += " WHERE rnum BETWEEN ? AND ?";
				
				sql += "SELECT * FROM recipe";
				sql += " WHERE recipe_ing='pork'";
				sql += " WHERE rnum BETWEEN ? AND ?";
				
				
				
				//결과 저장할 List
				List<Recipe_Table> recipeList = new ArrayList<>();
				
				try {
					ps = connection.prepareStatement(sql); //SQL수행 객체
					
					ps.setInt(1, paging.getStartNo());
					ps.setInt(2, paging.getEndNo());
					
					rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
					
					//조회 결과 처리
					while(rs.next()) {
						Recipe_Table r = new Recipe_Table(); //결과값 저장 객체
						
						//결과값 한 행 처리
						r.setRecipe_name( rs.getString("recipe_name") );
						r.setRecipe_kinds( rs.getString("recipe_kinds") );
						r.setRecipe_ing( rs.getString("recipe_ing") );
						r.setRecipe_time( rs.getString("recipe_time") );
						r.setRecipe_date( rs.getDate("recipe_date") );
						
						//리스트에 결과값 저장
						recipeList.add(r);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					//DB객체 닫기
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
				
				//최종 결과 반환
				return recipeList;
			}
		
		
	/////////////////////////////////////////레시피_ing 재료////////////////////////////////
	
	

		@Override
		public List<Recipe_Table> selectAll(Connection conn, Paging paging) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = "";
			sql += "SELECT * FROM(";
			sql += " SELECT rownum rnum, A.* FROM";
			sql += " (SELECT * FROM Recipe_Table";
			sql += " ORDER BY recipe_date DESC)A)";
			sql += " WHERE rnum BETWEEN ? AND ?";
			
			List<Recipe_Table> recipeinfolist = new ArrayList<>();
			
			try {

				ps= conn.prepareStatement(sql);
				
				ps.setInt(1, paging.getStartNo());
				ps.setInt(2, paging.getEndNo());
				
				rs = ps.executeQuery();

				while(rs.next()) {
					
					Recipe_Table recipeinfo = new Recipe_Table();
					
					recipeinfo.setRecipe_new_name(rs.getString("recipe_new_name"));
					recipeinfo.setRecipe_name(rs.getString("recipe_name"));
					recipeinfo.setRecipe_kinds(rs.getString("recipe_kinds"));
					recipeinfo.setRecipe_ing(rs.getString("recipe_ing"));
					recipeinfo.setRecipe_no(rs.getInt("recipe_no"));
					recipeinfo.setRecipe_time(rs.getString("recipe_time"));
					recipeinfo.setRecipe_date( rs.getDate("recipe_date"));
					
					recipeinfolist.add(recipeinfo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
				
			}
			
			return recipeinfolist;
			
		}





		@Override
		public List<Recipe_Table> selectPork(Connection conn, Paging paging) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = "";
			sql += "SELECT * FROM(";
			sql += " SELECT rownum rnum, A.* FROM";
			sql += " (SELECT * FROM Recipe_Table";
			sql += " WHERE recipe_ing='돼지고기'";
			sql += " ORDER BY recipe_date)A)";
			sql += " WHERE rnum BETWEEN ? AND ?";
			
			List<Recipe_Table> recipeinfolist = new ArrayList<>();
			
			try {

				ps= conn.prepareStatement(sql);
				
				ps.setInt(1, paging.getStartNo());
				ps.setInt(2, paging.getEndNo());
				
				rs = ps.executeQuery();

				while(rs.next()) {
					
					Recipe_Table recipeinfo = new Recipe_Table();
					
					recipeinfo.setRecipe_new_name(rs.getString("recipe_new_name"));
					recipeinfo.setRecipe_name(rs.getString("recipe_name"));
					recipeinfo.setRecipe_kinds(rs.getString("recipe_kinds"));
					recipeinfo.setRecipe_no(rs.getInt("recipe_no"));
					recipeinfo.setRecipe_ing(rs.getString("recipe_ing"));
					recipeinfo.setRecipe_time(rs.getString("recipe_time"));
					recipeinfo.setRecipe_date( rs.getDate("recipe_date"));
					
					recipeinfolist.add(recipeinfo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
				
			}
			
			return recipeinfolist;
		}





		@Override
		public List<Recipe_Table> selectBeef(Connection conn, Paging paging) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = "";
			sql += "SELECT * FROM(";
			sql += " SELECT rownum rnum, A.* FROM";
			sql += " (SELECT * FROM Recipe_Table";
			sql += " WHERE recipe_ing='소고기'";
			sql += " ORDER BY recipe_date)A)";
			sql += " WHERE rnum BETWEEN ? AND ?";
			
			List<Recipe_Table> recipeinfolist = new ArrayList<>();
			
			try {

				ps= conn.prepareStatement(sql);
				
				ps.setInt(1, paging.getStartNo());
				ps.setInt(2, paging.getEndNo());
				
				rs = ps.executeQuery();

				while(rs.next()) {
					
					Recipe_Table recipeinfo = new Recipe_Table();
					
					recipeinfo.setRecipe_new_name(rs.getString("recipe_new_name"));
					recipeinfo.setRecipe_name(rs.getString("recipe_name"));
					recipeinfo.setRecipe_kinds(rs.getString("recipe_kinds"));
					recipeinfo.setRecipe_ing(rs.getString("recipe_ing"));
					recipeinfo.setRecipe_no(rs.getInt("recipe_no"));
					recipeinfo.setRecipe_time(rs.getString("recipe_time"));
					recipeinfo.setRecipe_date( rs.getDate("recipe_date"));
					
					recipeinfolist.add(recipeinfo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
				
			}
			
			return recipeinfolist;
		}





		@Override
		public List<Recipe_Table> selectChicken(Connection conn, Paging paging) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = "";
			sql += "SELECT * FROM(";
			sql += " SELECT rownum rnum, A.* FROM";
			sql += " (SELECT * FROM Recipe_Table";
			sql += " WHERE recipe_ing='닭고기'";
			sql += " ORDER BY recipe_date)A)";
			sql += " WHERE rnum BETWEEN ? AND ?";
			
			List<Recipe_Table> recipeinfolist = new ArrayList<>();
			
			try {

				ps= conn.prepareStatement(sql);
				
				ps.setInt(1, paging.getStartNo());
				ps.setInt(2, paging.getEndNo());
				
				rs = ps.executeQuery();

				while(rs.next()) {
					
					Recipe_Table recipeinfo = new Recipe_Table();
					
					recipeinfo.setRecipe_new_name(rs.getString("recipe_new_name"));
					recipeinfo.setRecipe_name(rs.getString("recipe_name"));
					recipeinfo.setRecipe_kinds(rs.getString("recipe_kinds"));
					recipeinfo.setRecipe_ing(rs.getString("recipe_ing"));
					recipeinfo.setRecipe_time(rs.getString("recipe_time"));
					recipeinfo.setRecipe_no(rs.getInt("recipe_no"));
					recipeinfo.setRecipe_date( rs.getDate("recipe_date"));
					
					recipeinfolist.add(recipeinfo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
				
			}
			
			return recipeinfolist;
		}





		@Override
		public List<Recipe_Table> selectDuck(Connection conn, Paging paging) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = "";
			sql += "SELECT * FROM(";
			sql += " SELECT rownum rnum, A.* FROM";
			sql += " (SELECT * FROM Recipe_Table";
			sql += " WHERE recipe_ing='오리고기'";
			sql += " ORDER BY recipe_date)A)";
			sql += " WHERE rnum BETWEEN ? AND ?";
			
			List<Recipe_Table> recipeinfolist = new ArrayList<>();
			
			try {

				ps= conn.prepareStatement(sql);
				
				ps.setInt(1, paging.getStartNo());
				ps.setInt(2, paging.getEndNo());
				
				rs = ps.executeQuery();

				while(rs.next()) {
					
					Recipe_Table recipeinfo = new Recipe_Table();
					
					recipeinfo.setRecipe_new_name(rs.getString("recipe_new_name"));
					recipeinfo.setRecipe_name(rs.getString("recipe_name"));
					recipeinfo.setRecipe_kinds(rs.getString("recipe_kinds"));
					recipeinfo.setRecipe_ing(rs.getString("recipe_ing"));
					recipeinfo.setRecipe_no(rs.getInt("recipe_no"));
					recipeinfo.setRecipe_time(rs.getString("recipe_time"));
					recipeinfo.setRecipe_date( rs.getDate("recipe_date"));
					
					recipeinfolist.add(recipeinfo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
				
			}
			
			return recipeinfolist;
		}





		@Override
		public List<Recipe_Table> selectSeafood(Connection conn, Paging paging) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = "";
			sql += "SELECT * FROM(";
			sql += " SELECT rownum rnum, A.* FROM";
			sql += " (SELECT * FROM Recipe_Table";
			sql += " WHERE recipe_ing='해물류'";
			sql += " ORDER BY recipe_date)A)";
			sql += " WHERE rnum BETWEEN ? AND ?";
			
			List<Recipe_Table> recipeinfolist = new ArrayList<>();
			
			try {

				ps= conn.prepareStatement(sql);
				
				ps.setInt(1, paging.getStartNo());
				ps.setInt(2, paging.getEndNo());
				
				rs = ps.executeQuery();

				while(rs.next()) {
					
					Recipe_Table recipeinfo = new Recipe_Table();
					
					recipeinfo.setRecipe_new_name(rs.getString("recipe_new_name"));
					recipeinfo.setRecipe_name(rs.getString("recipe_name"));
					recipeinfo.setRecipe_kinds(rs.getString("recipe_kinds"));
					recipeinfo.setRecipe_ing(rs.getString("recipe_ing"));
					recipeinfo.setRecipe_no(rs.getInt("recipe_no"));
					recipeinfo.setRecipe_time(rs.getString("recipe_time"));
					recipeinfo.setRecipe_date( rs.getDate("recipe_date"));
					
					recipeinfolist.add(recipeinfo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
				
			}
			
			return recipeinfolist;
		}





		@Override
		public List<Recipe_Table> selectGreen(Connection conn, Paging paging) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = "";
			sql += "SELECT * FROM(";
			sql += " SELECT rownum rnum, A.* FROM";
			sql += " (SELECT * FROM Recipe_Table";
			sql += " WHERE recipe_ing='채소류'";
			sql += " ORDER BY recipe_date)A)";
			sql += " WHERE rnum BETWEEN ? AND ?";
			
			List<Recipe_Table> recipeinfolist = new ArrayList<>();
			
			try {

				ps= conn.prepareStatement(sql);
				
				ps.setInt(1, paging.getStartNo());
				ps.setInt(2, paging.getEndNo());
				
				rs = ps.executeQuery();

				while(rs.next()) {
					
					Recipe_Table recipeinfo = new Recipe_Table();
					
					recipeinfo.setRecipe_new_name(rs.getString("recipe_new_name"));
					recipeinfo.setRecipe_name(rs.getString("recipe_name"));
					recipeinfo.setRecipe_kinds(rs.getString("recipe_kinds"));
					recipeinfo.setRecipe_no(rs.getInt("recipe_no"));
					recipeinfo.setRecipe_ing(rs.getString("recipe_ing"));
					recipeinfo.setRecipe_time(rs.getString("recipe_time"));
					recipeinfo.setRecipe_date( rs.getDate("recipe_date"));
					
					recipeinfolist.add(recipeinfo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
				
			}
			
			return recipeinfolist;
		}





		@Override
		public List<Recipe_Table> selectEtc(Connection conn, Paging paging) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = "";
			sql += "SELECT * FROM(";
			sql += " SELECT rownum rnum, A.* FROM";
			sql += " (SELECT * FROM Recipe_Table";
			sql += " WHERE recipe_ing='기타'";
			sql += " ORDER BY recipe_date)A)";
			sql += " WHERE rnum BETWEEN ? AND ?";
			
			List<Recipe_Table> recipeinfolist = new ArrayList<>();
			
			try {

				ps= conn.prepareStatement(sql);
				
				ps.setInt(1, paging.getStartNo());
				ps.setInt(2, paging.getEndNo());
				
				rs = ps.executeQuery();

				while(rs.next()) {
					
					Recipe_Table recipeinfo = new Recipe_Table();
					
					recipeinfo.setRecipe_new_name(rs.getString("recipe_new_name"));
					recipeinfo.setRecipe_name(rs.getString("recipe_name"));
					recipeinfo.setRecipe_kinds(rs.getString("recipe_kinds"));
					recipeinfo.setRecipe_ing(rs.getString("recipe_ing"));
					recipeinfo.setRecipe_time(rs.getString("recipe_time"));
					recipeinfo.setRecipe_no(rs.getInt("recipe_no"));
					recipeinfo.setRecipe_date( rs.getDate("recipe_date"));
					
					recipeinfolist.add(recipeinfo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
				
			}
			
			return recipeinfolist;
		}
		
		
		}









