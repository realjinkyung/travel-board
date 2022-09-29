package com.douzone.travel.comment.service;

import com.douzone.travel.comment.domain.CommentViewDTO;
import com.douzone.travel.comment.model.domain.CommentDAO;
import com.douzone.travel.comment.model.domain.CommentDAOImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommentServiceImpl implements CommentService{
    private static CommentService instance = new CommentServiceImpl();
    CommentDAO commentDAO = CommentDAOImpl.getInstance();

    private CommentServiceImpl(){ }

    public static CommentService getInstance(){
        return instance;
    }

    @Override
    public List<CommentViewDTO> getAllComments(Long postNo) throws SQLException {

        return commentDAO.findAll(postNo);
    }

    @Override
    public int createComment(String commentContent, Long postNo) throws SQLException {

        return commentDAO.insertComment(commentContent, postNo);
    }

    @Override
    public int eraseComment(Long commentNo) throws SQLException {

        return commentDAO.deleteComment(commentNo);
    }

    @Override
    public int modifyComment(HttpServletRequest req) throws SQLException {
        String username = req.getParameter("username");
        String comment = req.getParameter("updateComment");
        Long commentNo = Long.valueOf(req.getParameter("commentNo"));

        // HttpSession session = req.getSession(false);
        // Long SessionUsername = (Long) session.getAttribute("username");


        // if(SessionUsername.equals(username)){
            return commentDAO.updateComment(commentNo, username, comment);
        // }

        // return 0;

    }
    
    @Override
    public ArrayList<HashMap<String, Object>> getAllComment(Long postNo) {
    	ArrayList<HashMap<String, Object>> commentList = null;
    	try {
			 commentList = commentDAO.selectAllComments(postNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return commentList;
    }
}
