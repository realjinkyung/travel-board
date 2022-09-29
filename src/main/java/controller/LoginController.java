package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.UserDTO;
import service.user.UserService;
import service.user.UserServiceImpl;

public class LoginController implements Command {
	
	UserService userService = UserServiceImpl.getInstance();

	// getParameter는 jsp와 똑같이 name 맞춰줘야 함
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result = false;
		String username = (String)req.getParameter("id"); // 아이디
		String password = (String)req.getParameter("pw"); // 비밀번호
		
		System.out.println("id" + username);
		System.out.println("pw" + password);
		
		if(username != null || username.trim().length() != 0 || // 아이디, 비밀번호가 null이 아니라면
			password != null || password.trim().length() != 0) {
			UserDTO user = UserDTO.builder().username(username).password(password).build(); // 특정 - 아이디, 비밀번호 2개만 넣으려고
			
			result = userService.login(user); // userService의 
//			userService.login(user);
		}
		
		
		if(result) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			
<<<<<<< HEAD
			return "board.jsp";			
=======
			return "redirect:boardList.do";
>>>>>>> af51c7d18fb95c8d5a963c33b2add4e4b39c4ecd
		} else {
			return "redirect:error.jsp";
		}
		
		
	}

}
