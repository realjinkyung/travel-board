package model.domain.board;

import domain.BoardDTO;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOImpl implements BoardDAO {
    private static BoardDAO instance = new BoardDAOImpl();

    private BoardDAOImpl() {
    }

    public static BoardDAO getInstance(){
        return instance;
    }

    @Override
    public void create() {

    }

    public List<BoardDTO> findAll() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<BoardDTO> boardList = new ArrayList<>();

        con = DBUtils.getConnection();
        pstmt = con.prepareStatement("select * from board");
        rset = pstmt.executeQuery();

        while (rset.next()){
            boardList.add(BoardDTO.builder()
                    .boardNo(rset.getLong("board_no"))
                    .boardName(rset.getString("board_name")).build());
        }

        DBUtils.close(con,pstmt,rset);
      return boardList;
    }
}
