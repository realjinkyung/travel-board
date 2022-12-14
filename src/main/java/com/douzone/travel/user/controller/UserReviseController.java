package com.douzone.travel.user.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.travel.Command;
import com.douzone.travel.user.domain.UserDTO;
import com.douzone.travel.user.service.UserService;
import com.douzone.travel.user.service.UserServiceImpl;

public class UserReviseController implements Command {
private final UserService userService = UserServiceImpl.getInstance();

	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDTO user = null;
        int result = 0;
		String id ="";
        Date birth = null;
		HttpSession session = null;

        
    	try {
			birth = Date.valueOf(req.getParameter("birth"));
			user = UserDTO.builder()
					.name(req.getParameter("name"))
					.birth(birth)
					.gender(req.getParameter("gender"))
					.email(req.getParameter("email"))
					.phoneNumber(req.getParameter("phoneNumber"))
					.build();

    		session = req.getSession(false); 			// 세션생성 - false 있는걸 가져옴
    		id = (String)session.getAttribute("username");// setAttribute("username")-> tomcat자동생성 방지
    		result = userService.updateUser(id, user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    	
        if(result == 0){
            return "error.jsp";
        }
			UserDTO userForModify = userService.selectUser(id);
			req.setAttribute("user", userForModify);

			if(req.getPart("image").getSize() == 0) {
				req.setAttribute("status", "profileImage");
				return "image-upload.do";
			}

			return "/redirect:userinfo.do";

		// return "redirect:userinfo.do";
    }
}	
