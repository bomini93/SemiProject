package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Recipe_Photo;
import dto.Recipe_Table;
import dto.Report_Recipe_Table;
import service.face.RecipeDetailService;
import service.face.RecipeReportService;
import service.impl.RecipeDetailServiceImpl;
import service.impl.RecipeReportServiceImpl;


@WebServlet("/recipe/detail")
public class RecipeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RecipeDetailService recipedetailService = new RecipeDetailServiceImpl();
	
	private RecipeReportService recipereportService = new RecipeReportServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String param = req.getParameter("recipe_no");
		System.out.println("Restno : " + param);
		int recipeno = 0;
		if( param != null && !"".equals(param)) {
			recipeno = Integer.parseInt(param); //String->int형 반환
		}
		
		req.setAttribute("user_id",(session.getAttribute("sessionId")));
		
		
		Recipe_Table recipe_table = new Recipe_Table();
		recipe_table.setRecipe_no(recipeno);
	
		
		Recipe_Table res = recipedetailService.detail(recipe_table);
		
		Recipe_Photo recipe_photo = new Recipe_Photo();
		
		recipe_photo.setRecipe_no(recipeno);
		
		List<Recipe_Photo> pres = recipedetailService.detailp(recipe_photo);
		ArrayList text = new ArrayList();
		
		text.add(res.getRecipe_text01());
		text.add(res.getRecipe_text02());
		text.add(res.getRecipe_text03());
		text.add(res.getRecipe_text04());
		text.add(res.getRecipe_text05());
		
		List<Map> reviewlist = recipedetailService.reviewlist(recipeno);
		
		req.setAttribute("result", res);
		req.setAttribute("result2", pres);
		req.setAttribute("text", text);
		req.setAttribute("reviewlist", reviewlist);
		req.getRequestDispatcher("/WEB-INF/recipe/recipedetail.jsp")
			.forward(req, resp);
		

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		
		String param = req.getParameter("recipe_no");
		int recipeno = 0;
		if( param != null && !"".equals(param)) {
			recipeno = Integer.parseInt(param); //String->int형 반환
		}
		
		Report_Recipe_Table report_recipe_table = new Report_Recipe_Table();
		report_recipe_table.setRecipe_no(recipeno);
		report_recipe_table.setUser_no((int) session.getAttribute("user_no"));
		
		recipereportService.join(report_recipe_table);
		
		resp.sendRedirect("/recipe/search");
		
		//------------------------------------------
		
		
	}

}
