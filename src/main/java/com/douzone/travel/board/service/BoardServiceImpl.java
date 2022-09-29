package com.douzone.travel.board.service;

import com.douzone.travel.board.domain.BoardDTO;
import com.douzone.travel.board.model.domain.BoardDAO;
import com.douzone.travel.board.model.domain.BoardDAOImpl;

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
