package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import dto.Member;
import service.face.AdminMemberService;
import service.impl.AdminMemberServiceImpl;

@WebServlet("/admin/member")
public class AdminMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminMemberService adminMemberService = new AdminMemberServiceImpl();

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			//페이징 정보 생성하기
			Paging paging = adminMemberService.getPaging(req);
			
			//Paging처리 결과 MODEL값 전달
			req.setAttribute("paging", paging);
			
			
			//게시글 전체 조회
//			List<Board> list = boardService.getList();
			List<Member> list = adminMemberService.getList(paging);
//			System.out.println(list);
			
			//조회결과 MODEL값으로 전달
			req.setAttribute("list", list);
			
			
			
			
			req.getRequestDispatcher("/WEB-INF/admin/adminmemberlist.jsp").forward(req, resp);
		
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("/admin/member");
	}
}
