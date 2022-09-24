package model.domain.post;

import domain.PostDTO;
import domain.PostViewDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface PostDAO {
	// 로그인 1줄
	public ArrayList<HashMap<String, Object>> selectPostList(int pageNumber);
    PostViewDTO findByPostNo(Long postNo) throws SQLException;

    int insertPost(PostDTO postDTO) throws SQLException;

    int updatePost(PostDTO postDTO) throws SQLException;

}
