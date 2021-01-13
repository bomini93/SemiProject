package dao.face;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import common.Paging;
import dto.Rest_info;
import dto.Rest_review_table;

public interface RestReviewListDao {

	/**
	 * 전체 조회
	 * @param conn DB연결 객체
	 * @return 조회된 전체 목록을 반환
	 */
//	public List<Rest_review_table> selectAll(Connection conn ,Rest_info rest_info);

	/**
	 * 총 게시글 수 조회
	 * @param connection
	 * @return 전체 게시글 수
	 */
	public int selectCntAll(Connection connection,  Rest_info rest_info);

	/**
	 * 
	 * @param connection
	 * @param paging 페이징 정보 객체
	 * @return 조회된 게시글 목록
	 */
	public List<Map> selectList(Connection connection, Paging paging, Rest_info rest_info);

	/**
	 * 
	 * @param connection
	 * @param user_no
	 * @return
	 */
	public List<Map> selectMyReview(Connection connection, int user_no, Rest_info rest_info);

	public int deleteMyReview(Connection connection, String userno, Rest_review_table rrt);

	public int update(Connection conn, String userid, Rest_review_table rrt);

//	public List<Rest_review_table> reviewUList(Connection connection, String userid);


	

}
