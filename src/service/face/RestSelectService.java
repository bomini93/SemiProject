package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import com.sun.javadoc.Parameter;

import common.Paging;
import dto.Rest_info;

public interface RestSelectService {

	//�쟾泥� �럹�씠吏�
	Paging getPagingSelect(HttpServletRequest req);
	
	Paging getPagingCategory(HttpServletRequest req, String condition);
	
	Paging getPagingEtc(HttpServletRequest req);
	
	List<Rest_info> restSelect(Paging paging);

	List<Rest_info> restCategory(Paging paging, String condition);

	List<Rest_info> restEtc(Paging paging);
	
	

}
