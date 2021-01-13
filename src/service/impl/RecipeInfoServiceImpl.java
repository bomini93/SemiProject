package service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dao.face.RecipeCntDao;
import dao.face.RecipeInfoDao;
import dao.impl.RecipeCntDaoImpl;
import dao.impl.RecipeInfoDaoImpl;
import dto.Recipe_Table;
import dto.Rest_info;
import service.face.RecipeInfoService;

public class RecipeInfoServiceImpl implements RecipeInfoService {

	//Dao 객체 생성
	private RecipeInfoDao recipeinfodao = new RecipeInfoDaoImpl();
	private RecipeCntDao recipecntdao = new RecipeCntDaoImpl();
	
	
	@Override
	public List<Recipe_Table> getList() {
		return recipeinfodao.selectList( JDBCTemplate.getConnection() );
		
	}
	


	@Override
//	public Paging getPaging(HttpServletRequest req, String[] kinds, String[] ing, String content) {
//	public Paging getPaging(HttpServletRequest req, String content) {
	public Paging getPaging(HttpServletRequest req, String content) {

		
//		System.out.println("getpaging출력");
		
		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//RECIPE 테이블의 레시피명과 CONTENT(검색)일치하는 놈들 조회
		int totalCount = 0;
//		totalCount = searchDao.selectCntAll(JDBCTemplate.getConnection(), kinds, ing, content);
		totalCount = recipeinfodao.selectCntAll(JDBCTemplate.getConnection(), content);

		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage, 3, 4); 
				
		//계산된 Paging 객체 반환
		return paging;
	}
	
	
	
	@Override
//	public List<Recipe> getList(HttpServletRequest req, Paging paging, String[] kinds, String[] ing, String content) {
	public List<Recipe_Table> getList(HttpServletRequest req, Paging paging, String content) {
	
		
//		return searchDao.selectList(JDBCTemplate.getConnection(), paging, kinds, ing, content);
		return recipeinfodao.selectList(JDBCTemplate.getConnection(), paging, content);

	}



	@Override
	public List<Recipe_Table> getList(Paging paging) {
		return recipeinfodao.selectList(JDBCTemplate.getConnection(), paging);
	}
	
	
	
	


//	//메인재료선택 엥커 클릭시 레시피 
//	@Override
//	public List<Recipe> getList(HttpServletRequest req, Paging paging, String[] ing) {
//		
//		//전달파라미터 curPage를 파싱한다
//		String param = req.getParameter("curPage");
//		int curPage = 0;
//		if( param!=null && !"".equals(param) ) {
//			curPage = Integer.parseInt(param);
//		}
//		
//		//RECIPE 테이블의 레시피명과 CONTENT(검색)일치하는 놈들 조회
//		int totalCount = 0;
////		totalCount = searchDao.selectCntAll(JDBCTemplate.getConnection(), kinds, ing, content);
//		totalCount = searchDao.selectCntAll(JDBCTemplate.getConnection(), ing);
//
//		
//		//Paging 객체 생성
//		Paging paging_ing = new Paging(totalCount, curPage, 3, 4); 
//				
//		//계산된 Paging 객체 반환
//		return paging_ing;
//		
//		
//	}



	//-------------------------------------------------페이징처리----------------------------------------------
	
	//전체조회
	@Override
	public Paging getPaging1(HttpServletRequest req) {

		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = recipecntdao.selectCntAll(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
		
	}


	//돼지고기
	@Override
	public Paging getPaging2(HttpServletRequest req) {

		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = recipecntdao.selectCntpork(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
		
	}


	//소고기
	@Override
	public Paging getPaging3(HttpServletRequest req) {
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = recipecntdao.selectCntbeef(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
		
		
	}


	//닭고기
	@Override
	public Paging getPaging4(HttpServletRequest req) {

		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = recipecntdao.selectCntchicken(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
		
	}


	//오리고기
	@Override
	public Paging getPaging5(HttpServletRequest req) {

		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = recipecntdao.selectCntduck(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
		
	}


	//해물류
	@Override
	public Paging getPaging6(HttpServletRequest req) {

		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = recipecntdao.selectCntseafood(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
		
	}


	//채소류
	@Override
	public Paging getPaging7(HttpServletRequest req) {

		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = recipecntdao.selectCntgreen(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
		
	}


	//기타
	@Override
	public Paging getPaging8(HttpServletRequest req) {
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = recipecntdao.selectCntothers(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
		
	}



	//------------------------------------------------조회용----------------------------------------------



	@Override
	public List<Recipe_Table> recipeinfolist1(Paging paging) {

		Connection conn = JDBCTemplate.getConnection();

		List<Recipe_Table> recipeinfolist = recipeinfodao.selectAll(conn, paging);

		return recipeinfolist;
		
	}



	@Override
	public List<Recipe_Table> recipeinfolist2(Paging paging) {

		Connection conn = JDBCTemplate.getConnection();

		List<Recipe_Table> recipeinfolist = recipeinfodao.selectPork(conn, paging);

		return recipeinfolist;
		
	}



	@Override
	public List<Recipe_Table> recipeinfolist3(Paging paging) {

		Connection conn = JDBCTemplate.getConnection();

		List<Recipe_Table> recipeinfolist = recipeinfodao.selectBeef(conn, paging);

		return recipeinfolist;
		
	}



	@Override
	public List<Recipe_Table> recipeinfolist4(Paging paging) {

		Connection conn = JDBCTemplate.getConnection();

		List<Recipe_Table> recipeinfolist = recipeinfodao.selectChicken(conn, paging);

		return recipeinfolist;
		
	}



	@Override
	public List<Recipe_Table> recipeinfolist5(Paging paging) {
		
		Connection conn = JDBCTemplate.getConnection();

		List<Recipe_Table> recipeinfolist = recipeinfodao.selectDuck(conn, paging);

		return recipeinfolist;
		
	}



	@Override
	public List<Recipe_Table> recipeinfolist6(Paging paging) {

		Connection conn = JDBCTemplate.getConnection();

		List<Recipe_Table> recipeinfolist = recipeinfodao.selectSeafood(conn, paging);

		return recipeinfolist;
		
	}



	@Override
	public List<Recipe_Table> recipeinfolist7(Paging paging) {
			
		Connection conn = JDBCTemplate.getConnection();

		List<Recipe_Table> recipeinfolist = recipeinfodao.selectGreen(conn, paging);

		return recipeinfolist;
		
	}



	@Override
	public List<Recipe_Table> recipeinfolist8(Paging paging) {
		
		Connection conn = JDBCTemplate.getConnection();

		List<Recipe_Table> recipeinfolist = recipeinfodao.selectEtc(conn, paging);

		return recipeinfolist;
		
	}



	


	
	
	
}









