package service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dao.face.RestSelectDao;
import dao.impl.RestSelectDaoImpl;
import dto.Rest_info;
import service.face.RestSelectService;

public class RestSelectServiceImpl implements RestSelectService{
	
	private RestSelectDao restSelectDao = new RestSelectDaoImpl();
	
	//�쟾泥� 媛쒖닔 援ы빐�삤�뒗 �꽌鍮꾩뒪
	@Override
	public Paging getPagingSelect(HttpServletRequest req) {
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = restSelectDao.restSelectCnt(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	//移댄뀒怨좊━蹂� 媛쒖닔 援ы빐�삤�뒗 �꽌鍮꾩뒪
	@Override
	public Paging getPagingCategory(HttpServletRequest req, String condition) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = restSelectDao.restCategoryCnt(JDBCTemplate.getConnection(),condition);
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	//湲고� 媛쒖닔 援ы빐�삤�뒗 �꽌鍮꾩뒪
	@Override
	public Paging getPagingEtc(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = restSelectDao.restEtcCnt(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	//�쟾泥� 由ъ뒪�듃 援ы빐�삤�뒗 �꽌鍮꾩뒪
	@Override
	public List<Rest_info> restSelect(Paging paging) {
		return restSelectDao.restSelect(JDBCTemplate.getConnection(), paging);
	}
	
	//移댄뀒怨좊━ 由ъ뒪�듃 援ы빐�삤�뒗 �꽌鍮꾩뒪
	@Override
	public List<Rest_info> restCategory(Paging paging, String condition) {
		return restSelectDao.restCategory(JDBCTemplate.getConnection(), paging, condition);
	}
	
	@Override
	public List<Rest_info> restEtc(Paging paging) {
		return restSelectDao.restEtc(JDBCTemplate.getConnection(), paging);
	}
}
