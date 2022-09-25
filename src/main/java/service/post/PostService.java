package service.post;

import java.util.ArrayList;
import java.util.HashMap;

import domain.PostViewDTO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface PostService {
	
	public ArrayList<HashMap<String, Object>> allPostList(int pageNumber);

    PostViewDTO getByPostNo(Long postNo) throws SQLException;

    Long createPost(HttpServletRequest req) throws SQLException;

    int erasePost(HttpServletRequest req) throws SQLException;

}
