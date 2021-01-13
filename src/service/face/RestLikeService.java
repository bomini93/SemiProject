package service.face;

import dto.Rest_info;

public interface RestLikeService {

	public void like(String userId, Rest_info rest_info);

	public void likeCancel(String userId, Rest_info rest_info);
}
