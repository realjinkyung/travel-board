package controller;

import domain.BoardDTO;
import service.boardservicer.BoardServiceImpl;
import service.boardservicer.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardReadController implements Command {

    private final BoardService boardService = BoardServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardDTO boardDTO = boardService.readAll();

        if(boardDTO==null){
            return "error.jsp";
        }else{
            req.setAttribute(boardDTO);
            return "index.jsp";
        }
        return "List.jsp";
    }

}
