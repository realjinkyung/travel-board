package service.user;

import java.util.regex.Pattern;

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
    public String writeContent(UserDTO user, String pwc) {
    	String patternEmail = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
    	
    	if(!user.getPassword().equals(pwc)) {
    		return "패스워드";
    	} else if (!Pattern.matches(patternEmail, user.getEmail())){
    		return "비밀번호";
    	} else {
    		userDAO.insertUser(user);
    		return "";
    	}
    }
    
 	// 로그인
 	@Override
	public boolean login(UserDTO user) {
 		// 회원가입된 정보 ID, PW == 입력한 정보 ID, PW
 		return userDAO.login(user);
		
	}
 	
 	// 유저확인	
    @Override
    public UserDTO selectUser(String username) {
        
    	return userDAO.selectUser(username);
    }
    
    // 유저정보 수정
    @Override
    public int updateUser(String username, UserDTO userRevise) {
    	
    	
    	return userDAO.updateUser(username, userRevise);
    }
}
