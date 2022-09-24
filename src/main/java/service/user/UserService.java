package service.user;

import domain.UserDTO;

public interface UserService {
	// 회원가입
	public boolean wirteContent(UserDTO user);
//		return 
	// 로그인
	public void login();
}
