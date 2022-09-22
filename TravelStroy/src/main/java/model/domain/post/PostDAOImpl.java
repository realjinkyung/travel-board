package model.domain.post;

public class PostDAOImpl implements PostDAO {

    private static PostDAO instance = new PostDAOImpl();

    private PostDAOImpl() {
    }

    public static PostDAO getInstance(){
        return instance;
    }
}
