package service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dao.face.AdminReportDao;
import dao.impl.AdminReportDaoImpl;
import dto.Report_Recipe_Table;
import service.face.AdminReportService;

public class AdminReportServiceImpl implements AdminReportService{

private AdminReportDao adminreportDao = new AdminReportDaoImpl();
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
				
		//Board 테이블의 총 게시글 수를 조회한다
		int totalCount = adminreportDao.selectCntAll(JDBCTemplate.getConnection());
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage); 
				
		//계산된 Paging 객체 반환
		return paging;
				
	}

	@Override
	public List<Report_Recipe_Table> getList(Paging paging) {
		return adminreportDao.selectList(JDBCTemplate.getConnection(), paging);
	}
	
}
