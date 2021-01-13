package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Recipe_review_table;
import service.face.RecipeReviewChangeService;
import service.impl.RecipeReviewChangeServiceImpl;

/**
 * Servlet implementation class RecipeReviewChangeController
 */
@WebServlet("/recipe/review/change")
public class RecipeReviewChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecipeReviewChangeService changeService = new RecipeReviewChangeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setAttribute("review_no", req.getParameter("review_no"));
		
		req.getRequestDispatcher("/WEB-INF/recipe/recipeReviewChange.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("change dopost");
		req.setCharacterEncoding("UTF-8");
		
		int review_no = Integer.parseInt(req.getParameter("review_no"));
		int rating = Integer.parseInt(req.getParameter("recipe_rating"));
		String text = req.getParameter("recipe_review_text");
		
		Recipe_review_table review_table = new Recipe_review_table();
		
		review_table.setRecipe_review_no(review_no);
		review_table.setRecipe_rating(rating);
		review_table.setRecipe_review_text(text);
		
		HttpSession session = req.getSession();	
		
		String userId = (String)session.getAttribute("sessionId");
		
		System.out.println("session ID");
		System.out.println(userId);
		
		changeService.update(userId, review_table);
		
		resp.sendRedirect("/recipe/search");
		
		
		
	}
}
