package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.Rest_info;

public interface RestInfoService {
	
	/**
	 *  전체 조회
	 * @return 조회된 식당을 list로 반환
	 */
	public List<Rest_info> restinfolist1(Paging paging);

	/**
	 * 한식 조회
	 * @return 조회된 식당을 list로 반환
	 */
	public List<Rest_info> restinfolist2(Paging paging);
	
	/**
	 * 분식 조회
	 * @return 조회된 식당을 list로 반환
	 */
	public List<Rest_info> restinfolist3(Paging paging);

	/**
	 * 일식 조회
	 * @return 조회된 식당을 list로 반환
	 */
	public List<Rest_info> restinfolist4(Paging paging);

	/**
	 * 중식 조회
	 * @return 조회된 식당을 list로 반환
	 */
	public List<Rest_info> restinfolist5(Paging paging);

	/**
	 * 양식 조회
	 * @return 조회된 식당을 list로 반환
	 */
	public List<Rest_info> restinfolist6(Paging paging);

	/**
	 * 기타 조회
	 * @return 조회된 식당을 list로 반환
	 */
	public List<Rest_info> restinfolist7(Paging paging);
	
	/**
	 * 식당 정보 상세 조회
	 * @param rest_info - 조회할 식당 번호를 가진 객체
	 * @return - 조회된 식당의 상세 정보
	 */
	public Rest_info detail(Rest_info rest_info);

	public Paging getPaging1(HttpServletRequest req);
	public Paging getPaging2(HttpServletRequest req);
	public Paging getPaging3(HttpServletRequest req);
	public Paging getPaging4(HttpServletRequest req);
	public Paging getPaging5(HttpServletRequest req);
	public Paging getPaging6(HttpServletRequest req);
	public Paging getPaging7(HttpServletRequest req);

}
