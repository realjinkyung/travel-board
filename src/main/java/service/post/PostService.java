package service.post;

import domain.PostViewDTO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface PostService {
    PostViewDTO getByPostNo(Long postNo) throws SQLException;

    int createPost(HttpServletRequest req) throws SQLException;
}
