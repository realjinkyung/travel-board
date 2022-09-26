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
    @Override
    public void login() {
    	// TODO Auto-generated method stub
 
    }
    
    @Override
    public boolean modifyUser() {
    	// TODO Auto-generated method stub
    	return false;
    }
    
    @Override
    public boolean Revise() {
    	// TODO Auto-generated method stub
    	return false;
    }
    
    @Override
    public boolean wirteContent(UserDTO user) {
    	// TODO Auto-generated method stub
    	return false;
    }
    
    
    @Override
    public UserDTO selectUser(String username) {
    
    	
    	return userDAO.selectUser(username);
    }
    
    
    @Override
    public int updateUser(String username, UserDTO userRevise) {
    	
    	
    	return userDAO.updateUser(username, userRevise);
    }
    
    
    
//     메소드 - 어떤 기능?
    // 회원가입
// 	public boolean writeContent(UserDTO user) {
// 		// 회원 등록이 되게 ??
// 		userDAO.insertUser(user);
// 		
// 		
// 		
// 	}
// 	
// 	
// 	// 로그인
// 	public void login() {
// 		// 회원가입된 정보 ID, PW == 입력한 정보 ID, PW
// 		// if 로그인 성공 else 실패
// 	}
// 	
//   if() {
//	   
//	   
//   }
//
//@Override
//public boolean wirteContent(UserDTO user) {
//	// TODO Auto-generated method stub
//	return false;
//}else
//	   
//	   
//   }
// 	
 	
}
