package com.douzone.travel.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.travel.Command;
import com.douzone.travel.user.domain.UserDTO;
import com.douzone.travel.user.service.UserService;
import com.douzone.travel.user.service.UserServiceImpl;

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
            return "error.jsp";
        }else{
        	req.setAttribute("user", user);
            req.setAttribute("status", "profile");
        	return "image-load.do";
        }
    }
}	
