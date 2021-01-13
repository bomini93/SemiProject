package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import dto.Report_Recipe_Table;
import service.face.AdminReportService;
import service.impl.AdminReportServiceImpl;

@WebServlet("/admin/report")
public class AdminReportCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminReportService adminreportService = new AdminReportServiceImpl() {
	};
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//페이징 정보 생성하기
		Paging paging = adminreportService.getPaging(req);
		
		//Paging처리 결과 MODEL값 전달
		req.setAttribute("paging", paging);
		
		List<Report_Recipe_Table> list = adminreportService.getList(paging);
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/admin/adminreportlist.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
