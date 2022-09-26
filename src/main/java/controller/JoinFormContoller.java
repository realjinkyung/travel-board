package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserDTO;
import service.user.UserService;
import service.user.UserServiceImpl;

public class JoinFormContoller implements Command{
	
	UserService userService = UserServiceImpl.getInstance();

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = (String)req.getParameter("username"); // 아이디
		String pw = (String)req.getParameter("password");
		String pwc = (String)req.getParameter("passwordCheck");
      	String name = (String)req.getParameter("name");
		Date birth = Date.valueOf(req.getParameter("birth"));
		String phoneNumber = (String)req.getParameter("phoneNumber");
		String email = (String)req.getParameter("email");
		String gender = (String)req.getParameter("gender");
	
		
//		userService.메소드()
		// 데이터값 입력 유무만 유효성 검증
		if(username == null || username.trim().length() == 0 ||
			pw == null || pw.trim().length() == 0 ||
			pwc == null || pwc.trim().length() == 0 ||
			name == null || name.trim().length() == 0 ||
			birth == null ||
			email == null || email.trim().length() == 0 ||
			gender == null || gender.trim().length() == 0 ){
		} 
		
		boolean result = false;
		
		try {
			result = userService.writeContent(new UserDTO(1L,username,name,pw,"",0,true,"",phoneNumber,email,birth,gender));
			System.out.println("결과 : " + result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result) {
			return "joinSuccess.jsp";
		}else {
			return "redirect:error.jsp";
		}
	}
	
}
