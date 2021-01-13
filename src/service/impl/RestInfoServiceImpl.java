package service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dao.face.RestCntDao;
import dao.face.RestInfoDao;
import dao.impl.RestCntDaoImpl;
import dao.impl.RestInfoDaoImpl;
import dto.Rest_info;
import service.face.RestInfoService;

public class RestInfoServiceImpl implements RestInfoService{

	private RestInfoDao restinfodao = new RestInfoDaoImpl();
	private RestCntDao restcntdao = new RestCntDaoImpl();
	
	@Override
	public List<Rest_info> restinfolist1(Paging paging) {
		
		Connection conn = JDBCTemplate.getConnection();

		List<Rest_info> restinfolist = restinfodao.selectAll(conn, paging);

		return restinfolist;
	}

	@Override
	public List<Rest_info> restinfolist2(Paging paging) {
		Connection conn = JDBCTemplate.getConnection();

		List<Rest_info> restinfolist = restinfodao.selectKorea(conn, paging);

		return restinfolist;
	}

	@Override
	public List<Rest_info> restinfolist3(Paging paging) {
		Connection conn = JDBCTemplate.getConnection();

		List<Rest_info> restinfolist = restinfodao.selectSnack(conn, paging);

		return restinfolist;
	}

	@Override
	public List<Rest_info> restinfolist4(Paging paging) {
		Connection conn = JDBCTemplate.getConnection();

		List<Rest_info> restinfolist = restinfodao.selectJapan(conn, paging);

		return restinfolist;
	}

	@Override
	public List<Rest_info> restinfolist5(Paging paging) {
		Connection conn = JDBCTemplate.getConnection();

		List<Rest_info> restinfolist = restinfodao.selectChina(conn, paging);

		return restinfolist;
	}

	@Override
	public List<Rest_info> restinfolist6(Paging paging) {
		Connection conn = JDBCTemplate.getConnection();

		List<Rest_info> restinfolist = restinfodao.selectWestern(conn, paging);

		return restinfolist;
	}

	@Override
	public List<Rest_info> restinfolist7(Paging paging) {
		Connection conn = JDBCTemplate.getConnection();

		List<Rest_info> restinfolist = restinfodao.selectEtc(conn, paging);

		return restinfolist;

	}
	

	@Override
	public Rest_info detail(Rest_info rest_info) {
		Connection conn = JDBCTemplate.getConnection();
		
		Rest_info res = restinfodao.selectByRest_no(conn, rest_info);
		
		return res;
	}
	
	@Override
	public Paging getPaging1(HttpServletRequest req) {
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = restcntdao.selectCntAll(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public Paging getPaging2(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = restcntdao.selectCntKorean(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public Paging getPaging3(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = restcntdao.selectCntSnack(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public Paging getPaging4(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = restcntdao.selectCntJapan(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public Paging getPaging5(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = restcntdao.selectCntChina(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public Paging getPaging6(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = restcntdao.selectCntWestern(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public Paging getPaging7(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = restcntdao.selectCntEtc(JDBCTemplate.getConnection());
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
}
