package service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import dao.face.RestReportDao;
import dao.impl.RestReportDaoImpl;
import dto.Report_rest_table;
import service.face.RestReportService;

public class RestReportServiceImpl implements RestReportService {

	private RestReportDao rrd = new RestReportDaoImpl();
	
	@Override
	public void reportRest(Report_rest_table rrt) {
		Connection conn = JDBCTemplate.getConnection(); 
		
		int result = rrd.reportRest(conn, rrt);
		
		 if(result > 0) {
	         JDBCTemplate.commit(conn); //커밋
	      } else {
	         JDBCTemplate.rollback(conn); //롤백
	      }
		
	}

}
