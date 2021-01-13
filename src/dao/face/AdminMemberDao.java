package dao.face;

import java.sql.Connection;
import java.util.List;

import common.Paging;
import dto.Member;

public interface AdminMemberDao {

	public int selectCntAll(Connection connection);

	
	public List<Member> selectList(Connection connection, Paging paging);


	public List<Member> selectList(Connection connection);


	public int memberWithdrawal(Connection conn, Member member);

}
