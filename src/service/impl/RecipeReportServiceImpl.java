package service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import dao.face.RecipeReportDao;
import dao.impl.RecipeReportDaoImpl;
import dto.Report_Recipe_Table;
import service.face.RecipeReportService;

public class RecipeReportServiceImpl implements RecipeReportService{

	private RecipeReportDao recipereportDao = new RecipeReportDaoImpl();
	
	@Override
	public void join(Report_Recipe_Table report_recipe_table) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = recipereportDao.insert(conn, report_recipe_table);
		
		if(result > 0) {
			JDBCTemplate.commit(conn); //커밋
		} else {
			JDBCTemplate.rollback(conn); //롤백
		}
		
	}

}
