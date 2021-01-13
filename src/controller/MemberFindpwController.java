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

@WebServlet("/member/findpw")
public class MemberFindpwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//MemberService 객체 생성
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Question 테이블의 전체 목록을 조회  
		List<Question> qsList = memberService.list();
				
		//조회결과를 View에 전달하기 - MODEL값 전달
		//	JSP에 "list"라는 이름으로 qsList객체를 전달
		req.setAttribute("list", qsList);
				
		//JSP를 View로 지정하고 응답으로 사용
		req.getRequestDispatcher("/WEB-INF/loginFail/findpw.jsp")
			.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		//요청 정보로부터 전달파라미터 user_id, pw_questionno, pw_answer 추출
		String id = req.getParameter("user_id");
		String question = req.getParameter("pw_questionno");
		String answer = req.getParameter("pw_answer");
		
		Member member = new Member();
		
		member.setUser_id(id);
		member.setPw_questionno(question);
		member.setPw_answer(answer);

		Member res = memberService.findPw(member);
		
			req.setAttribute("result", res);
		
			if( res != null) {
				req.getRequestDispatcher("/WEB-INF/loginFail/findpwSuccess.jsp")
				.forward(req, resp);
			} else {
				req.getRequestDispatcher("/WEB-INF/loginFail/findpwFail.jsp")
				.forward(req, resp);
			}
			
		
	}
}










