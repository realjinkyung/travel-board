package service.user;

import domain.UserDTO;

public interface UserService {
	// 회원가입
	public String writeContent(UserDTO user, String pwc);

	// 로그인
	public boolean login(UserDTO user);
}
