package com.douzone.travel.board.model.domain;

import com.douzone.travel.board.domain.BoardDTO;

import java.sql.SQLException;
import java.util.List;

public interface BoardDAO {
    public void create();
    public List<BoardDTO> findAll() throws SQLException;
}
