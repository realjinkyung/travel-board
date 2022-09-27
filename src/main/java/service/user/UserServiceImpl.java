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
//    	// 비밀번호 == 비밀번호 재확인
    	if(user.getPassword().equals(pwc)) {  // String이라서 equals, ==으로 비교하면 객체의 주솟값을 비교하게 됨
    		userDAO.insertUser(user);    
    		return "";
    	} 
		return "패스워드";
    }
 	// 로그인
 	@Override
	public boolean login(UserDTO user) {
// 		System.out.println("dao"+user.getUsername());
//		System.out.println("dao"+user.getPassword());
 		return userDAO.login(user);
		// 회원가입된 정보 ID, PW == 입력한 정보 ID, PW
		
	}
}
