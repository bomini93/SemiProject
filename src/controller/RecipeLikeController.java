package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Recipe_Table;
import service.face.RecipeLikeService;
import service.impl.RecipeLikeServiceImpl;

/**
 * Servlet implementation class RecipeLikeController
 */
@WebServlet("/recipe/like")
public class RecipeLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecipeLikeService likeService = new RecipeLikeServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("like doget");
		//Parameter는 스트링 타입으로 밖에 못받아옴
		String recipeno = req.getParameter("recipe_no");
		
		System.out.println("recipeno : " + recipeno);
		
		int recipe_no = 0;
		if(recipeno != null && !"".equals(recipeno)) { //recipeno가 null값이 아니고 
			recipe_no = Integer.parseInt(recipeno);
		}
		
		
		Recipe_Table recipe_table= new Recipe_Table();
		recipe_table.setRecipe_no(recipe_no);
		
		
		
//		System.out.println(rest_no);
//		req.setAttribute("rest_no", rest_no);
		
		// ------------------------------------
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("sessionId");
		
		
//		likeService.like(userId, rest_info);
		likeService.like(userId, recipe_table);
		
		
		req.getRequestDispatcher("/WEB-INF/recipe/recipeLike.jsp")
		.forward(req, resp);
	}
	


}
