package service.impl;

import java.sql.Connection;

import com.oreilly.servlet.MultipartRequest;

import common.JDBCTemplate;
import dao.face.RestCommentDao;
import dao.impl.RestCommentDaoImpl;
import dto.Rest_photo_table;
import dto.Rest_review_table;
import service.face.RestCommentService;

public class RestCommentServiceImpl implements RestCommentService {	
	
	private RestCommentDao commentDao = new RestCommentDaoImpl();

	@Override
	public void insertFile(Rest_photo_table up) {
		//DAO를 통해 INSERT수행
		   int result = commentDao.insertFile(JDBCTemplate.getConnection(), up);
			
		   if(result >0) {
			   JDBCTemplate.commit(JDBCTemplate.getConnection());
		   }else {
			   JDBCTemplate.rollback(JDBCTemplate.getConnection());;
			   
		   }
	}

	@Override
	public Rest_review_table getParam(MultipartRequest mul) {
		Rest_review_table param = new Rest_review_table();
		
		param.setRest_no(Integer.parseInt(mul.getParameter("rest_no")));
		param.setRest_review_text(mul.getParameter("rest_review_text"));
		param.setRest_rating(Integer.parseInt(mul.getParameter("rest_rating")));
		
		return param;
	}
	
	@Override
	public void insertreview(Rest_review_table params) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = commentDao.insertreview(conn, params);
		
		if(result > 0) {
			JDBCTemplate.commit(conn); //커밋
		} else {
			JDBCTemplate.rollback(conn); //롤백
		}

	}
	
	@Override
	public int searchreviewno(Rest_review_table params) {
		Connection conn = JDBCTemplate.getConnection();
		
		return commentDao.searchreviewno(conn, params);
		
	}
	
}
