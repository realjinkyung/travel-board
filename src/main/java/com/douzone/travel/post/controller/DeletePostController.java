package com.douzone.travel.post.controller;

import com.douzone.travel.Command;
import com.douzone.travel.post.service.PostService;
import com.douzone.travel.post.service.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeletePostController implements Command {
    PostService postService = PostServiceImpl.getInstance();


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int result = postService.erasePost(req);

        if(result == 1) {
            return "redirect:boardList.do";
        }else {
            return "redirect:error.jsp";
        }
    }
}
