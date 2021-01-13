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

@WebServlet("/RestEct")
public class RestEtcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RestSelectService restSelectService = new RestSelectServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("RestEct DOGET");

		List<Rest_info> list = null;
		Paging paging = null;

		paging = restSelectService.getPagingEtc(req);
		list = restSelectService.restEtc(paging);

		req.setAttribute("paging", paging);
		req.setAttribute("list", list);

		req.getRequestDispatcher("/WEB-INF/views/rest/RestEtc.jsp").forward(req, resp);
	}
}
