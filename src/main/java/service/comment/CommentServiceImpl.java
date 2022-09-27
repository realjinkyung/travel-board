package service.comment;

import domain.CommentViewDTO;
import model.domain.comment.CommentDAO;
import model.domain.comment.CommentDAOImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
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
}
