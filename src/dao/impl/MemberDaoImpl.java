package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.MemberDao;
import dto.Member;
import dto.Question;

public class MemberDaoImpl implements MemberDao{

	PreparedStatement ps = null; //SQL 수행 객체
	ResultSet rs = null; //조회결과 객체
	
	@Override
	public List<Question> selectAll(Connection conn) {
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM Question";
		
		
		//조회결과를 저장할 리스트 객체
		List<Question> qsList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);//SQL수행 객체 생성
			rs = ps.executeQuery(); //SQL 수행 및 결과 반환
			
			while(rs.next()) {
				//새로운 비어있는 Question 객체 생성
				Question question = new Question();
				
				question.setPw_question(rs.getString("pw_question"));
				
				//조회 결과를 담고있는 DTO를 리스트에 저장
				qsList.add(question);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//자원 해제
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		//조회 결과 반환
		return qsList;
	
	}

	@Override
	public int insert(Connection conn, Member param) {
		
		String sql = "";
		sql += "INSERT INTO member(user_id, user_pw, user_birth, user_gender, pw_questionno, pw_answer, spicy_no, amount_no)";
		sql += " VALUES( ?, ?, ?, ?, ?, ?, ?, ?)";
				
		int result = 0; //INSERT결과 저장 변수
			
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, param.getUser_id());
			ps.setString(2, param.getUser_pw());
			ps.setDate(3, new java.sql.Date(param.getUser_birth().getTime()));
			ps.setString(4, param.getUser_gender());
			ps.setString(5, param.getPw_questionno());
			ps.setString(6, param.getPw_answer());
			ps.setString(7, param.getSpicy_no());
			ps.setString(8, param.getAmount_no());
			
			//INSERT수행
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
	}

	@Override
	public Member selectByIdPw(Connection conn, Member member) {
		
		String sql = "";
		sql += "SELECT user_no, user_id, user_pw FROM member";
		sql += " WHERE user_id = ? AND user_pw = ?";
		
		Member res = null; //조회된 결과를 저장할 객체
		System.out.println("dao 전달 객체");
		System.out.println(member);
		try {
			
			ps = conn.prepareStatement(sql); //SQL수행 객체 생성
			
			ps.setString(1, member.getUser_id());
			ps.setString(2, member.getUser_pw());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과 반환
			
			while(rs.next()) {
				res = new Member();
				
				res.setUser_no(rs.getInt("user_no"));
				res.setUser_id(rs.getString("user_id"));
				res.setUser_pw(rs.getString("user_pw"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		
		return res;
	}

	@Override
	public int loginCheck(Connection conn, Member member) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM MEMBER"; 
		sql += " WHERE user_id = ? AND user_pw = ?";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체 생성
			
			ps.setString(1, member.getUser_id());
			ps.setString(2, member.getUser_pw());
			
			rs = ps.executeQuery();
		
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return result;
	}

	@Override
	public Member checkPw(Connection conn, Member member) {
		
		String sql = "";
		sql += "SELECT user_pw FROM member";
		sql += " WHERE user_id = ? AND pw_questionno = ? AND pw_answer = ?";
		
		Member res = null;
	
		try {
			
			ps = conn.prepareStatement(sql); //SQL수행 객체 생성
			
			ps.setString(1, member.getUser_id());
			ps.setString(2, member.getPw_questionno());
			ps.setString(3, member.getPw_answer());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과 반환
			
			while(rs.next()) {
				res = new Member();
			
				res.setUser_pw(rs.getString("user_pw"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		
		return res;
	}

	@Override
	public int checkId(Connection conn, Member member) {
		
		String sql = "";
		sql += "SELECT count(user_id) cnt FROM MEMBER";
		sql += " WHERE user_id = ?";
		
		System.out.println("MemberDao checkId() userid - " + member);
		System.out.println();
		int res = 0;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, member.getUser_id());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과 반환
				
			if(rs.next()) { //조회결과가 있으면 cnt증가
					
				res = rs.getInt("cnt");
				
			} else {
				res = 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MemberDao checkId() res - " + res);
		return res;
		
	}
	
}




