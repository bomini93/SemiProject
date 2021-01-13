package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Member;
import dto.Question;

public interface MemberDao {

	/**
	 * 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return 조회된 Question 목록을 반환
	 */
	public List<Question> selectAll(Connection conn);

	
	/**
	 * Member객체의 값을 테이블에 삽입한다
	 * @param conn - DB연결객체
	 * @param param - 삽입할 정보 객체
	 */
	public int insert(Connection conn, Member param);


	/**
	 * 전달된 id,pw를 이용하여 정보 조회하기
	 * 
	 * @param conn - DB연결객체
	 * @param member - 조회할 유저의 ID,PW를 가진 객체
	 * @return 조회된 유저 정보를 Member객체로 반환한다
	 */
	public Member selectByIdPw(Connection conn, Member member);


	public int loginCheck(Connection conn, Member member);


	/**
	 * 전달된 user_id, pw_questionno, pw_answer을 이용하여 사용자 비밀번호 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @param member 
	 * @return
	 */
	public Member checkPw(Connection conn, Member member);


	/**
	 * 전달된 user_id를 이용하여 중복되는 id가 있는지 조회하기
	 * 
	 * @param conn -- DB연결 객체
	 * @param member
	 * @return
	 */
	public int checkId(Connection conn, Member member);


	







	

}
