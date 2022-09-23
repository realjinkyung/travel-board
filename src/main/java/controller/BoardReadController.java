package controller;

import domain.BoardDTO;
import service.board.BoardServiceImpl;
import service.board.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class BoardReadController implements Command {

    private final BoardService boardService = BoardServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BoardDTO> boardDTOList;
        try {
            boardDTOList = boardService.readAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(Objects.isNull(boardDTOList)){
            return "error.jsp";
        }else{
            req.setAttribute("boardList", boardDTOList);
            return "board.jsp";
        }
    }

}
