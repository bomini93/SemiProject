package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Rest_info;
import service.face.RestLikeService;
import service.impl.RestLikeServiceImpl;

@WebServlet("/rest/likeCancel")
public class RestLikeCancelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private RestLikeService likeService = new RestLikeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("like doget");
		
		String restno = req.getParameter("rest_no");
		
		System.out.println(restno);
		
		int rest_no = 0;
		
		if(restno != null && !"".equals(restno)) {
			rest_no = Integer.parseInt(restno);
		}
		
		Rest_info rest_info = new Rest_info();
		rest_info.setRest_no(rest_no);
		
		
		
//		System.out.println(rest_no);
//		req.setAttribute("rest_no", rest_no);
		
		// ------------------------------------
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("sessionId");
		
		
//		likeService.like(userId, rest_info);
		likeService.likeCancel(userId, rest_info);
		
		
		req.getRequestDispatcher("/WEB-INF/rest/restLikeCancel.jsp")
		.forward(req, resp);
	}

}
