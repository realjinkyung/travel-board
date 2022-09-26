package service.user;

import domain.UserDTO;

public interface UserService {
	public boolean Revise();
	public boolean wirteContent(UserDTO user);
	public void login();
	public boolean modifyUser();
	
	// 유저확인
	public UserDTO selectUser(String username);
	
	public int updateUser(String username, UserDTO userRevise);
}
