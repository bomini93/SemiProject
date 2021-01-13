package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.Recipe_Table;

public interface RecipeInfoService {
	
	
	/**
	 * 레시피 전체 조회
	 * 
	 * @return
	 */
	public List<Recipe_Table> getList();
	
	
	
	/**
	 * 페이징 리스트 메소드
	 * 
	 * @param req
	 * @param kinds
	 * @param ing
	 * @param content
	 * @return
	 */
//	Paging getPaging(HttpServletRequest req, String[] kinds, String[] ing, String content);
//	Paging getPaging(HttpServletRequest req, String content);
	public Paging getPaging(HttpServletRequest req, String content);
	
	
	/**
	 * 페이징 리스트 메소드
	 * 
	 * @param req
	 * @param paging
	 * @param kinds
	 * @param ing
	 * @param content
	 * @return
	 */
//	List<Recipe> getList(HttpServletRequest req, Paging paging, String[] kinds, String[] ing, String content);
	List<Recipe_Table> getList(HttpServletRequest req, Paging paging, String content);


	/**
	 * 메인 메뉴선택
	 * 
	 * @param paging
	 * @return
	 */
	public List<Recipe_Table> getList(Paging paging);


	/**
	 *  메인재료선택 엥커 클릭시 레시피 
	 * @param req
	 * @param paging
	 * @param ing
	 * @return
	 */
//	public List<Recipe> getList(HttpServletRequest req, Paging paging, String[] ing);




	// 레시피_ing 메소드 
	/**
	 *  전체 조회
	 * @param paging 
	 * @return 조회된 레시피를 list로 반환
	 */
	public List<Recipe_Table> recipeinfolist1(Paging paging);

	/**
	 * 돼지 조회
	 * @return 조회된 레시피를 list로 반환
	 */
	public List<Recipe_Table> recipeinfolist2(Paging paging);
	
	/**
	 * 소 조회
	 * @return 조회된 레시피를 list로 반환
	 */
	public List<Recipe_Table> recipeinfolist3(Paging paging);

	/**
	 * 닭 조회
	 * @return 조회된 레시피를 list로 반환
	 */
	public List<Recipe_Table> recipeinfolist4(Paging paging);

	/**
	 * 오리 조회
	 * @return 조회된 레시피를 list로 반환
	 */
	public List<Recipe_Table> recipeinfolist5(Paging paging);

	/**
	 * 해물 조회
	 * @return 조회된 레시피를 list로 반환
	 */
	public List<Recipe_Table> recipeinfolist6(Paging paging);

	/**
	 * 채소 조회
	 * @return 조회된 레시피를 list로 반환
	 */
	public List<Recipe_Table> recipeinfolist7(Paging paging);
		
	/**
	 * 기타 조회
	 * @return 조회된 레시피를 list로 반환
	 */
	public List<Recipe_Table> recipeinfolist8(Paging paging);


	
	
	
	public Paging getPaging1(HttpServletRequest req);

	public Paging getPaging2(HttpServletRequest req);

	public Paging getPaging3(HttpServletRequest req);

	public Paging getPaging4(HttpServletRequest req);

	public Paging getPaging5(HttpServletRequest req);

	public Paging getPaging6(HttpServletRequest req);

	public Paging getPaging7(HttpServletRequest req);

	public Paging getPaging8(HttpServletRequest req);




}









