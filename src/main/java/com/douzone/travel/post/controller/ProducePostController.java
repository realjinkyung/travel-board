package com.douzone.travel.post.controller;

import com.douzone.travel.Command;
import com.douzone.travel.post.service.PostService;
import com.douzone.travel.post.service.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProducePostController implements Command {
    PostService postService = PostServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long postNo = postService.createPost(req);
        if(req.getParts() != null){

            req.setAttribute("status", "postImage");
            req.setAttribute("postNo", postNo);

            if(req.getPart("image").getSize() != 0) {
                return "image-upload.do";
            }
        }

        return "redirect:post.do?postNo=" + postNo;

    }
}