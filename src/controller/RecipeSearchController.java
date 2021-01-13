package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import dto.Recipe_Table;
import service.face.RecipeInfoService;
import service.impl.RecipeInfoServiceImpl;


@WebServlet("/recipe/search")
public class RecipeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//객체 생성
	private RecipeInfoService recipeinfoService = new RecipeInfoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		//VIEW 지정 응답
		req.getRequestDispatcher("/WEB-INF/recipe/recipe.jsp").forward(req, resp);
	}
	
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("POST 성공");
	
			String str = req.getParameter("list");
			System.out.println(req.getParameter(str));
			
			List<Recipe_Table> recipeinfolist = null;
			Paging paging = null;
			
			if("1".equals(str)) {
				paging = recipeinfoService.getPaging1(req);
				
				recipeinfolist = recipeinfoService.recipeinfolist1(paging);
				
			} else if ("2".equals(str)) {
				paging = recipeinfoService.getPaging2(req);
				
				recipeinfolist = recipeinfoService.recipeinfolist2(paging);
				
			} else if ("3".equals(str)) {
				paging = recipeinfoService.getPaging3(req);
				
				recipeinfolist = recipeinfoService.recipeinfolist3(paging);
				
			} else if ("4".equals(str)) {
				paging = recipeinfoService.getPaging4(req);
				
				recipeinfolist = recipeinfoService.recipeinfolist4(paging);
				
			} else if ("5".equals(str)) {
				paging = recipeinfoService.getPaging5(req);
				
				recipeinfolist = recipeinfoService.recipeinfolist5(paging);
				
			} else if ("6".equals(str)) {
				paging = recipeinfoService.getPaging6(req);
				
				recipeinfolist = recipeinfoService.recipeinfolist6(paging);
				
			} else if ("7".equals(str)) {
				paging = recipeinfoService.getPaging7(req);
				
				recipeinfolist = recipeinfoService.recipeinfolist7(paging);
				
			} else if ("8".equals(str)) {
				paging = recipeinfoService.getPaging8(req);
				
				recipeinfolist = recipeinfoService.recipeinfolist8(paging);
			}
			
			req.setAttribute("paging", paging);
			System.out.println("paging : " + paging);
			req.setAttribute("recipeinfolist", recipeinfolist);
			
			req.getRequestDispatcher("/WEB-INF/recipe/recipelist.jsp").forward(req, resp);
			
		}
	
	
	
	
}








