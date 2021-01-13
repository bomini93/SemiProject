package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.Member;

public interface AdminMemberService {


	public List<Member> getList(Paging paging);
	
	
	public Paging getPaging(HttpServletRequest req);


	public List<Member> getList();


	public int withdrawal(Member member);
	
}
