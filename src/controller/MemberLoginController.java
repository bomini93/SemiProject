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
import dto.Question;
import service.face.MemberService;
import service.impl.MemberServiceImpl;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/member/login [GET] - 요청 완료");

		req.getRequestDispatcher("/WEB-INF/home/loginForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/member/login [POST] - 요청 완료");

		// 세션 객체 얻기
		HttpSession session = req.getSession();
		
		//요청정보로부터 전달파라미터 user_id,user_pw 추출
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		String gender = req.getParameter("user_gender");
//		Date birth = req.getParameter("user_birth");
		String spicy = req.getParameter("spicy_no");
		String amount = req.getParameter("amount_no");
		
		
		Member member = new Member();
		
		member.setUser_id(id);
		member.setUser_pw(pw);
		member.setUser_gender(gender);
//		member.setUser_birth(birth);
		member.setSpicy_no(spicy);
		member.setAmount_no(amount);
		
		int result = memberService.login(member);
		
		if( result > 0 ) { //로그인 성공시
//			session.setAttribute("sessionUserno", user_no);
			//로그인 상태 정보 저장 - Session Scope
			session.setAttribute("login", true); //로그인 상태, login == true
			session.setAttribute("sessionId", id);
			session.setAttribute("user_gender", gender);
//			session.setAttribute("user_birth", birth);
			session.setAttribute("spicy_no", spicy);
			session.setAttribute("amount_no", amount);
			
			member = memberService.detail(member);
			
			System.out.println("member : " +member);
			
			//유저번호로 세션저장
			session.setAttribute("user_no", member.getUser_no());
//			session.setAttribute("user_id", member.getUser_id());
			session.setAttribute("user_gender", member.getUser_gender());
//			session.setAttribute("user_birth", member.getUser_birth);
			session.setAttribute("spicy_no", member.getSpicy_no());
			session.setAttribute("amount_no", member.getAmount_no());
			
			System.out.println("member : " +member);
			
			req.getRequestDispatcher("/WEB-INF/loginSuccess/loginSuccess.jsp")
				.forward(req, resp);
		} else { //로그인 실패시
			req.getRequestDispatcher("/WEB-INF/loginFail/loginFail.jsp")
			.forward(req, resp);
		}
	}
}