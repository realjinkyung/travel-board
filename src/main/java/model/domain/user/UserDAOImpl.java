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
//			FileDTo fiel = new FileDTO();
			
			
//			if(rset.next()) {
//				if(rset.getString(1).equals(user.get))
//				return 1; // 로그인 성공
//			} 
			
		} catch (SQLException e) {
			// 컨트롤러로 이동
			e.printStackTrace();
		}
		return false;
	}
}

