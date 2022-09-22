package service.post;

import model.domain.file.FileDAO;
import model.domain.file.FileDAOImpl;
import model.domain.post.PostDAO;
import model.domain.post.PostDAOImpl;

public class PostServiceImpl implements PostService{
    private static PostServiceImpl instance = new PostServiceImpl();
    PostDAO PostDAO = PostDAOImpl.getInstance();

    private PostServiceImpl(){ }

    public PostServiceImpl getInstance(){
        return instance;
    }
}
