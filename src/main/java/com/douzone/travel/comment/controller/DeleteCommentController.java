package com.douzone.travel.comment.controller;

import com.douzone.travel.Command;
import com.douzone.travel.comment.service.CommentService;
import com.douzone.travel.comment.service.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteCommentController implements Command {
    CommentService commentService = CommentServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long commentNo = Long.valueOf(req.getParameter("commentNo"));
            if(commentService.eraseComment(commentNo) == 1){
                return "redirect:post.do?postNo="+req.getParameter("postNo");
            }
        return "error.jsp";
    }
}
