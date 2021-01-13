package dao.face;

import java.sql.Connection;

import dto.Rest_info;

public interface RestLikeDao {

	public int like(Connection conn, String userId, Rest_info rest_info);


	public int likeCancel(Connection conn, String userId, Rest_info rest_info);

}
