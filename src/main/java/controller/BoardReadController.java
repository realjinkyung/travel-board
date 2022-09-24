package controller;

import domain.BoardDTO;
import service.board.BoardServiceImpl;
import service.post.PostService;
import service.post.PostServiceImpl;
import service.board.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class BoardReadController implements Command {

    private final BoardService boardService = BoardServiceImpl.getInstance();
    private final PostService postService = PostServiceImpl.getInstance();
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BoardDTO> boardDTOList;
        ArrayList<HashMap<String, Object>> postList;
        int pageNumber;
        
        try {
        	if(req.getAttribute("pageNumber") == null) {
        		pageNumber = 1;
        	}else {
        		pageNumber = Integer.parseInt((String)req.getAttribute("pageNumber"));
        	}
        	
            boardDTOList = boardService.readAll();
            postList = postService.allPostList(pageNumber);
             
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(Objects.isNull(boardDTOList)){
            return "error.jsp";
        }else{
            req.setAttribute("boardList", boardDTOList);
            req.setAttribute("postList", postList);
            return "board.jsp";
        }
    }

}
