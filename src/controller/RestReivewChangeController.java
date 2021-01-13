package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Rest_review_table;
import service.face.RestReviewChangeService;
import service.impl.RestReviewChangeServiceImpl;

@WebServlet("/change")
public class RestReivewChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private RestReviewChangeService changeService = new RestReviewChangeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("change doget");
		
		System.out.println(req.getParameter("review_no"));
		req.setAttribute("review_no", req.getParameter("review_no"));
		req.setAttribute("rest_no", req.getParameter("rest_no"));
		
		req.getRequestDispatcher("/WEB-INF/rest/restChange.jsp").forward(req, resp);;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("change dopost");
		req.setCharacterEncoding("UTF-8");
		
		int rest_no = Integer.parseInt(req.getParameter("rest_no"));
		int rating = Integer.parseInt(req.getParameter("rest_rating"));
		String text = req.getParameter("rest_review_text");
		int review_no = Integer.parseInt(req.getParameter("review_no"));
		
		Rest_review_table review_table = new Rest_review_table();
		
		review_table.setRest_rating(rating);
		review_table.setRest_review_text(text);
		
		HttpSession session = req.getSession();	
		
		String userId = (String)session.getAttribute("sessionId");
		
		System.out.println("session ID");
		System.out.println(userId);
		
		changeService.update(review_no, review_table);
			
		resp.sendRedirect("/rest/detail?rest_no="+rest_no);
		
		
		
	}
}