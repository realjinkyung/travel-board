package controller;

import domain.PostDTO;
import domain.PostViewDTO;
import service.post.PostService;
import service.post.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class PostReadController implements Command {
    PostService postService = PostServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long postNo = Long.parseLong(req.getParameter("postNo")); // FIXME 변수명 서로 확인하고 맞출 것
        PostViewDTO postViewDTO = postService.getByPostNo(postNo);

        req.setAttribute("postview", postViewDTO);
        return "post.jsp";
    }
}
