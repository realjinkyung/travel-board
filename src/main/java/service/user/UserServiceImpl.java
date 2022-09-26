package service.user;

import domain.UserDTO;
import model.domain.user.UserDAO;
import model.domain.user.UserDAOImpl;

public class UserServiceImpl implements UserService{
    private static UserService instance = new UserServiceImpl();
    UserDAO userDAO = UserDAOImpl.getInstance();
    private UserServiceImpl(){ }

    public static UserService getInstance(){
        return instance;
    }
    
// 메소드 - 어떤 기능?
    // 회원가입
    @Override
    public boolean writeContent(UserDTO user) {
    	// 회원 등록
    	return userDAO.insertUser(user);
    } 	
 	
 	// 로그인
 	@Override
	public boolean login(UserDTO user) {
 		return userDAO.login(user);
		// 회원가입된 정보 ID, PW == 입력한 정보 ID, PW
		// if 로그인 성공 else 실패
		// if else
		
	}

}
