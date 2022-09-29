package com.douzone.travel.comment.service;

import com.douzone.travel.comment.domain.CommentViewDTO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface CommentService {
    List<CommentViewDTO> getAllComments(Long postView) throws SQLException;

    int createComment(String commentContent, Long postNo) throws SQLException;

    int eraseComment(Long commentNo) throws SQLException;

    int modifyComment(HttpServletRequest req) throws SQLException;
    
    
    
    
    
    
    
    
    
    
    
    
    
    ArrayList<HashMap<String, Object>> getAllComment(Long postNo);
}
