package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Member;
import dto.Recipe_Table;
import dto.Rest_info;
import dto.Rest_like_table;

public interface MypageDao {

	public List<Member> selectAll(Connection conn, String userId);

	public List<Rest_info> restlike(Connection conn, String userId);

	public List<Recipe_Table> recipelike(Connection conn, String userId);
}
