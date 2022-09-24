package model.domain.user;

import domain.UserDTO;

public interface UserDAO {
	public boolean insertUser(UserDTO user); // 회원가입
	 public boolean login(); // 로그인
}
