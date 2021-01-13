package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Rest_info;
import dto.Rest_review_table;
import service.face.RestInfoService;
import service.face.RestReviewListService;
import service.impl.RestInfoServiceImpl;
import service.impl.RestReviewListServiceImpl;

@WebServlet("/rest/delete")
public class RestReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RestReviewListService rest_review_service = new RestReviewListServiceImpl();
	private RestInfoService restInfoService = new RestInfoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("delete GET 승인완");
	
		int rest_review_no = Integer.parseInt(req.getParameter("rest_review_no"));
		System.out.println(rest_review_no);
		
		Rest_review_table rrt = new Rest_review_table();
		rrt.setRest_review_no(rest_review_no);
		
		HttpSession session = req.getSession();
		
//		String userid = (String)session.getAttribute("sessionId");
		String userno = (String)session.getAttribute("sessionNO");
			
		rest_review_service.deleteReview(userno, rrt );
		//-----------------------------------------------
		System.out.println(req.getParameter("rest_no"));
		
		String param = req.getParameter("rest_no");
		int rest_no = Integer.parseInt(req.getParameter("rest_no"));
				
		resp.sendRedirect("/rest/detail?rest_no="+rest_no);


	}
	
	
}
