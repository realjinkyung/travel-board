package model.domain.user;

public class UserDAOImpl implements UserDAO{

    private static UserDAO instance = new UserDAOImpl();

    private UserDAOImpl() {
    }

    public static UserDAO getInstance(){
        return instance;
    }
}
