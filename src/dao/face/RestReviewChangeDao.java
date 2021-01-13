package dao.face;

import java.sql.Connection;

import dto.Rest_review_table;

public interface RestReviewChangeDao {

	public int update(Connection conn, int review_no, Rest_review_table review_table);

}