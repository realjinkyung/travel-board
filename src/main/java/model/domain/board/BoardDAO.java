package model.domain.board;

import domain.BoardDTO;

import java.sql.SQLException;
import java.util.List;

public interface BoardDAO {
    public void create();
    public List<BoardDTO> findAll() throws SQLException;
}
