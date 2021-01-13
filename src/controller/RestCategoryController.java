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

@WebServlet("/restcategory")
public class RestCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RestSelectService restSelectService = new RestSelectServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("RestCategory DOGET");

		String condition = req.getParameter("category");
		System.out.println(req.getParameter("category"));

		List<Rest_info> list = null;
		Paging paging = null;

		if ("전체".equals(condition)) {

		} else if ("기타".equals(condition)) {

			paging = restSelectService.getPagingEtc(req);
			list = restSelectService.restEtc(paging);
			
		} else {

			paging = restSelectService.getPagingCategory(req, condition);
			list = restSelectService.restCategory(paging, condition);
			
		}

		req.setAttribute("paging", paging);
		req.setAttribute("list", list);

		req.getRequestDispatcher("/WEB-INF/rest/RestCategory.jsp").forward(req, resp);
	}

}
