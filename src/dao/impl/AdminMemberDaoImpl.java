package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Member;
import common.JDBCTemplate;
import common.Paging;
import dao.face.AdminMemberDao;

public class AdminMemberDaoImpl implements AdminMemberDao
{

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	@Override
	public int selectCntAll(Connection connection) {
		
		//SQL 작성
				String sql = "";
				sql += "SELECT count(*) FROM member";
				
				//결과 저장할 변수
				int totalCount = 0;
				
				try {
					ps = connection.prepareStatement(sql); //SQL수행 객체
					
					rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
					
					//조회 결과 처리
					while(rs.next()) {
						totalCount = rs.getInt(1);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					//DB객체 닫기
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
				
				//최종 결과 반환
				return totalCount;
		
		
	}

	@Override
	public List<Member> selectList(Connection connection, Paging paging) {
		
		//SQL 작성
				String sql = "";
				sql += "SELECT * FROM (";
				sql += " SELECT rownum rnum, A.*FROM";
				sql += " (SELECT * FROM member";
				sql += " ORDER BY user_no)A)";
				sql += " WHERE rnum BETWEEN ? AND ?";
				
				//결과 저장할 List
				List<Member> memberList = new ArrayList<>();
				
				try {
					ps = connection.prepareStatement(sql); //SQL수행 객체
					
					ps.setInt(1, paging.getStartNo());
					ps.setInt(2, paging.getEndNo());
					
					rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
					
					//조회 결과 처리
					while(rs.next()) {
						Member m = new Member(); //결과값 저장 객체
						
						//결과값 한 행 처리
						m.setUser_no( rs.getInt("user_no") );
						m.setUser_id( rs.getString("user_id") );
						m.setUser_birth( rs.getDate("user_birth") );
						m.setUser_gender( rs.getString("user_gender") );
						
						//리스트에 결과값 저장
						memberList.add(m);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					//DB객체 닫기
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
				
				//최종 결과 반환
				return memberList;
		
		
	}

	@Override
	public List<Member> selectList(Connection connection) {
		
		String sql = "";
		sql += "SELECT * FROM member";
		sql += " ORDER BY user_no DESC";
		
		//조회 결과를 저장할 List
		List<Member> list = new ArrayList<>();
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				
				member.setUser_no( rs.getInt("user_no") );
				member.setUser_id( rs.getString("user_id") );
				member.setUser_birth( rs.getDate("user_birth") );
				member.setUser_gender( rs.getString("user_gender") );
				
				
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
		

}

	@Override
	public int memberWithdrawal(Connection conn, Member member) {
		
		String sql = "";
		sql += "DELETE FROM MEMBER";
		sql += " WHERE user_id = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, member.getUser_id());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				res = 1;
			} else {
				res = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}

}











