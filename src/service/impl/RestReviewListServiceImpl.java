package service.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dao.face.RestReviewListDao;
import dao.impl.RestReviewListDaoImpl;
import dto.Rest_info;
import dto.Rest_review_table;
import service.face.RestReviewListService;

public class RestReviewListServiceImpl implements RestReviewListService {

	private RestReviewListDao restReviewDao = new RestReviewListDaoImpl();

//	@Override
//	public List<Rest_review_table> list(Rest_info rest_info) {
//
//		// Connection 객체 생성
//		Connection conn = JDBCTemplate.getConnection();
//
//		// 테이블 전테 조회
//		List<Rest_review_table> rest_review_list = restReviewDao.selectAll(conn , rest_info);
//
//		//조회 결과 반환
//		return rest_review_list;
//	}

	 @Override
	public Paging getPaging(HttpServletRequest req,  Rest_info rest_info) {
		//전달파라미터 curPage를 파싱한다
			String param = req.getParameter("curPage");
			int curPage = 0;
			if( param!=null && !"".equals(param) ) {
				curPage = Integer.parseInt(param);
			}
			
			// Rest_Review테이블의 총 게시글 수를 조회한다
			int totalCount = restReviewDao.selectCntAll(JDBCTemplate.getConnection(), rest_info );
			
			//Paging 객체 생성
			Paging paging = new Paging(totalCount, curPage, 5, 5); 
			
			//계산된 Paging 객체 반환
			return paging;
	}

	 @Override
	public List<Map> list(Paging paging, Rest_info rest_info) {
		return restReviewDao.selectList(JDBCTemplate.getConnection(), paging, rest_info);
	}
	



	@Override
	public List<Map> myreview(int user_no, Rest_info rest_info) {
		return 	restReviewDao.selectMyReview(JDBCTemplate.getConnection(), user_no, rest_info);
	}

	@Override
	public void deleteReview(String userno, Rest_review_table rrt) {

		Connection conn = JDBCTemplate.getConnection(); //DB연결 객체
	      
	      
	      int result = restReviewDao.deleteMyReview(conn, userno, rrt);
	      
	      if(result > 0) {
	         JDBCTemplate.commit(conn); //커밋
	      } else {
	         JDBCTemplate.rollback(conn); //롤백
	      }
	      
	   }
	
	@Override
	public void update(String userid, Rest_review_table rrt) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = restReviewDao.update(conn, userid, rrt);
		
		if(result>0) {
	         JDBCTemplate.commit(conn); //커밋
	      } else {
	         JDBCTemplate.rollback(conn); //롤백
	      }
	      
	}
	

	
//	@Override
//	public List<Rest_review_table> rUList(String userid) {
//
//		return restReviewDao.reviewUList(JDBCTemplate.getConnection(), userid);
//	}
}
	

