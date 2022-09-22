package service.user;

import model.domain.user.UserDAO;
import model.domain.user.UserDAOImpl;

public class UserServiceImpl implements UserService{
    private static UserService instance = new UserServiceImpl();
    UserDAO userDAO = UserDAOImpl.getInstance();
    private UserServiceImpl(){ }

    public UserService getInstance(){
        return instance;
    }
}
