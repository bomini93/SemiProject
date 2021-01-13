package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import common.JDBCTemplate;
import dao.face.RecipeWriteDao;
import dao.impl.RecipeWriteDaoImpl;
import dto.Member;
import dto.Recipe_Photo;
import dto.Recipe_Table;
import service.face.MemberService;
import service.face.RecipeWriteService;
import service.impl.MemberServiceImpl;
import service.impl.RecipeWriteServiceImpl;

@WebServlet("/recipe/write")
public class RecipeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//RecipeWriteService 객체 생성
	private RecipeWriteService recipewriteService = new RecipeWriteServiceImpl();
	
	 private RecipeWriteDao recipewriteDao = new RecipeWriteDaoImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			req.getRequestDispatcher("/WEB-INF/recipe/recipewrite.jsp")
				.forward(req,resp);
		}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			// 세션 객체 얻기
			HttpSession session = req.getSession();
			
			//"multipart/form-data" 검증
			if( !ServletFileUpload.isMultipartContent(req)) {
				//파일 업로드 형식의 요청이 아닐 경우 처리
				
				//에러페이지에 전달할 메시지
				req.setAttribute("message", "form의 enctype 속성이 안 맞습니다");
				
//				//에러처리하는 전용 View(JSP)로 응답 - FORAWRD
//				req.getRequestDispatcher("/WEB-INF/views/file/error.jsp")
//					.forward(req, resp);
				
				return; //doPost()메소드를 중단시키기
			}
				
			String saveDirectory = getServletContext().getRealPath("upload");
			
			File folder = new File(saveDirectory);
			
			if(!folder.exists()) {
				try {
					folder.mkdir();
				}
				catch(Exception e) {
					e.getStackTrace();
				}
				
			} else {
				System.out.println("이미 폴더가 생성되어 있습니다");
			}
			
			
			//3. 업로드 제한 크기 
			int maxPostSize = 10 * 1024 * 1024; //10MB
			
			//4. 중복된 파일이름 처리
			String encoding = "UTF-8";
			
			//5. 중복된 파일이름을 처리할 정책
			FileRenamePolicy policy = new DefaultFileRenamePolicy();
			
			// **dEFAULTFILErENAMEpOLICY
			// 이미 업로드된 파일 중에 같은 이름이 있다면
			//	새롭게 업로드된 파일이름에 법ㄴ호를 붙여서 구분한다
			//	-> 자동으로 번호 부여함 (1부터 1씩 증가)
			//--------------------
			
			//---COS 파일 업로드  객체 생성 ---
			try {
				MultipartRequest mul = new MultipartRequest(
						req
						, saveDirectory
						, maxPostSize
						, encoding
						, policy );
				
				String filename = mul.getFilesystemName("mainFile");
				
				//--------------------------------------------------
				
				//원본 파일명
				String origin = mul.getOriginalFileName("mainFile");
				//저장된 파일명
				String stored = mul.getFilesystemName("mainFile");

				//--------------------------------------------------

				//원본 파일명
				String origin1 = mul.getOriginalFileName("imgFile01");
				//저장된 파일명
				String stored1 = mul.getFilesystemName("imgFile01");
				
				//--------------------------------------------------

				
				//원본 파일명
				String origin2 = mul.getOriginalFileName("imgFile02");
				//저장된 파일명
				String stored2 = mul.getFilesystemName("imgFile02");
				
				//--------------------------------------------------

				//원본 파일명
				String origin3 = mul.getOriginalFileName("imgFile03");
				//저장된 파일명
				String stored3 = mul.getFilesystemName("imgFile03");
				
				//--------------------------------------------------

				//원본 파일명
				String origin4 = mul.getOriginalFileName("imgFile04");
				//저장된 파일명
				String stored4 = mul.getFilesystemName("imgFile04");
				
				//--------------------------------------------------

				//원본 파일명
				String origin5 = mul.getOriginalFileName("imgFile05");
				//저장된 파일명
				String stored5 = mul.getFilesystemName("imgFile05");
				
				//--------------------------------------------------

				
				System.out.println( "저장 이름 순서"+ filename +", " + origin + ", "+ stored);
			
				
				if(filename == null) {
					resp.sendRedirect("uploadfail.jsp");
				} else {
					
					
					Recipe_Table recipe_table = new Recipe_Table();
					
					
					recipe_table.setRecipe_ori_name(origin);
					recipe_table.setRecipe_new_name(stored);
					recipe_table.setUser_no((int) session.getAttribute("user_no"));
					recipe_table.setRecipe_name(mul.getParameter("recipe_name"));
					recipe_table.setRecipe_kinds(mul.getParameter("recipe_kinds"));;
					recipe_table.setRecipe_ing(mul.getParameter("recipe_ing"));
					recipe_table.setRecipe_time(mul.getParameter("recipe_time"));
					recipe_table.setRecipe_text01(mul.getParameter("recipe_text01"));
					recipe_table.setRecipe_text02(mul.getParameter("recipe_text02"));
					recipe_table.setRecipe_text03(mul.getParameter("recipe_text03"));
					recipe_table.setRecipe_text04(mul.getParameter("recipe_text04"));
					recipe_table.setRecipe_text05(mul.getParameter("recipe_text05"));
					
					int flags = recipewriteDao.insert(JDBCTemplate.getConnection(), recipe_table);
					
					int res = recipewriteDao.select(JDBCTemplate.getConnection(), recipe_table);
							
					Recipe_Photo recipe_photo = new Recipe_Photo();
					
					
					
					recipe_photo.setRecipe_no(res);
					recipe_photo.setPhoto_before(origin1);
					recipe_photo.setPhoto_after(stored1);
					
					recipewriteDao.insert02(JDBCTemplate.getConnection(), recipe_photo);
					
					recipe_photo.setRecipe_no(res);
					recipe_photo.setPhoto_before(origin2);
					recipe_photo.setPhoto_after(stored2);
					
					recipewriteDao.insert02(JDBCTemplate.getConnection(), recipe_photo);
					
					recipe_photo.setRecipe_no(res);
					recipe_photo.setPhoto_before(origin3);
					recipe_photo.setPhoto_after(stored3);
					
					recipewriteDao.insert02(JDBCTemplate.getConnection(), recipe_photo);
					
					recipe_photo.setRecipe_no(res);
					recipe_photo.setPhoto_before(origin4);
					recipe_photo.setPhoto_after(stored4);
					
					recipewriteDao.insert02(JDBCTemplate.getConnection(), recipe_photo);
					
					recipe_photo.setRecipe_no(res);
					recipe_photo.setPhoto_before(origin5);
					recipe_photo.setPhoto_after(stored5);
					
					int result = recipewriteDao.insert02(JDBCTemplate.getConnection(), recipe_photo);
					
					session.setAttribute("recipeno", recipe_photo.getRecipe_no());
					
					if(flags > 0 && result > 0) {
						
						resp.sendRedirect("/recipe/search");
					} else {
						resp.sendRedirect("/home/home");
					}
				}
	
			} catch( Exception e) {
				e.printStackTrace();
			}
			
			//-----------------------------------------
			
	}
}
