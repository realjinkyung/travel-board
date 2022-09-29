package com.douzone.travel.user.service;

import com.douzone.travel.user.domain.UserDTO;

public interface UserService {

	// 회원가입
	public String writeContent(UserDTO user, String pwc);

	// 로그인
	public boolean login(UserDTO user);

	// 유저확인
	public UserDTO selectUser(String username);
	
	// 유저정보 수정
	public int updateUser(String username, UserDTO userRevise);
	
	public boolean updateIsBlinded(String username);
}
