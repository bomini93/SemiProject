package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Member;
import dto.Recipe_Table;
import dto.Rest_info;
import service.face.MypageService;
import service.impl.MypageServiceImpl;


@WebServlet("/mypage")
public class MemberMypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MypageService mypageService = new MypageServiceImpl();
//	private Member member = new Member();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("mypage Doget");
		
		HttpSession session = req.getSession();
		
		String str = (String) session.getAttribute("sessionId");
		
		System.out.println(str);
		
		Member uid = new Member();
		
		uid.setUser_id(str);
//		Member uid = (Member)session.getAttribute("sessionId");
		
		String userId = uid.getUser_id();
		
		List<Recipe_Table> recipelikelist = mypageService.recipelike(userId);
		
		List<Member> memberList = mypageService.list(userId);
		List<Rest_info> restlikelist = mypageService.restlike(userId);
		
		req.setAttribute("recipelike", recipelikelist);
		req.setAttribute("list", memberList);
		req.setAttribute("restlike", restlikelist);
		
		req.getRequestDispatcher("/WEB-INF/mypage/myinfo.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("mypage doPost");
		
		req.getRequestDispatcher("/WEB-INF/mypage/infoChange.jsp").forward(req, resp);
	}
}
