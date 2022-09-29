package com.douzone.travel.model.domain.file;

import com.douzone.travel.domain.PostViewDTO;
import com.douzone.travel.domain.UserDTO;

import java.sql.SQLException;

public interface FileDAO{

    int insertImage(Long userId, String imagePath) throws SQLException;

    String findByUserId(UserDTO user) throws SQLException;

    String findByPostId(PostViewDTO post) throws SQLException;

    int insertPostImage(Long postNo, String fileName) throws SQLException;
}
