package com.douzone.travel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.travel.domain.UserDTO;
import com.douzone.travel.service.user.UserService;
import com.douzone.travel.service.user.UserServiceImpl;

public class UserRevisePageController implements Command {

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
        	return "userRevise.jsp";
        }
    }
}	
