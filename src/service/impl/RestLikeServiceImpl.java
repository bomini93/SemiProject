package service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import dao.face.RestLikeDao;
import dao.impl.RestLikeDaoImpl;
import dto.Rest_info;
import service.face.RestLikeService;

public class RestLikeServiceImpl implements RestLikeService {

	private RestLikeDao likeDao = new RestLikeDaoImpl();
	
	@Override
	public void like(String userId, Rest_info rest_info) {
		Connection conn = JDBCTemplate.getConnection(); //DB연결 객체
		
	      int result = likeDao.like(conn, userId, rest_info);
	      
	      if(result > 0) {
	         JDBCTemplate.commit(conn); //커밋
	      } else {
	         JDBCTemplate.rollback(conn); //롤백
	      }
		
	}
	
	@Override
	public void likeCancel(String userId, Rest_info rest_info) {
		Connection conn = JDBCTemplate.getConnection(); //DB연결 객체
		
	      int result = likeDao.likeCancel(conn, userId, rest_info);
	      
	      if(result > 0) {
	         JDBCTemplate.commit(conn); //커밋
	      } else {
	         JDBCTemplate.rollback(conn); //롤백
	      }
		
	}

}
