package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.regex.Pattern;

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

		// 패스워드 + email 유효성 검증
		try {
			String result = userService.writeContent(new UserDTO(1L,username,name,pw,"",0,true,"",phoneNumber,email,birth,gender), pwc);
			
			if("패스워드".equals(result)) {	   		 // 비밀번호가 재확인 비밀번호와 일치하지 않는다면
				req.setAttribute("msg", "입력한 " + result + "와 일치하지 않습니다. 다시 확인해주세요."); // 오류 메시지
				return "error.jsp";  				// 에러시 이동할 페이지
			} else if("이메일".equals(result)) { 		// 이메일 형식이 맞지 않는다면
				req.setAttribute("msg", "입력한 " + result + "이 형식에 맞지 않습니다. 다시 확인해주세요."); // 오류 메시지
				return "error.jsp"; 		  		// 에러시 이동할 페이지
			} else {											// 비밀번호와 이메일 검증이 성공적으로 끝났다면
				return "board.jsp"; 			// 성공시 이동할 페이지 "board.jsp" ?
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;										// ???
	}
}
