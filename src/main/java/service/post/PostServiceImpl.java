package service.post;

import java.util.ArrayList;
import java.util.HashMap;

import domain.PostDTO;
import model.domain.file.FileDAO;
import model.domain.file.FileDAOImpl;
import model.domain.post.PostDAO;
import model.domain.post.PostDAOImpl;

public class PostServiceImpl implements PostService{
    private static PostServiceImpl instance = new PostServiceImpl();
    PostDAO PostDAO = PostDAOImpl.getInstance();

    private PostServiceImpl(){ }

    public static PostServiceImpl getInstance(){
        return instance;
    }
    
    @Override
    public ArrayList<HashMap<String, Object>> allPostList(int pageNumber) {
    	
    	return PostDAO.selectPostList(pageNumber);
    }
}
