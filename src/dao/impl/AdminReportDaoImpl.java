package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import common.Paging;
import dao.face.AdminReportDao;
import dto.Report_Recipe_Table;

public class AdminReportDaoImpl implements AdminReportDao{

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int selectCntAll(Connection connection) {
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM report_recipe_table";
		
		//결과 저장할 변수
		int totalCount = 0;
		
		try {
			ps = connection.prepareStatement(sql); //SQL수행 객체
			
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
	public List<Report_Recipe_Table> selectList(Connection connection, Paging paging) {

		String sql = "";
		sql += "Select * FROM(select rownum rnum, a.* from(select recipe_no, user_no, count(recipe_no) cnt from report_recipe_table";
		sql +=	" group by recipe_no, user_no)A)";
		sql += 	" Where rnum Between ? AND ?";

		List<Report_Recipe_Table> reportList = new ArrayList<>();
		
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Report_Recipe_Table rrt = new Report_Recipe_Table();
				
				rrt.setRecipe_no(rs.getInt("recipe_no"));
				rrt.setUser_no(rs.getInt("user_no"));
				rrt.setCnt(rs.getInt("cnt"));
				
				reportList.add(rrt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return reportList;
	}

}
