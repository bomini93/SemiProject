package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import dto.Question;
import service.face.MemberService;
import service.impl.MemberServiceImpl;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//MemberService 객체 생성
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/member/join [GET] - 요청 완료");
		
		//Question 테이블의 전체 목록을 조회  
		List<Question> qsList = memberService.list();
		
		//조회결과를 View에 전달하기 - MODEL값 전달
		//	JSP에 "list"라는 이름으로 qsList객체를 전달
		req.setAttribute("list", qsList);
		
		//JSP를 View로 지정하고 응답으로 사용
		req.getRequestDispatcher("/WEB-INF/home/joinForm.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/member/join [POST] - 요청 완료");
		
		//1. POST 전달데이터 한글 인코딩 설정 (UTF-8)
		req.setCharacterEncoding("UTF-8");
				
		//2. 전달파라미터를 Member객체에 저장 - MemberService 이용
		Member param = memberService.getParam(req);
		System.out.println("MemberController - " + param);
				
		//3. Member객체를 데이터베이스에 입력
		memberService.join(param);
		
		req.getRequestDispatcher("/WEB-INF/loginSuccess/joinSuccess.jsp")
		.forward(req, resp);
		
//		resp.sendRedirect("/member/login");
	}
}
