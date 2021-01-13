package service.face;

import dto.Rest_photo_table;
import dto.Rest_review_table;

public interface RestFileService {
	

	/**
	 * 업로드 된 파일의 정보를 DB 에 기록하기
	 * @param up - 업로드 된 파일의 정보
	 */
	public void insertFile(Rest_photo_table up, Rest_review_table rest_review);
}
