package controller;

import java.io.IOException;
import java.sql.Date;

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
		String username = (String)req.getAttribute("username");
		String pw = (String)req.getAttribute("password");
		String pwc = (String)req.getAttribute("passwordCheck");
      	String name = (String)req.getAttribute("name");
		Date birth = (Date)req.getAttribute("birth");
		String email = (String)req.getAttribute("email");
		String gender = (String)req.getAttribute("gender");
	
//		userService.메소드()
		// 데이터값 입력 유무만 유효성 검증
		if(username == null || username.trim().length() == 0 ||
			pw == null || pw.trim().length() == 0 ||
			pwc == null || pwc.trim().length() == 0 ||
			name == null || name.trim().length() == 0 ||
			birth == null ||
			email == null || email.trim().length() == 0 ||
			gender == null || gender.trim().length() == 0 ){
//			req.getParameter("join.jsp");
		}
		return "redirect:error.jsp"; // ? write() 메소드 종료
		
		boolean result = false;
		
		try {
			// 인터페이스 만들기
//			result = userService.writeContent(new UserDTO(userId,userPW1,userName,userBirth,userEmail));
			result = userService.writeContent(new UserDTO(username,pw,name,birth,email));
		} catch (SQLException e) {
			e.printStackTrace();
//			request.setAttribute("error", "게시글 저장 시도 실패 재 시도 하세요");
		}
		
		// redirect: 서버가 접속하는사람(클라이언트)한테 다시 연결하라고 말해 줌, 연결만 다시 해 줌  
		// forward : 접속자에게 말안하고 서버에서 알아서 처리함, 값 전달 + 연결
		if(result){
			return "join.do";
		}else{
			return "redirect:error.jsp";
		}
	}
		
		
		
//		return null;
	}
	
}
