package service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import dao.face.RestReviewChangeDao;
import dao.impl.RestReviewChangeDaoImpl;
import dto.Rest_review_table;
import service.face.RestReviewChangeService;


public class RestReviewChangeServiceImpl implements RestReviewChangeService {

	private RestReviewChangeDao changeDao = new RestReviewChangeDaoImpl();
	
	@Override
	public void update(int review_no, Rest_review_table review_table) {
		Connection conn = JDBCTemplate.getConnection(); // DB연결 객체

		int result = changeDao.update(conn, review_no, review_table);

		if (result > 0) {
			JDBCTemplate.commit(conn); // 커밋
		} else {
			JDBCTemplate.rollback(conn); // 롤백
		}

		
	}

}