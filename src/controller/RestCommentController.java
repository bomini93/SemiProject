	package controller;
	
	import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dto.Member;
import dto.Rest_photo_table;
import dto.Rest_review_table;
import service.face.MemberService;
import service.face.RestCommentService;
import service.impl.MemberServiceImpl;
import service.impl.RestCommentServiceImpl;
	
	@WebServlet("/comment")
	public class RestCommentController extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		private RestCommentService commentService = new RestCommentServiceImpl();
		private Rest_review_table rest_review = new Rest_review_table();
		private MemberService memberService = new MemberServiceImpl();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String param = req.getParameter("rest_no");
			System.out.println(param);
			req.setAttribute("rest_no", param);
			
			req.getRequestDispatcher("/WEB-INF/rest/restComment.jsp")
				.forward(req, resp);
	
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("commnet dopost");
			// userid 로 userno 찾기

			HttpSession session = req.getSession();
			int result = (Integer)session.getAttribute("user_no");
			
			System.out.println("user_no " + result);
			//리뷰 저장
			
			//리뷰 파라미터값 객체에 저장
			
			// ------ 파일 업로드
			// "multipart/form-data" 검증
		      if( !ServletFileUpload.isMultipartContent(req) ) {
		         //파일 업로드 형식의 요청이 아닐 경우 처리
		         
		         //에러페이지에 전달할 메시지
		         req.setAttribute("message", "form의 enctype 속성이 안 맞습니다");
		         
		         //에러처리하는 전용 View(JSP)로 응답 - forward
		         req.getRequestDispatcher("/WEB-INF/views/file/error.jsp")
		            .forward(req, resp);
		         
		         return; //doPost() 메소드를 중단시키기
		               
		      }
		      
		      System.out.println("multipart/form-data 방식으로 요청한 경우 처리");
		      
		      //----- 매개변수 준비 -----
		      //1. 요청 객체
		      	//   ->
		      
		      //2. 파일 저장 위치
		      String saveDirectory = getServletContext().getRealPath("upload");
		      
		      //3. 업로드 제한 크기
		      int maxPostSize = 10 * 1024 * 1024; //10MB
		      
		      //4. 한글 인코딩
		      String encoding = "UTF-8";
		      
		      //5. 중복된 파일 이름을 처리할 정책
		      FileRenamePolicy policy = new DefaultFileRenamePolicy();
		      
		      // ** DefautfileRenamePolicy
		      //   이미 업로드된 파일 중에서 같은 이름이 있다면
		      //   새롭게 업로드된 파일 이름에 번호를 붙여서 구분한다
		      //   -> 자동으로 번호 부여함 (1부터 1씩 증가)
		      //------------------------
		      
		      //----- COS 파일 업로드 객체 생성 -----
		      MultipartRequest mul = new MultipartRequest(
		            req
		            , saveDirectory
		            , maxPostSize
		            , encoding
		            , policy );
		      
		      //MultipartRequest 객체가 생성되면서 파일 업로드를 수행한다
		      //--------------------------------------
		      
		      //원본 파일명
		      String origin = mul.getOriginalFileName("upfile");
		      
		      //저장된 파일명
		      String stored = mul.getFilesystemName("upfile");
		      
		      System.out.println("CosFileUploadController origin - " + origin);
		      System.out.println("CosFileUploadController stored - " + stored);
		      
//		      mul.getParameter(arg0)
		      
		      Rest_review_table params = commentService.getParam(mul); 
		      params.setUser_no(result);
		      
		      commentService.insertreview(params);
		      
		      System.out.println("파라미터 테스트");
		      System.out.println(params);
		      
		      Rest_photo_table up = new Rest_photo_table();
		      up.setRest_review_no(commentService.searchreviewno(params));
		      up.setPhoto_ori_name(origin);
		      up.setPhoto_chan_name(stored);
		      
		      System.out.println(up);
		      
//		      int rest_no = Integer.parseInt(req.getParameter("rest_no"));
//		      System.out.println(rest_no);
		      
		      commentService.insertFile(up);
		      String rest_no=mul.getParameter("rest_no");
		      resp.sendRedirect("/rest/detail?rest_no="+rest_no);
		}
	}
