package controller;

import service.comment.CommentService;
import service.comment.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class editCommentController implements Command {
    CommentService commentService = CommentServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        if(commentService.modifyComment(req) == 1){
             return "redirect:post.do?"+req.getParameter("commentNo");
        }
        return null;
    }
}
