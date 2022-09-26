package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserDTO;
import service.user.UserService;
import service.user.UserServiceImpl;

public class LoginController implements Command {
	
	UserService userService = UserServiceImpl.getInstance();

	// getParameter는 jsp와 똑같이 name
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = (String)req.getParameter("id"); // 아이디
		String password = (String)req.getParameter("pw"); // 비밀번호
		
		System.out.println("id" + username);
		System.out.println("pw" + password);
		
		if(username == null || username.trim().length() == 0 ||
			password == null || password.trim().length() == 0) {
			UserDTO user = UserDTO.builder().username(username).password(password).build();
			
			userService.login(user);
		}
		
		boolean result = false;	
		
		return "loginSuccess.jsp";
	}

}
