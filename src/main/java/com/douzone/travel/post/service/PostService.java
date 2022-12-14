package com.douzone.travel.post.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.douzone.travel.post.domain.PostViewDTO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface PostService {
	
	// ??
	public ArrayList<HashMap<String, Object>> allPostList(int pageNumber, String board, String searchOption, String searchContent);
	public int getPostCount(String board);
	public int selectPostCount(int pageNumber, String board, String searchOption, String searchContent);	
	
    PostViewDTO getByPostNo(Long postNo, boolean b) throws SQLException;

    Long createPost(HttpServletRequest req) throws SQLException;

    int erasePost(HttpServletRequest req) throws SQLException;

}
