package service.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import common.JDBCTemplate;
import dao.face.AdminRestReportDao;
import dao.impl.AdminRestReportDaoImpl;
import service.face.AdminRestReportService;

public class AdminRestReportServiceImpl implements AdminRestReportService{

	private AdminRestReportDao adminrestreportDao = new AdminRestReportDaoImpl();
	
	@Override
	public List<Map> getList() {
		Connection conn = JDBCTemplate.getConnection();
		
		List<Map> reportlist = adminrestreportDao.selectAll(conn);
		
		return reportlist;
	}

}
