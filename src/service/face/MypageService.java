package service.face;

import java.util.List;

import dto.Member;
import dto.Recipe_Table;
import dto.Rest_info;

public interface MypageService {

	public List<Member> list(String userId);

	public List<Rest_info> restlike(String userId);

	public List<Recipe_Table> recipelike(String userId);

}
