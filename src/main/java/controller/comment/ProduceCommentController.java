package controller.comment;

import controller.Command;
import domain.CommentViewDTO;
import service.comment.CommentService;
import service.comment.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProduceCommentController implements Command {
    CommentService commentService = CommentServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        // FIXME 세션처리 해서 아이디 받아 넣을 것.
        Long postNo = Long.valueOf(req.getParameter("postNo"));
        if(commentService.createComment(req.getParameter("commentContent"), postNo) == 1){
            return "redirect:post.do?postNo="+postNo;
        }
        return "error.jsp";
    }
}
