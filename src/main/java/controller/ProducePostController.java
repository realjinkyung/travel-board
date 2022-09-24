package controller;

import service.post.PostService;
import service.post.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProducePostController implements Command {
    PostService postService = PostServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        postService.createPost(req);

        return "redirect:post.do?postNo=1";

    }
}
