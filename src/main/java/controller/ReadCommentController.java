package controller;

import domain.CommentDTO;
import domain.CommentViewDTO;
import domain.PostViewDTO;
import service.comment.CommentService;
import service.comment.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReadCommentController implements Command {
    CommentService commentService = CommentServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<CommentViewDTO> commentDTOList = commentService.getAllComments(((PostViewDTO)req.getAttribute("postview")).getPostNo());
        req.setAttribute("comments", commentDTOList);

        return "post.jsp";
    }
}
