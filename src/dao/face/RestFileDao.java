package dao.face;

import java.sql.Connection;

import dto.Rest_photo_table;
import dto.Rest_review_table;

public interface RestFileDao {
	
	
	/**
	 * 파일 정보 삽입
	 * @param connection DB 연결 객체
	 * @param uploadFile 저장할 파일 정보 객체
	 */
	public int insertFile(Connection connection, Rest_photo_table uploadFile, Rest_review_table rest_review);
	

}
