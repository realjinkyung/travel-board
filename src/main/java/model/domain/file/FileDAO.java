package model.domain.file;

import domain.PostViewDTO;
import domain.UserDTO;

import java.sql.SQLException;

public interface FileDAO{

    int insertImage(Long userId, String imagePath) throws SQLException;

    String findByUserId(UserDTO user) throws SQLException;

    String findByPostId(PostViewDTO post) throws SQLException;

    int insertPostImage(Long postNo, String fileName) throws SQLException;
}
