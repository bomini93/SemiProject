package service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dao.face.AdminMemberDao;
import dao.impl.AdminMemberDaoImpl;
import dto.Member;
import service.face.AdminMemberService;

public class AdminMemberServiceImpl implements AdminMemberService{

private AdminMemberDao adminMemberDao = new AdminMemberDaoImpl();
	
	
	@Override
	public List<Member> getList() {
		return adminMemberDao.selectList( JDBCTemplate.getConnection() );
	}
	

	@Override
	public Paging getPaging(HttpServletRequest req) {

		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Board 테이블의 총 게시글 수를 조회한다
		int totalCount = adminMemberDao.selectCntAll(JDBCTemplate.getConnection());
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage); 
		
		//계산된 Paging 객체 반환
		return paging;
		
		
	}
	
	
	@Override
	public List<Member> getList(Paging paging) {
		return adminMemberDao.selectList(JDBCTemplate.getConnection(), paging);
	}


	@Override
	public int withdrawal(Member member) {
		
		//Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		int res = adminMemberDao.memberWithdrawal(conn, member);
		
		if(res > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return res;
	}
	
	
	
}
