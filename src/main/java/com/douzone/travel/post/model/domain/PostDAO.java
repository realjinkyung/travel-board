package com.douzone.travel.model.domain.post;

import com.douzone.travel.domain.PostDTO;
import com.douzone.travel.domain.PostViewDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface PostDAO {
	// 로그인 1줄

	public ArrayList<HashMap<String, Object>> selectPostList(int pageNumber, String board, String searchOption, String searchContent);
	public int selectPostCount();
    PostViewDTO findByPostNo(Long postNo, boolean status) throws SQLException;
    int insertPost(PostDTO postDTO, String username) throws SQLException;
    Long findPostByTitleAndContent(String title, String content) throws SQLException;

    int updatePost(PostDTO postDTO) throws SQLException;

    int deletePost(Long postNo) throws SQLException;
}
