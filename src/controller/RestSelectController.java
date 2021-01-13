package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import dto.Rest_info;
import service.face.RestSelectService;
import service.impl.RestSelectServiceImpl;

@WebServlet("/rest/search")
public class RestSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RestSelectService restSelectService = new RestSelectServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("RestSelect DOGET");
		
		List<Rest_info> list = null;
		Paging paging = null;
		
		paging = restSelectService.getPagingSelect(req);
		list = restSelectService.restSelect(paging);
		
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/rest/RestSelect.jsp").forward(req, resp);
	}

}
