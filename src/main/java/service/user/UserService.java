package service.user;

import domain.UserDTO;

public interface UserService {
	// 회원가입
	public boolean writeContent(UserDTO user);

	// 로그인
	public void login();
}
