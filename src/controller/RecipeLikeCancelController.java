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


@WebServlet("/recipe/likeCancel")
public class RecipeLikeCancelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private RecipeLikeService likeService = new RecipeLikeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("like doget");
		
		String recipeno = req.getParameter("rest_no");
		
		System.out.println(recipeno);
		
		int recipe_no = 0;
		
		if(recipeno != null && !"".equals(recipeno)) {
			recipe_no = Integer.parseInt(recipeno);
		}
		
		Recipe_Table recipe_table = new Recipe_Table();
		recipe_table.setRecipe_no(recipe_no);
		
		
		
//		System.out.println(rest_no);
//		req.setAttribute("rest_no", rest_no);
		
		// ------------------------------------
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("sessionId");
		
		
//		likeService.like(userId, rest_info);
		likeService.likeCancel(userId, recipe_table);
		
		
		req.getRequestDispatcher("/WEB-INF/recipe/recipeLikeCancel.jsp")
		.forward(req, resp);
	}

}
