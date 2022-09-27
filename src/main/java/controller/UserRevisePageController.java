package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardDTO;
import domain.UserDTO;
import service.board.BoardService;
import service.board.BoardServiceImpl;
import service.user.UserService;
import service.user.UserServiceImpl;

public class UserRevisePageController implements Command {

private final UserService userService = UserServiceImpl.getInstance();
	
	
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO user = null; 
        
    	try {
            user = userService.selectUser("dev");
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
