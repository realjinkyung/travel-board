package service.comment;

import model.domain.comment.CommentDAO;
import model.domain.comment.CommentDAOImpl;

public class CommentServiceImpl implements CommentService{
    private static CommentService instance = new CommentServiceImpl();
    CommentDAO commentDAO = CommentDAOImpl.getInstance();

    private CommentServiceImpl(){ }

    public CommentService getInstance(){
        return instance;
    }
}
