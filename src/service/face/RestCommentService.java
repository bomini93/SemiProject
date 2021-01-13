package service.face;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

import dto.Rest_photo_table;
import dto.Rest_review_table;

public interface RestCommentService {
	/**
	 * 업로드된 파일의 정보를 db에 기록하기
	 * 
	 * @param up - 업로드된 파일의 정보
	 */
	public void insertFile(Rest_photo_table up);

	public Rest_review_table getParam(MultipartRequest mul);

	public void insertreview(Rest_review_table params);

	public int searchreviewno(Rest_review_table params);

}
