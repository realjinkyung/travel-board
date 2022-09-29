package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.UserDTO;
import service.user.UserService;
import service.user.UserServiceImpl;

public class UserReviseController implements Command {
private final UserService userService = UserServiceImpl.getInstance();
<<<<<<< HEAD
=======
	
>>>>>>> af51c7d18fb95c8d5a963c33b2add4e4b39c4ecd

	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDTO user = null;
        int result = 0;
		String id ="";
        Date birth = Date.valueOf(req.getParameter("birth"));

        user = UserDTO.builder()
        		.name(req.getParameter("name"))
        		.birth(birth)
        		.gender(req.getParameter("gender"))
        		.email(req.getParameter("email"))
        		.phoneNumber(req.getParameter("phoneNumber"))
        		.build();
<<<<<<< HEAD
        
    	try {
    		HttpSession session = req.getSession(false); 			// 세션생성 - false 있는걸 가져옴
    		String id = (String)session.getAttribute("username");// setAttribute("username")-> tomcat자동생성 방지
    		result = userService.updateUser(id, user);    		    		
=======

    	try {
    		HttpSession session = req.getSession();
			id = (String)session.getAttribute("username");
    		result = userService.updateUser(id, user);
>>>>>>> af51c7d18fb95c8d5a963c33b2add4e4b39c4ecd
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    	
        if(result == 0){
            return "error.jsp";
        }
			UserDTO userForModify = userService.selectUser(id);
			req.setAttribute("user", userForModify);
			req.setAttribute("status", "profileImage");

			return "image-upload.do";

		// return "redirect:userinfo.do";
    }
}	
