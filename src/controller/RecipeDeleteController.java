package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Recipe_Table;
import service.face.RecipeDeleteService;
import service.impl.RecipeDeleteServiceImpl;

@WebServlet("/recipe/delete")
public class RecipeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RecipeDeleteService recipedeleteService = new RecipeDeleteServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget");
		
		int recipeno = Integer.parseInt(req.getParameter("recipe_no"));
		
		Recipe_Table rt = new Recipe_Table();
		rt.setRecipe_no(recipeno);
			
		recipedeleteService.deleteRecipe(rt);
		
//		String param = req.getParameter("rest_no");
//		int rest_no = Integer.parseInt(req.getParameter("rest_no"));
//				
//		resp.sendRedirect("/rest/detail?rest_no="+rest_no);
		
		resp.sendRedirect("/recipe/search");
	}
	
	
}
