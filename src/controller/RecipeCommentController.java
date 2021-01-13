package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Recipe_review_table;
import service.face.RecipeCommentService;
import service.impl.RecipeCommentServiceImpl;

@WebServlet("/recipe/comment")
public class RecipeCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RecipeCommentService recipeCommentService = new RecipeCommentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("recipe/comment get");

		String str = req.getParameter("recipe");
//		req.getDispatcherType)

		req.setAttribute("recipe_no", str);

		req.getRequestDispatcher("/WEB-INF/recipe/recipecomment.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("recipe/comment post");
		req.setCharacterEncoding("UTF-8");
	
		
		//리뷰를 저장할 객체 생성
//		객체에 저장 = recipeCommentService.getparam();
//		System.out.println(req.getParameter("recipe_rating"));
		HttpSession session = req.getSession();
		String user_id = (String) (session.getAttribute("sessionId"));

		int res = (Integer)session.getAttribute("user_no");

		System.out.println("user id"+user_id);
		

		System.out.println("user_no(res)"+res);
		
		int user_no = recipeCommentService.selectuserno(user_id);
		
		
		
		
		Recipe_review_table params = recipeCommentService.getParam(req,user_no);
		

//		params.setUser_no(res);
		
		recipeCommentService.insertreview(params);
		
//		req.getRequestDispatcher("/WEB-INF/views/recipe/deatail?recipe_no.jsp").forward(req, resp);
		// --------------------------
		resp.sendRedirect("/recipe/detail?recipe_no="+req.getParameter("recipe_no"));
		
		
		
		//insert 서비스 메소드 실행 (매소드 객체)
		
		//서비스--------------------
		//getConnection = conn
		//insert dao 메소드 실행 ( conn, 객체)
		//리턴값 int
		// if retrun > 0 commit
		// else { rollback
		
		//DAO
		//insert구문
		//? ? ?
		//받아온 객체에서 레시피 넘버 별점 텍스트 대입
		// int result = 결과값
		//return result;
		
		
		
		
	}

}
