package model.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import domain.UserDTO;
import utils.DBUtils;

public class UserDAOImpl implements UserDAO{

    private static UserDAO instance = new UserDAOImpl();

    private UserDAOImpl() {
    }

    public static UserDAO getInstance(){
        return instance;
    }
   
    // 회원가입 기능 - 사용자 등록
	@Override
	public boolean insertUser(UserDTO user) {
		Connection con = null;
	  	PreparedStatement pstmt = null;
	  	int result = 0;
	  	
//	  	System.out.println(user.getBirth()); // test용
	  	try {
				con = DBUtils.getConnection();
				pstmt = con.prepareStatement("insert into user(username, password, name, phonenumber, email, birth, gender) values(?, ?, ?, ?, ?, ?, ?)"); // 로그인 DB 연결
				
				// 파라미터로 받은 user.getXXX()로 값 들고오기
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getName());
				pstmt.setString(4, user.getPhoneNumber());
				pstmt.setString(5, user.getEmail());
				pstmt.setDate(6, user.getBirth());
				pstmt.setString(7, user.getGender());
				
				result = pstmt.executeUpdate(); 
				
				if(result == 1) {
					return true; 
				}
	  	} catch (SQLException e) {
	  		// 컨트롤러로 이동
				e.printStackTrace();
			}
	  	return false; 
	}
    
	// 로그인 기능 - 사용자 로그인
	@Override
	public boolean login(UserDTO user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		boolean result = false;
		
		String sql1 = "select * from user where username = ? and password = ?";
		try {
			con = DBUtils.getConnection();
			pstmt = con.prepareStatement(sql1); // 로그인 DB 연결
			// 파라미터로 받은 user.getXXX()로 값 들고오기
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println("로그인 중");
				return true; // 로그인 성공
			} 
			
		} catch (SQLException e) {
			// 컨트롤러로 이동
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	@Override
	public UserDTO selectUser(String username) {
		Connection con = null;
	  	PreparedStatement pstmt = null;
	  	ResultSet rset = null;
	  	
	  	System.out.println("test user");
	  	UserDTO user = null;
	  	try {
				con = DBUtils.getConnection();
				pstmt = con.prepareStatement("select *from user where username=?"); // 로그인 DB 연결
				
				// 파라미터로 받은 user.getXXX()로 값 들고오기
				pstmt.setString(1, username);
				
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					user = UserDTO.builder()
					.profilePath(rset.getString("profile_path"))
					.username(rset.getString("username"))
					.name(rset.getString("name"))
					.birth(rset.getDate("birth"))
					.gender(rset.getString("gender"))
					.email(rset.getString("email"))
					.phoneNumber(rset.getString("phonenumber"))
					.build();	
				}
	  	} catch (SQLException e) {
	  		// 컨트롤러로 이동
				e.printStackTrace();
			}
	  	
	  	return user;
	}
	
	
	
	
// user updater
	@Override
	public int updateUser(String username, UserDTO userRevise) {
		Connection con = null;
	  	PreparedStatement pstmt = null;
	  	int result = 0;
	  	
	  	try {
				con = DBUtils.getConnection();
				pstmt = con.prepareStatement("update user set profile_path = ?, name = ?, birth = ?, gender = ?, email = ?, phonenumber =?  where username = ?"); // 로그인 DB 연결
				
				// 파라미터로 받은 user.getXXX()로 값 들고오기
				pstmt.setString(1, userRevise.getProfilePath());
				pstmt.setString(2, userRevise.getName());
				pstmt.setDate(3, userRevise.getBirth());
				pstmt.setString(4, userRevise.getGender());
				pstmt.setString(5, userRevise.getEmail());
				pstmt.setString(6, userRevise.getPhoneNumber());
				pstmt.setString(7, username);
				
				if(pstmt.executeUpdate() == 1) {
					return 1;
				}
				System.err.println("result " + result);
	  	} catch (SQLException e) {
	  		// 컨트롤러로 이동
				e.printStackTrace();
			}
	  	
	  	return result;
	}
	
	
	
	
	
	

	
	
	
	
	
}

