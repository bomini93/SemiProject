package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Paging;
import dto.Member;
import dto.Rest_info;
import dto.Rest_review_table;
import service.face.RestInfoService;
import service.face.RestReviewListService;
import service.impl.RestInfoServiceImpl;
import service.impl.RestReviewListServiceImpl;

@WebServlet("/rest/detail")
public class RestInfoDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private RestInfoService restInfoService = new RestInfoServiceImpl();
	private RestReviewListService restReviewService = new RestReviewListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("detail doGet");
		
		String param = req.getParameter("rest_no");
		int rest_no = 0;
		
		
		if(param != null && !"".equals(param)) {
			rest_no = Integer.parseInt(param);
		}
		
		System.out.println("DetailController - rest_no : " +rest_no);
		
		Rest_info rest_info = new Rest_info();
		rest_info.setRest_no(rest_no);
		
		System.out.println("DetailController - rest_info : " +rest_info);
		
		Rest_info res = restInfoService.detail(rest_info);
		
		req.setAttribute("result", res);
		
		System.out.println("res test :" + res);
				
		System.out.println("ReviewListController [GET] - 요청완");
		
		//-----------페이징 ------------------------------------------------
		//페이징 정보 생성하기
		Paging paging = restReviewService.getPaging(req, rest_info);
		
		//페이징 처리 결과 모델값 전달
		req.setAttribute("paging", paging);
		
		System.out.println("paging test" + paging);
		
		//---------------세션 정보 ---------------------------------------------
		HttpSession session = req.getSession();
		
		int user_no = (int)session.getAttribute("user_no");
		
		System.out.println(user_no);
		
		//리스트 전체 조회
		List<Map> my_review = restReviewService.myreview(user_no, rest_info);
		List<Map> rest_review_list = restReviewService.list(paging, rest_info);
		
		
//		for (int j = 0; j < rest_review_list.size(); j++) {
//			Member member = (Member) rest_review_list.get(j).get("mem");
//			
//			System.out.println("객체 테스트");
//			System.out.println(member.getUser_id());
//			System.out.println(member.getUser_no());
//		}
		
		//조회 결과 모델값으로 전달
		//JSP에  "review_list"라는 이름으로 review_list객체를 전달한다.
		req.setAttribute("my_review", my_review);
		req.setAttribute("review_list", rest_review_list);
	
		// view 지정 응답
		
		req.getRequestDispatcher("/WEB-INF/rest/restDetail.jsp")
			.forward(req, resp);
	}

}
