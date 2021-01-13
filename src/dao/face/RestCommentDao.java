package dao.face;

import java.sql.Connection;

import dto.Rest_photo_table;
import dto.Rest_review_table;

public interface RestCommentDao {
	
	   public int insertFile(Connection connection, Rest_photo_table uploadFile);

	public int insertreview(Connection conn, Rest_review_table params);

	public int searchreviewno(Connection conn, Rest_review_table params);
	   
	   
	   
}
