package com.douzone.travel.controller;

import com.douzone.travel.domain.UserDTO;
import com.douzone.travel.service.user.UserService;
import com.douzone.travel.service.user.UserServiceImpl;

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
        }

        return null;
    }
}
