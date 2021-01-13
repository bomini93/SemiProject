package dao.face;

import java.sql.Connection;
import java.util.List;

import common.Paging;
import dto.Rest_info;

public interface RestInfoDao {
	
	/**
	 * 전체 별점 순 조회
	 * @param conn - DB 연결 객체
	 * @return 조회된 전체 리스트를 반환
	 */
	public List<Rest_info> selectAll(Connection conn,Paging paging);
	
	/**
	 * 한식 별점 순조회
	 * @param conn
	 * @return 조회된 한식 리스트를 반환
	 */
	public List<Rest_info> selectKorea(Connection conn,Paging paging);

	/**
	 * 양식 별점 순 조회
	 * @param conn
	 * @return 조회된 양식 리스트를 반환
	 */
	public List<Rest_info> selectWestern(Connection conn,Paging paging);
	
	/**
	 * 중식 별점 순 조회
	 * @param conn
	 * @return 조회된 중식 리스트를 반환
	 */
	public List<Rest_info> selectChina(Connection conn,Paging paging);
	
	/**
	 * 일식 별점 순 조회 
	 * @param conn
	 * @return 조회된 일식 리스트를 반환
	 */
	public List<Rest_info> selectJapan(Connection conn,Paging paging);
	
	/**
	 * 분식 별점순 조회
	 * @param conn
	 * @return 조회된 분식 리스트를 반환
	 */
	public List<Rest_info> selectSnack(Connection conn,Paging paging);

	/**
	 * 기타 별점 순 조회
	 * @param conn
	 * @return 조회된 기타 리스트를 반환
	 */
	public List<Rest_info> selectEtc(Connection conn,Paging paging);

	public Rest_info selectByRest_no(Connection conn, Rest_info rest_info);
	

}
