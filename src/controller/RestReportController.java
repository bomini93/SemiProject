package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Report_rest_table;
import dto.Rest_review_table;
import service.face.RestReportService;
import service.impl.RestReportServiceImpl;

/**
 * Servlet implementation class RestReportController
 */
@WebServlet("/rest/report")
public class RestReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RestReportService reportService = new RestReportServiceImpl();
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		System.out.println("report GET 승인완료");
		
		String restreviewno = req.getParameter("rest_review_no");
		String restno = req.getParameter("rest_no");
		String userno = req.getParameter("user_no");
		
		System.out.println("restno : " + restno);
		System.out.println("reviewno : " + restreviewno);
		System.out.println("userno : " + userno);
		
		int rest_review_no = Integer.parseInt(restreviewno);;
		int rest_no = Integer.parseInt(restno);
		int user_no = Integer.parseInt(userno);

	
		Report_rest_table rrt = new Report_rest_table();
		rrt.setRest_review_no(rest_review_no);
		rrt.setUser_no(user_no);
		
		reportService.reportRest(rrt);
		
		resp.sendRedirect("/rest/detail?rest_no=" + rest_no);
	}
}
