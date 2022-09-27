package service.post;

import java.util.ArrayList;
import java.util.HashMap;

import domain.PostDTO;
import model.domain.file.FileDAO;
import model.domain.file.FileDAOImpl;

import domain.PostDTO;
import domain.PostViewDTO;
import model.domain.post.PostDAO;
import model.domain.post.PostDAOImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Objects;

public class PostServiceImpl implements PostService{
    private static PostServiceImpl instance = new PostServiceImpl();
    PostDAO postDAO = PostDAOImpl.getInstance();

    private PostServiceImpl(){ }

    public static PostServiceImpl getInstance(){
        return instance;
    }
    
    @Override
    public ArrayList<HashMap<String, Object>> allPostList(int pageNumber, String board, String searchOption, String searchContent){
    	return postDAO.selectPostList(pageNumber, board, searchOption, searchContent);
    }

    @Override
    public int getPostCount() {
    	return postDAO.selectPostCount();
    }
    
    @Override
    public PostViewDTO getByPostNo(Long postNo) throws SQLException {
        PostViewDTO postDTO = postDAO.findByPostNo(postNo);
        return postDTO;
    }

    @Override
    public int createPost(HttpServletRequest req) throws SQLException {

        int result = 0;
        String postNo = req.getParameter("postNo");

        if(Objects.isNull(postNo)) {
            result = postDAO.insertPost(makePostDTO(req,"insert",postNo));
        }else{

            result = postDAO.updatePost(makePostDTO(req,"modify", postNo));
        }

        return result;
    }

    private PostDTO makePostDTO(HttpServletRequest req, String schedule, String postNo){
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Long userNo = Long.parseLong(req.getParameter("userNo"));
        Long boardNo = Long.parseLong(req.getParameter("boardNo"));
        PostDTO postDTO = null;

        if(schedule.equals("insert")){
            postDTO = PostDTO.builder()
                    .title(title)
                    .content(content)
                    .userNo(userNo)
                    .boardNo(boardNo).build();

        } else if(schedule.equals("modify")){
            postDTO = PostDTO.builder()
                    .postNo(Long.parseLong(postNo))
                    .title(title)
                    .content(content)
                    .userNo(userNo)
                    .boardNo(boardNo).build();

        }
        return postDTO;
    }

}
