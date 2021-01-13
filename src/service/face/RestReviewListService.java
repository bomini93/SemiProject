package service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;

import dto.Rest_info;
import dto.Rest_review_table;

public interface RestReviewListService {

	/**
	 * 게시글 전체 조회
	 * @return 조회된 게시글 목록
	 */
//	public List<Rest_review_table> list(Rest_info rest_info);

	/**
	 * 페이징 객체 생성
	 * @param req - 요청 정보 객체
	 * @return 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req,  Rest_info rest_info);

	/**
	 * 페이징 처리하여 보여질 게시글 목록만 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return 페이징 게시글 조회 결과 리스트
	 */
	public List<Map> list(Paging paging, Rest_info rest_info);

	

	/**
	 * 로그인사용자 리뷰 조회
	 * @param user_no - 로그인사용자 userno
	 * @return 사용자 리뷰
	 */
	public List<Map> myreview(int user_no,  Rest_info rest_info);

	public void deleteReview(String userno, Rest_review_table rrt);

	public void update(String userid, Rest_review_table rrt);

//	public List<Rest_review_table> rUList(String userid);


 
}
