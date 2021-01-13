package service.impl;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import dao.face.MypageDao;
import dao.impl.MypageDaoImpl;
import dto.Member;
import dto.Recipe_Table;
import dto.Rest_info;
import service.face.MypageService;

public class MypageServiceImpl implements MypageService {

	private MypageDao mypageDao = new MypageDaoImpl();
	
	@Override
	public List<Member> list(String userId) {
		
		//Connection 객체 생성
	      Connection conn = JDBCTemplate.getConnection();
	      
	      //Member테이블 전체 조회 - MypageDao 객체 이용
	      List<Member> memberList= mypageDao.selectAll(conn, userId);
	      
	      //조회된 결과 반환
	      return memberList;
		
	}
	
	@Override
	public List<Rest_info> restlike(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<Rest_info> list = mypageDao.restlike(conn, userId);
		return list;
	}

	@Override
	public List<Recipe_Table> recipelike(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<Recipe_Table> rlist = mypageDao.recipelike(conn, userId); 
		return rlist;
		
	}
}
