package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserDTO;
import service.user.UserService;
import service.user.UserServiceImpl;

public class JoinFormController implements Command{
	
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


		String pattern = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		boolean emailResult = Pattern.matches(pattern, email);
		System.out.println(emailResult);
		
		try {
//			result = userService.writeContent(new UserDTO(1L,username,name,pw,"",0,true,"",phoneNumber,email,birth,gender), pwc);
			if("패스워드".equals(userService.writeContent(new UserDTO(1L,username,name,pw,"",0,true,"",phoneNumber,email,birth,gender), pwc))) {
				req.setAttribute("msg", "입력한 패스워드와 일치하지 않습니다. 다시 확인해주세요.");
				return "error.jsp"; // ? error.jsp의 ${msg} 인자(파라미터) 전달 ex) get방식 : ?id=1234&pw=1111 => 보안을 위해 post방식
//				email @ -> "이메일형식에 맞지 않습니다. @ 확인해주세요."
			} else if(!emailResult) {
				req.setAttribute("msg", "이메일형식에 맞지 않습니다.");
				return "error.jsp"; 
			} else {

				if(req.getParts() != null){
					UserDTO user = userService.selectUser(username);
					req.setAttribute("userId", user.getUserNo());
					req.setAttribute("username", user.getUsername());
					return "image-upload.do";
				}

				return "joinSuccess.jsp";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
}
