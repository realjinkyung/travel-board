package service.post;

import java.util.ArrayList;
import java.util.HashMap;

import domain.PostDTO;

import domain.PostViewDTO;
import model.domain.post.PostDAO;
import model.domain.post.PostDAOImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public PostViewDTO getByPostNo(Long postNo, boolean status) throws SQLException {
        PostViewDTO postDTO = postDAO.findByPostNo(postNo, status);
        return postDTO;
    }

    @Override
    public Long createPost(HttpServletRequest req) throws SQLException {

        Long result = 0L;
        String postNo = req.getParameter("postNo");

        if(Objects.equals("", postNo)) {
            result = Long.valueOf(postDAO.insertPost(makePostDTO(req,"insert",postNo), (String)req.getSession().getAttribute("username")));

            if(result==1){

                return postDAO.findPostByTitleAndContent(req.getParameter("title"), req.getParameter("content"));
            }

        }else{

            result = Long.valueOf(postDAO.updatePost(makePostDTO(req,"modify", postNo))); // 게시글 수정

            if(result==1){
                return Long.valueOf(postNo);
            }
        }

        return result;

    }

    @Override
    public int erasePost(HttpServletRequest req) throws SQLException {
        Long postNo = Long.valueOf(req.getParameter("postNo"));
        return postDAO.deletePost(postNo);
    }

    private PostDTO makePostDTO(HttpServletRequest req, String schedule, String postNo){
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        // Long userNo = Long.parseLong(req.getParameter("userNo"));
        Long boardNo = Long.parseLong(req.getParameter("boardNo"));
        PostDTO postDTO = null;

        if(schedule.equals("insert")){
            postDTO = PostDTO.builder()
                    .title(title)
                    .content(content)
                    .boardNo(boardNo).build();

        } else if(schedule.equals("modify")){		// [ 게시글 수정 ]
            postDTO = PostDTO.builder()
<<<<<<< HEAD
                    .postNo(Long.parseLong(postNo))	// 게시글 번호
                    .title(title)					// 게시글 제목
                    .content(content)				// 게시글 내용
                    .userNo(userNo)					// 사용자 번호?
                    .boardNo(boardNo).build();		// 게시판 번호
=======
                    .postNo(Long.parseLong(postNo))
                    .title(title)
                    .content(content)
                    .boardNo(boardNo).build();
>>>>>>> af51c7d18fb95c8d5a963c33b2add4e4b39c4ecd

        }
        return postDTO;
    }

}
