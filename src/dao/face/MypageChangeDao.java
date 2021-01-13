package dao.face;

import java.sql.Connection;

import dto.Member;

public interface MypageChangeDao {
	public int update(Connection conn, String userId, Member member);
}
