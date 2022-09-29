package com.douzone.travel.user.controller;

import com.douzone.travel.Command;
import com.douzone.travel.user.domain.UserDTO;
import com.douzone.travel.user.service.UserService;
import com.douzone.travel.user.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class GetUserController implements Command {
    UserService userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        req.setAttribute("postNo", req.getAttribute("postNo"));
        UserDTO userDTO = userService.selectUser((String) req.getSession().getAttribute("username"));
        req.setAttribute("user", userDTO);

        if(req.getAttribute("status").equals("postImage")) {
            return "image-upload.do";
        }else if(req.getAttribute("status").equals("post")){
            return "comments.do";
        }

        return null;
    }
}
