package com.douzone.travel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.travel.domain.UserDTO;
import com.douzone.travel.service.user.UserService;
import com.douzone.travel.service.user.UserServiceImpl;

public class UserInfoController implements Command {
	
	private final UserService userService = UserServiceImpl.getInstance();
	
	
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO user = null; 
        
    	try {
    		HttpSession session = req.getSession();
    		String id = (String)session.getAttribute("username");
            user = userService.selectUser(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(user == null){
        	System.out.println("정상적으로 안됨 ㅋㅋ");
            return "error.jsp";
        }else{
        	System.out.println("정상적으로 됨");
        	req.setAttribute("user", user);
            req.setAttribute("status", "profile");
        	return "image-load.do";
        }
    }
}	
