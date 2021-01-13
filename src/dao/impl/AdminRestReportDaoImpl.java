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
import dao.face.AdminRestReportDao;
import dto.Report_rest_table;
import dto.Rest_review_table;

public class AdminRestReportDaoImpl implements AdminRestReportDao{
	
	PreparedStatement ps = null;
    ResultSet rs = null;
    
	@Override
	public List<Map> selectAll(Connection conn) {
	
         String sql = "";
         sql += "select r.rest_review_no,r.user_no,rw.rest_no,rw.rest_review_text, count(*) cnt from report_rest_table r, rest_review_table rw";
         sql += " where r.rest_review_no = rw.rest_review_no";
         sql += " group by r.rest_review_no,r.user_no, rw.rest_no, rw.rest_review_text";

         List<Map> restreportlist = new ArrayList<>();
         
         try {
            ps = conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
              Report_rest_table rrt = new Report_rest_table();
              Rest_review_table rwt = new Rest_review_table();
          
               Map<String, Object> map = new HashMap<>();
               
               rrt.setRest_review_no(rs.getInt("rest_review_no"));
               rrt.setUser_no(rs.getInt("user_no"));
               rrt.setCnt(rs.getInt("cnt"));
               
               
               rwt.setRest_no(rs.getInt("rest_no"));
               rwt.setRest_review_text(rs.getString("rest_review_text"));
               
               map.put("rest_review_no", rrt);
               map.put("rest_review_text", rwt);
               
               restreportlist.add(map);
               
            }
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(ps);
         }
         
         return restreportlist;
	}

}
