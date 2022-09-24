package service.user;

import domain.UserDTO;

public interface UserService {
	public boolean Revise();
	public boolean wirteContent(UserDTO user);
	public void login();
	public boolean modifyUser();
}
