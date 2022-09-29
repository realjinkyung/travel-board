package com.douzone.travel.user.model.domain;

import com.douzone.travel.user.domain.UserDTO;

public interface UserDAO {

	 public boolean login(UserDTO user); // 로그인
	public boolean insertUser(UserDTO user);
	 public UserDTO selectUser(String username);
	 public int updateUser(String username, UserDTO userRevise);

}
