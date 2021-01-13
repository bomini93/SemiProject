package dao.face;

import java.sql.Connection;
import java.util.List;

import common.Paging;
import dto.Recipe_Table;


public interface RecipeInfoDao {
	
//	/**
//	 *  레시피 내용 조회
//	 * 
//	 * @param <Recipe> - db 연결
//	 * @param conn - 조회된 레시피 내용
//	 * @return 
//	 */
//	public List<Recipe> selectList(Connection conn);
	
	
//	/**
//	 * 총 게시글 수 조회
//	 * 
//	 * @return 전체 게시글 수
//	 */
//	public int selectCntAll(Connection connection);
	
	
//	/**
//	 * 페이징 대상 게시글 목록 조회
//	 * 
//	 * @param paging - 페이징 정보 객체
//	 * @return 조회된 게시글 목록
//	 */
//	public List<Recipe> selectList(Connection connection, Paging paging);


//	public int selectCntAll(Connection connection, String[] kinds, String[] ing);
//
//
//	public int selectCntAll(Connection connection, String keyword);


//	public List<Recipe> selectList(Connection connection, Paging paging, String[] kinds, String[] ing);
//
//
//	public List<Recipe> selectList(Connection connection, Paging paging, String keyword);

	public List<Recipe_Table> selectList(Connection connection);
	
	

//	public int selectCntAll(Connection connection, String[] kinds, String[] ing, String content);
	public int selectCntAll(Connection connection, String content);

	

//	public List<Recipe> selectList
//	(Connection connection, Paging paging, String[] kinds, String[] ing, String content);
	public List<Recipe_Table> selectList
	(Connection connection, Paging paging, String content);


	/**
	 *  메인재료 선택시 해당 레시피 조회
	 * @param connection
	 * @param paging
	 * @return
	 */
	public List<Recipe_Table> selectList(Connection connection, Paging paging);

	
	
	
	
	
	// 메인재료선택 라디오 레시피 
	/**
	 * 전체 작성 순 조회
	 * @param conn - DB 연결 객체
	 * @return 조회된 전체 리스트를 반환
	 */
	public List<Recipe_Table> selectAll(Connection conn,Paging paging);
	
	/**
	 * 돼지 작성 순조회
	 * @param conn
	 * @return 조회된 한식 리스트를 반환
	 */
	public List<Recipe_Table> selectPork(Connection conn,Paging paging);

	/**
	 * 소고기 작성 순 조회
	 * @param conn
	 * @return 조회된 양식 리스트를 반환
	 */
	public List<Recipe_Table> selectBeef(Connection conn,Paging paging);
	
	/**
	 * 닭고기 작성 순 조회
	 * @param conn
	 * @return 조회된 중식 리스트를 반환
	 */
	public List<Recipe_Table> selectChicken(Connection conn,Paging paging);
	
	/**
	 * 오리 작성 순 조회 
	 * @param conn
	 * @return 조회된 일식 리스트를 반환
	 */
	public List<Recipe_Table> selectDuck(Connection conn,Paging paging);
	
	/**
	 * 해물 작성 순 조회
	 * @param conn
	 * @return 조회된 분식 리스트를 반환
	 */
	public List<Recipe_Table> selectSeafood(Connection conn,Paging paging);

	/**
	 * 채소류 작성 순 조회
	 * @param conn
	 * @return 조회된 기타 리스트를 반환
	 */
	public List<Recipe_Table> selectGreen(Connection conn,Paging paging);

	/**
	 * 기타 작성 순 조회
	 * @param conn
	 * @return 조회된 기타 리스트를 반환
	 */
	public List<Recipe_Table> selectEtc(Connection conn,Paging paging);





	


	
	
}
