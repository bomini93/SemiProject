package dao.face;

import java.sql.Connection;
import java.util.List;

import common.Paging;
import dto.Rest_info;

public interface RestSelectDao {
	
	public List<Rest_info> restSelect(Connection conn, Paging paging);
	
	public List<Rest_info> restCategory(Connection conn, Paging paging, String condition);
	
	public List<Rest_info> restEtc(Connection conn, Paging paging);
	
	public int restSelectCnt(Connection conn);
		
	public int restEtcCnt(Connection conn);

	public int restCategoryCnt(Connection connection, String condition);
}
