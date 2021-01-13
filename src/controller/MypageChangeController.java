package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Member;
import service.face.MypageChangeService;
import service.impl.MypageChangeServiceImpl;

@WebServlet("/mypage/change")
public class MypageChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MypageChangeService changeService = new MypageChangeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("change doget");
	
	
	req.getRequestDispatcher("/WEB-INF/mypage/infoChange.jsp").forward(req, resp);
	
}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("change dopost");
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		String gender = req.getParameter("user_gender");
		String spicy = req.getParameter("spicy_no");
		String amount = req.getParameter("amount_no");
		

		Member member = new Member();
		
//		member.setUser_pw(pw);
		member.setSpicy_no(spicy);
		member.setAmount_no(amount);
		
		HttpSession session = req.getSession();
		
		String userId = (String)session.getAttribute("sessionId");
		
		System.out.println("session ID");
		System.out.println(userId);
		changeService.update(userId, member);
			
		resp.sendRedirect("/mypage");
		
	}

}
