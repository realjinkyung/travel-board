package controller.post;

import controller.Command;
import service.post.PostService;
import service.post.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class ConnectNewPostController implements Command {
    PostService postService = PostServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

        req.setAttribute("postNo", req.getParameter("postNo"));
        req.setAttribute("title", req.getParameter("title"));
        req.setAttribute("content", req.getParameter("content"));
        
        Date.valueOf(req.getParameter("test"));
        return "writePost.jsp";

    }
}
