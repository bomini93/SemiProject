package service.impl;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.MemberDao;
import dao.impl.MemberDaoImpl;
import dto.Member;
import dto.Question;
import service.face.MemberService;

public class MemberServiceImpl implements MemberService{

	//Dao 객체 생성
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public List<Question> list() {
		
		//Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		//Question테이블 전체 조회 - MemberDao 객체 이용
		List<Question> qsList = memberDao.selectAll(conn);
		
		//조회된 결과 반환
		return qsList;
	}

	@Override
	public Member getParam(HttpServletRequest req) {
		
		Member param = new Member();
		param.setUser_id(req.getParameter("user_id"));
		param.setUser_pw(req.getParameter("user_pw"));
		param.setUser_gender( req.getParameter("user_gender"));
		
		String p = req.getParameter("user_birth");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d = null;
		try {
			d = sdf.parse(p);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		param.setUser_birth(d);
		param.setPw_questionno(req.getParameter("pw_questionno"));
		param.setPw_answer(req.getParameter("pw_answer"));
		param.setSpicy_no(req.getParameter("spicy_no"));
		param.setAmount_no(req.getParameter("amount_no"));
		
		return param;
		
	}

	@Override
	public void join(Member param) {
		
		Connection conn = JDBCTemplate.getConnection(); //DB연결 객체
		
		
		int result = memberDao.insert(conn, param);
		
		if(result > 0) {
			JDBCTemplate.commit(conn); //커밋
		} else {
			JDBCTemplate.rollback(conn); //롤백
		}
		
	}


	@Override
	public Member detail(Member member) {

		//Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		//DB조회 결과 얻어오기 - Dao 이용
		Member res = memberDao.selectByIdPw(conn, member);
		
		return res;
	}

	@Override
	public int login(Member member) {
		
		//Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		int result = memberDao.loginCheck(conn, member);
		 
		
		return result;
	}

	@Override
	public Member findPw(Member member) {
		
		//Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		//DB조회 결과 얻어오기 - Dao 이용
		Member res = memberDao.checkPw(conn, member);
		
		return res;
	}

	@Override
	public int idCheck(Member member) {
		
		//Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		int res = memberDao.checkId(conn, member);
		
		return res;
	}








}
