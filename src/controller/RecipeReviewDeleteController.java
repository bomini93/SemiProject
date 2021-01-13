package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Recipe_review_table;
//import service.face.RecipeInfoService;
import service.face.RecipeDeleteService;
import service.face.RecipeReviewDeleteService;
//import service.impl.RecipeInfoServiceImpl;
import service.impl.RecipeDeleteServiceImpl;
import service.impl.RecipeReviewDeleteServiceImpl;

/**
 * Servlet implementation class RecipeReviewDeleteController
 */
@WebServlet("/recipe/review/delete")
public class RecipeReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecipeReviewDeleteService recipereviewDeleteService = new RecipeReviewDeleteServiceImpl();

	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			System.out.println("delete GET ");
			
			int recipe_review_no = Integer.parseInt(req.getParameter("recipe_review_no"));
			System.out.println(recipe_review_no);
			
			Recipe_review_table rrt = new Recipe_review_table();
			rrt.setRecipe_review_no(recipe_review_no);
			
			HttpSession session = req.getSession();
			
			String userno = (String)session.getAttribute("sessionNo");
			
			recipereviewDeleteService.deleteReview(userno, rrt);
			//--------------------------------------
			System.out.println(req.getParameter("recipe_no"));
		
			String param = req.getParameter("recipe_no");
			int recipe_no = Integer.parseInt(req.getParameter("recipe_no"));
		
		
			resp.sendRedirect("/recipe/detail?recipe_no="+recipe_no);
		
		
		
		}
	
	
	
	
	
	
}
