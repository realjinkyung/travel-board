package model.domain.board;

import domain.BoardDTO;

public interface BoardDAO {
    public void create();
    public BoardDTO findAll();
}
