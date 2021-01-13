package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.MypageChangeDao;
import dto.Member;

public class MypageChangeDaoImpl implements MypageChangeDao {

	private int result = 0;

	@Override
	public int update(Connection conn, String userId, Member member) {
		System.out.println("update");
		System.out.println(member);
		System.out.println(userId);
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "";

		sql += "UPDATE Member SET spicy_no = ?, amount_no = ?";
		sql += " WHERE user_id = ?";

		try {

			ps = conn.prepareStatement(sql);

			ps.setString(1, member.getSpicy_no());
			ps.setString(2, member.getAmount_no());
			ps.setString(3, userId);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);

		}

		return result;
	}

}
