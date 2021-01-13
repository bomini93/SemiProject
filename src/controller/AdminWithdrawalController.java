package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.face.AdminMemberService;
import service.impl.AdminMemberServiceImpl;

@WebServlet("/admin/withdrawal")
public class AdminWithdrawalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminMemberService adminMemberService = new AdminMemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/admin/adminwithdrawal.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST요청");
		
		String id = req.getParameter("user_id");
		
		Member member = new Member();
		
		member.setUser_id(id);
		
		int res = adminMemberService.withdrawal(member);
		
	
		
		if(res > 0) {
			req.getRequestDispatcher("/WEB-INF/admin/withdrawalSuccess.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/WEB-INF/admin/withdrawalFail.jsp").forward(req, resp);
		}
		
	}
	
	
}
