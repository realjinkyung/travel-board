package model.domain.user;

import domain.UserDTO;

public interface UserDAO {
	public boolean insertUser(UserDTO user);
	 public boolean login();
}
