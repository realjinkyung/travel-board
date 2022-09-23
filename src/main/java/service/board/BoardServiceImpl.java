package service.board;

import domain.BoardDTO;
import model.domain.board.BoardDAO;
import model.domain.board.BoardDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class BoardServiceImpl implements BoardService {

    private static BoardService instance = new BoardServiceImpl();
    BoardDAO boardDAO = BoardDAOImpl.getInstance();
    private BoardServiceImpl(){ }

    public static BoardService getInstance(){
        return instance;
    }

    @Override
    public void create() {

    }

    @Override
    public List<BoardDTO> readAll() throws SQLException {

        return boardDAO.findAll();
    }
}
