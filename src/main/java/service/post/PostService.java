package service.post;

import java.util.ArrayList;
import java.util.HashMap;

import domain.PostDTO;

import domain.PostViewDTO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface PostService {
	
	public ArrayList<HashMap<String, Object>> allPostList(int pageNumber, String board, String searchOption, String searchContent);
	public int getPostCount();

    PostViewDTO getByPostNo(Long postNo) throws SQLException;

    int createPost(HttpServletRequest req) throws SQLException;

}
