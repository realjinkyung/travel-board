package model.domain.comment;

public class CommentDAOImpl implements CommentDAO{

    private static CommentDAO instance = new CommentDAOImpl();

    private CommentDAOImpl() {
    }

    public static CommentDAO getInstance(){
        return instance;
    }
}
