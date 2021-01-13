package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Member;
import dto.Question;

public interface MemberService {

	/**
	 * 질문 전체조회
	 * 
	 * @return 조회된 질문을 List로 반환한다
	 */
	public List<Question> list();

	/**
	 * 전달파라미터들을 객체로 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return 전달된 데이터를 Member객체에 담아서 반환
	 */
	public Member getParam(HttpServletRequest req);

	/**
	 * 전달된 데이터를 이용하여 회원가입 처리
	 * @param param - 클라이언트로부터 전달된 회원 정보 객체
	 * @return DB에 삽입 완료된 회원 정보 객체
	 */
	public void join(Member param);

	
	/**
	 * 사용자 조회
	 * 
	 * @param member - 조회할 사용자 정보를 가진 객체
	 * @return - 조회된 유저의 상세한 정보
	 */
	public Member detail(Member member);

	
	
	public int login(Member member);

	/**
	 * 사용자 정보 상세 조회
	 * 
	 * @param member - 조회할 사용자비밀번호를 가진 객체
	 * @return 조회된 유저의 비밀번호
	 */
	public Member findPw(Member member);

	/**
	 * 아이디 중복 확인
	 * 
	 * @param member - 아이디 조회
	 * @return 중복아이디가 있는지 없는지 결과값 반환
	 */
	public int idCheck(Member member);

	
	



}
