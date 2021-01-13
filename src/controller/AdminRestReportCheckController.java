package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.face.AdminRestReportService;
import service.impl.AdminRestReportServiceImpl;

@WebServlet("/admin/rest/report")
public class AdminRestReportCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminRestReportService adminrestreportService = new AdminRestReportServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//페이징 처리 안함 
		 
		List<Map> reportlist = adminrestreportService.getList();
		
		req.setAttribute("reportlist", reportlist);
		
		req.getRequestDispatcher("/WEB-INF/admin/adminrestreportlist.jsp")
			.forward(req, resp);
	}
	
	
}
