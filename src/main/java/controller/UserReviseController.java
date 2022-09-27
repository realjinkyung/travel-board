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
	
	
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("modifyTest");
		UserDTO user = null;
        int result = 0;
        Date birth = Date.valueOf(req.getParameter("birth"));
        user = UserDTO.builder()
        		.profilePath("img_path")
        		.name(req.getParameter("name"))
        		.birth(birth)
        		.gender(req.getParameter("gender"))
        		.email(req.getParameter("email"))
        		.phoneNumber(req.getParameter("phoneNumber"))
        		.build();
        
        		
 
    	try {
    		HttpSession session = req.getSession();
    		String id = (String)session.getAttribute("username");
    		result = userService.updateUser(id, user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    	
        if(result == 0){
            return "error.jsp";
        }else{
        	return "redirect:userinfo.do";
        }
    }
}	
