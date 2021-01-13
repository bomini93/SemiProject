package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.face.MemberService;
import service.impl.MemberServiceImpl;

@WebServlet("/memberid/check")
public class MemberIdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//MemberService 객체 생성
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/loginSuccess/IdCheckForm.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("user_id");
		
		Member member = new Member();
		
		member.setUser_id(id);
		
		int res = memberService.idCheck(member);
		
		
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().println("{\"result\":"+res+"}");
		
		
	}
}
