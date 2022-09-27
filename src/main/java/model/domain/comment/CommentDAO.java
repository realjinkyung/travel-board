package model.domain.comment;

import domain.CommentViewDTO;

import java.sql.SQLException;
import java.util.List;

public interface CommentDAO {

    List<CommentViewDTO> findAll(Long postNo) throws SQLException;

    int insertComment(String commentContent, Long postNo) throws SQLException;

    int deleteComment(Long commentNo) throws SQLException;

    int updateComment(Long commentNo, String username, String comment) throws SQLException;
}
