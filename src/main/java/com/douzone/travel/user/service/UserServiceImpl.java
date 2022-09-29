package com.douzone.travel.user.service;

import com.douzone.travel.user.domain.UserDTO;
import com.douzone.travel.user.model.domain.UserDAO;
import com.douzone.travel.user.model.domain.UserDAOImpl;

import java.util.regex.Pattern;


public class UserServiceImpl implements UserService{
    private static UserService instance = new UserServiceImpl();
    UserDAO userDAO = UserDAOImpl.getInstance();
    private UserServiceImpl(){ }

    public static UserService getInstance(){
        return instance;
    }
    
    
    @Override
    public UserDTO selectUser(String username) {
        
    	return userDAO.selectUser(username);
    }
    
    @Override
    public int updateUser(String username, UserDTO userRevise) {
    	
    	
    	return userDAO.updateUser(username, userRevise);
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
 		return userDAO.login(user);
		// 회원가입된 정보 ID, PW == 입력한 정보 ID, PW
	}
 	
 	@Override
 	public boolean updateIsBlinded(String username) {
 		// TODO Auto-generated method stub
 		return userDAO.updateIsBlinded(username);
 	}
}
