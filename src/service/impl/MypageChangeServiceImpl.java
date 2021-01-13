package service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import dao.face.MypageChangeDao;
import dao.impl.MypageChangeDaoImpl;
import dto.Member;
import service.face.MypageChangeService;

public class MypageChangeServiceImpl implements MypageChangeService {

	private MypageChangeDao changeDao = new MypageChangeDaoImpl();
	
	@Override
	public void update(String userId, Member member) {
		
		Connection conn = JDBCTemplate.getConnection(); //DB연결 객체
	      
	      
	      int result = changeDao.update(conn, userId, member);
	      
	      if(result > 0) {
	         JDBCTemplate.commit(conn); //커밋
	      } else {
	         JDBCTemplate.rollback(conn); //롤백
	      }
	      
	   }
		
	}
	
	
