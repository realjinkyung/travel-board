package controller.post;

import controller.Command;
import domain.PostDTO;
import domain.PostViewDTO;
import service.post.PostService;
import service.post.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class PostReadController implements Command {	// 게시글 읽는 Controller ?
    PostService postService = PostServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long postNo = Long.parseLong(req.getParameter("postNo")); // FIXME 변수명 서로 확인하고 맞출 것
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        PostViewDTO postViewDTO = postService.getByPostNo(postNo, status);

        req.setAttribute("postview", postViewDTO);

        return "comments.do";
    }
}
