package service.board;

import domain.BoardDTO;

import java.sql.SQLException;
import java.util.List;

public interface BoardService {

    public void create();
    public List<BoardDTO> readAll() throws SQLException;
}
