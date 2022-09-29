package com.douzone.travel.service.user;

import com.douzone.travel.domain.UserDTO;

public interface UserService {

	public String writeContent(UserDTO user, String pwc);
	// 로그인
	public boolean login(UserDTO user);

	public boolean Revise();
	public boolean modifyUser();
	// 유저확인
	public UserDTO selectUser(String username);
	
	public int updateUser(String username, UserDTO userRevise);
}
