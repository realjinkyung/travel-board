package com.douzone.travel.board.controller;

import com.douzone.travel.Command;
import com.douzone.travel.board.service.BoardServiceImpl;
import com.douzone.travel.post.service.PostService;
import com.douzone.travel.post.service.PostServiceImpl;
import com.douzone.travel.board.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class BoardReadController implements Command {

    private final BoardService boardService = BoardServiceImpl.getInstance();
    private final PostService postService = PostServiceImpl.getInstance();
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<HashMap<String, Object>> postList;
        int postCount;
        int pageNumber;
        String board;
        String searchOption;
        String searchContent;
        try {
        	if(req.getParameter("page_number") == null || req.getParameter("page_number").equals("")) {
        		pageNumber = 1;
        	}else {
        		pageNumber = Integer.parseInt(req.getParameter("page_number"));
        	}
        	
        	if(req.getParameter("board") == null || req.getParameter("board").equals("")) {
        		board = "all";
        	}else {
        		board = req.getParameter("board");
        	}
        	
        	searchOption = req.getParameter("search_option");
        	searchContent = req.getParameter("search_content");
        	
        	if(searchContent != null) {
        		searchContent = searchContent.trim();
        	}
        	
            postList = postService.allPostList(pageNumber, board, searchOption, searchContent);
            postCount = postService.getPostCount();
            
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(Objects.isNull(postList)){
            return "error.jsp";
        }else{
            req.setAttribute("postList", postList);
            req.setAttribute("postCount", postCount);
            return "board.jsp";
        }
    }

}
