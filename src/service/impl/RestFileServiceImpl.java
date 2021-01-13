package service.impl;

import common.JDBCTemplate;
import dao.face.RestFileDao;
import dao.impl.RestFileDaoImpl;
import dto.Rest_photo_table;
import dto.Rest_review_table;
import service.face.RestFileService;

public class RestFileServiceImpl implements RestFileService {
	
	private RestFileDao fileDao = new RestFileDaoImpl();
	
	
	@Override
	public void insertFile(Rest_photo_table up, Rest_review_table rest_review) {
		// DAO 를 통해 insert 수행
		int result = fileDao.insertFile(JDBCTemplate.getConnection(), up, rest_review);
		// insertFile 이 이미 있음 >> 추가 개발 필요 X
		
		if(result > 0) {
			JDBCTemplate.commit(JDBCTemplate.getConnection());
		} else {
			JDBCTemplate.rollback(JDBCTemplate.getConnection());
		}
		
	} // insertFile(UploadFile up) end
	
} // class FileServiceImple end
